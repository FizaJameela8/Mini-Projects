package com.servlet;

import java.io.IOException;
import java.util.List;

import com.user.dao.taskimplement;
import com.user.dto.Tasks;
import com.user.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addtask")
public class Addtask extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false); // use false to avoid creating a new session
        if (session == null || session.getAttribute("user") == null) {
            // If user not logged in, redirect to login page
            resp.sendRedirect("Login.jsp");
            return;
        }

        User u = (User) session.getAttribute("user");
        String taskText = req.getParameter("task");

        if (taskText == null || taskText.trim().isEmpty()) {
            session.setAttribute("message", "Task cannot be empty!");
            RequestDispatcher rd = req.getRequestDispatcher("dashbord.jsp");
            rd.forward(req, resp);
            return;
        }

        // Save the task in DB
        taskimplement dao = new taskimplement();
        boolean success = dao.addtask(u.getId(), taskText);

        if (success) {
            session.setAttribute("message", "Task added successfully!");
        } else {
            session.setAttribute("message", "Failed to add task. Try again.");
        }

        // Fetch updated task list
        List<Tasks> list = dao.gettasks(u.getId());
        req.setAttribute("taskList", list);

        // Forward back to dashboard
        RequestDispatcher rd = req.getRequestDispatcher("dashbord.jsp");
        rd.forward(req, resp);
    }
}
