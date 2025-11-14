package com.example.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")  // URL pattern → this matches form action="login"
public class LoginServlet extends HttpServlet {

    // Hardcoded username and password for demo
    private static final String DEMO_USER = "user";
    private static final String DEMO_PASS = "pass";

    // Handles POST request (form submission)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1️⃣ Get form input values
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2️⃣ Validate input
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMessage", "Username and password are required!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // 3️⃣ Check if username and password are correct
        if (DEMO_USER.equals(username) && DEMO_PASS.equals(password)) {
            // ✅ Login success

            // 4️⃣ Create a session (to keep the user logged in)
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);

            // 5️⃣ Optional: Set session timeout to 10 minutes
            session.setMaxInactiveInterval(10 * 60);

            // 6️⃣ Redirect to welcome page
            response.sendRedirect("welcome.jsp");

        } else {
            // ❌ Login failed
            request.setAttribute("errorMessage", "Invalid username or password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // Handles GET request (if user tries to go to /login directly)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}