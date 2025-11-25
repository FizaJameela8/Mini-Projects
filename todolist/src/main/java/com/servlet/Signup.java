package com.servlet;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.user.dao.*;
import com.user.dto.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            resp.sendRedirect("dashboard");  // adjust the URL if needed
            return;
        }
		String name = req.getParameter("name");
		String p = req.getParameter("phone");
		String email = req.getParameter("email");
		String location = req.getParameter("location");
		String pass = req.getParameter("password");
		String conpass = req.getParameter("conpass");
		if (name == null || name.isEmpty() || email == null || email.isEmpty() || location == null || p == null
				|| p.isEmpty() || location.isEmpty() || pass == null || pass.isEmpty() || conpass == null
				|| conpass.isEmpty()) {
			req.setAttribute("error", "fill all fields");
			RequestDispatcher rd = req.getRequestDispatcher("Signin.jsp");
			rd.forward(req, resp);
			return;
		}
		if (!p.matches("\\d{10}")) {
			req.setAttribute("error", "give 10 digit number");
			RequestDispatcher rd = req.getRequestDispatcher("Signin.jsp");
			rd.forward(req, resp);
			return;
		}

		String emailr = "^[A-Za-z0-9_.]+@[A-Za-z0-9]+\\.[a-zA-Z]{2,}$";
		Pattern emailc = Pattern.compile(emailr);
		Matcher emailm = emailc.matcher(email);
		if (!emailm.matches()) {
			req.setAttribute("error", "Give proper email");
			RequestDispatcher rd = req.getRequestDispatcher("Signin.jsp");
			rd.forward(req, resp);
			return;
		}

		long phone = Long.parseLong(p);
		User u = new User();
		userinterface ui = new userimplement();
		if (pass.equals(conpass)) {
			u.setName(name);
			u.setEmail(email);
			u.setLocation(location);
			u.setPassword(pass);
			u.setPhone(phone);

			boolean res = ui.insert(u);
			if (res) {
				req.setAttribute("success", "Signed up success");
				RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("error", "Signed up failed");
				RequestDispatcher rd = req.getRequestDispatcher("Signin.jsp");
				rd.forward(req, resp);
			}

		} else {
			req.setAttribute("error", "Re-Enter password");
			RequestDispatcher rd = req.getRequestDispatcher("Signin.jsp");
			rd.forward(req, resp);
		}

	}
}