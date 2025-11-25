package com.servlet;

import java.io.IOException;
import com.user.dao.taskimplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.user.dto.User;

@WebServlet("/updatestatus")
public class UpdateStatus extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("Login.jsp");
            return;
        }

        User u = (User) session.getAttribute("user");
        int taskId = Integer.parseInt(req.getParameter("taskid"));
        boolean newStatus = req.getParameter("status") != null; // checked = true

        taskimplement dao = new taskimplement();
        boolean success = dao.updateTaskStatus(taskId, u.getId(), newStatus);

        if (success) {
            session.setAttribute("message", "Task status updated!");
        } else {
            session.setAttribute("message", "Failed to update task status.");
        }

        // Redirect back to dashboard
        resp.sendRedirect("dashboard");
    }
}
