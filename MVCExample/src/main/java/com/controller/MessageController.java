package com.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.model.MessageModel;

@WebServlet("/message")
public class MessageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get input from user
        String name = request.getParameter("username");

        // 2. Call Model
        MessageModel model = new MessageModel();
        String result = model.getMessage(name);

        // 3. Set data to JSP
        request.setAttribute("output", result);

        // 4. Forward to view.jsp (located in WebContent)
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }
}