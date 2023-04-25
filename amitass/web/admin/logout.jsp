<%-- 
    Document   : logout
    Created on : Apr 23, 2023, 4:57:32 PM
    Author     : tengz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Invalidate session
    session.invalidate();
%>
<script>alert('You have successfully logged out!\nAll your session data has been deleted.');  window.location.href = "login.jsp";</script>