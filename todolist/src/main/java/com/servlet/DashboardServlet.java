package com.servlet;

import com.user.dao.taskimplement;
import com.user.dto.User;
import com.user.dto.Tasks;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("Login.jsp");
            return;
        }

        User u = (User) session.getAttribute("user");
        taskimplement dao = new taskimplement();
        List<Tasks> list = dao.gettasks(u.getId());

        req.setAttribute("taskList", list);
        RequestDispatcher rd = req.getRequestDispatcher("dashbord.jsp");
        rd.forward(req, resp);
    }
}
