<%@page import="java.sql.*"%>
<%@page import="model.Customer"%>
<%@page import="controller.CustomerDa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String custId = request.getParameter("CUST_ID");
    CustomerDa custDa = new CustomerDa();
    custDa.delete(custId);
%>
<head>
</head>
<body>
<script>alert('The customer information have delete successfully!!!');  window.location.href = "index.jsp";</script>
</body>
</html>