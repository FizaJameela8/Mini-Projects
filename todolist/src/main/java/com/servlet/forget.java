package com.servlet;
import com.user.dao.*;
import java.io.IOException;

import com.user.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.user.dto.*;
@WebServlet("/forget")
public class forget extends HttpServlet{
	
@Override
public void doPost(HttpServletRequest req ,HttpServletResponse resp) throws ServletException,IOException{
	HttpSession session=req.getSession(false);
    String email=req.getParameter("email");
    String p=req.getParameter("phone");
    String pass=req.getParameter("password");
    String conpass=req.getParameter("conpass");
    
    if(email==null||email.isEmpty()||p==null||p.isEmpty()||pass==null||pass.isEmpty()||conpass==null||conpass.isEmpty()) {
    	req.setAttribute("error", "Fill all fields");
    	RequestDispatcher rd=req.getRequestDispatcher("forget.jsp");
    	rd.forward(req, resp);
    	return;
    }
    
	long phone=Long.parseLong(p);
	userinterface ui=new userimplement();
	User u=ui.get(email,phone);
	
	if(u==null) {
		req.setAttribute("error", "Invalid credencial");
    	RequestDispatcher rd=req.getRequestDispatcher("forget.jsp");
    	rd.forward(req, resp);
    	return;
	}
	else {
		if(pass.equals(conpass)) {
			if(u.getPassword().equals(pass)) {
				req.setAttribute("error", "Already existing password");
		    	RequestDispatcher rd=req.getRequestDispatcher("forget.jsp");
		    	rd.forward(req, resp);
		    	return;
			}
			u.setPassword(pass);
		   boolean updated=ui.updatePassword(u);
		   if(updated) {
				req.setAttribute("successp", "Password updated");
		    	RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
		    	rd.forward(req, resp);
		 	}
		    else {
			  req.setAttribute("error", "Failed to update");
		    	RequestDispatcher rd=req.getRequestDispatcher("forget.jsp");
		    	rd.forward(req, resp);
		  }
			
		}
		else {
			req.setAttribute("error", "Retype the password");
	    	RequestDispatcher rd=req.getRequestDispatcher("forget.jsp");
	    	rd.forward(req, resp);
		}
	}
}

}