<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>
<html>
<head><title>500 - Server Error</title></head>
<body>
  <h1>Something went wrong (500)</h1>
  <p>Status Code: ${requestScope['javax.servlet.error.status_code']}</p>
  <p>Message: ${requestScope['javax.servlet.error.message']}</p>
  <p>Error Type: ${requestScope['javax.servlet.error.exception_type']}</p>
  <a href="${pageContext.request.contextPath}/">Go Home</a>
</body>
</html>