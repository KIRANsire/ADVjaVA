package com.example.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1️⃣ Get current session (if exists)
        HttpSession session = request.getSession(false);

        // 2️⃣ If session exists, destroy it
        if (session != null) {
            session.invalidate(); // removes all session data
        }

        // 3️⃣ Redirect to login page
        response.sendRedirect("login.jsp");
    }
}