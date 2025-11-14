<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
  HttpSession session = request.getSession(false);
  if (session == null || session.getAttribute("username") == null) {
    response.sendRedirect("login.jsp");
    return;
  }
  String username = (String) session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head><title>Welcome</title></head>
<body>
  <h2>Welcome, <%= username %>!</h2>
  <p>This page is protected. Only visible when logged in.</p>
  <form action="logout" method="post">
    <input type="submit" value="Logout"/>
  </form>
</body>
</html>