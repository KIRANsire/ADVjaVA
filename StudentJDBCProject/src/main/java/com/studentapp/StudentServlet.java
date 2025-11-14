package com.studentapp;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;  // ✅ Added serialVersionUID

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        try (Connection con = DBConnection.getConnection()) {
            // Using CallableStatement to call stored procedure
            CallableStatement stmt = con.prepareCall("{ call insert_student(?) }");
            stmt.setString(1, name);

            int result = stmt.executeUpdate();

            if (result > 0) {
                out.println("<h3>Student inserted successfully!</h3>");
            } else {
                out.println("<h3>Failed to insert student.</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}