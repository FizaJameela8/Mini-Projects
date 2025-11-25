package com.servlet;

import com.user.dao.*;
import java.io.IOException;
import java.util.List;
import com.user.dto.User;
import com.user.dto.Tasks;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        if (email == null || email.isEmpty() || pass == null || pass.isEmpty()) {
            req.setAttribute("error", "Fill all fields");
            RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
            rd.forward(req, resp);
            return;
        }

        userinterface ui = new userimplement();
        User u = ui.get(email, pass);

        if (u != null) {
            // ✅ Store user in session
            session.setAttribute("user", u);

            // ✅ Redirect to dashboard servlet (not forward)
            resp.sendRedirect("dashboard");
        } else {
            req.setAttribute("failed", "Failed to login");
            RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
            rd.forward(req, resp);
        }
    }

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    // ✅ If already logged in, skip login page
    HttpSession session = req.getSession(false);
    if (session != null && session.getAttribute("user") != null) {
        resp.sendRedirect("dashboard");
    } else {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
}
