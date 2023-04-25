<%@page import="controller.ShoesDa"%>
<%@page import="model.Shoes"%>
<%@page import="controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    ShoesDa shoesDa = new ShoesDa();
    shoesDa.delete(id);
%>
<head>
</head>
<body>
<script>alert('The shoes information delete successfully!!!');  window.location.href = "index.jsp";</script>
</body>
</html>