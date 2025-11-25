package com.servlet;

import com.user.dao.taskimplement;
import com.user.dto.Tasks;
import com.user.dto.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchTask")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get the search keyword from the form
        String keyword = request.getParameter("search");

        // Get current user from session
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("user");

        // Only search if user and keyword are valid
        if (u != null && keyword != null && !keyword.trim().isEmpty()) {
            taskimplement dao = new taskimplement();

            // Pass keyword first, then userid (based on your method signature)
            List<Tasks> searchResults = dao.searchTasks(keyword, u.getId());

            // Set the search results as a request attribute
            request.setAttribute("taskList", searchResults);

            // Forward to home.jsp to show filtered results
            RequestDispatcher rd = request.getRequestDispatcher("dashbord.jsp");
            rd.forward(request, response);

        } else {
            // If keyword is empty or user not logged in, reload home
            response.sendRedirect("dashbord.jsp");
        }
    }
}
