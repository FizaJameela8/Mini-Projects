package com.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.user.dao.taskimplement;
import com.user.dto.Tasks;
import com.user.dto.User;

@WebServlet("/deletetask")
public class DeleteTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            session.setAttribute("message", "Please log in first!");
            res.sendRedirect("login.jsp");
            return;
        }

        int userid = user.getId();
        int taskid = Integer.parseInt(req.getParameter("taskid"));

        taskimplement dao = new taskimplement();
        boolean deleted = dao.deletetask(taskid, userid);

        if (deleted) {
            session.setAttribute("message", "Task deleted successfully!");
        } else {
            session.setAttribute("message", "Failed to delete task!");
        }

        // Fetch updated list of tasks
        List<Tasks> list = dao.gettasks(userid);
        req.setAttribute("taskList", list);

        // Forward back to dashboard.jsp
        RequestDispatcher rd = req.getRequestDispatcher("dashbord.jsp");
        rd.forward(req, res);
    }
}
