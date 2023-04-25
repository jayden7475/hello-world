<%@page import="model.Shoes"%>
<%@ page import="java.sql.*" %>
<%@page import="controller.ShoesDa"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image:  url("../images/2.png");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}

#customer {
  font-family: "Times New Roman", Times, serif;
  border-collapse: collapse;
  width: 100%;
}

#customer td, #customer th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customer tr:nth-child(even){background-color: wheat;}

#customer tr:hover {background-color: #ddd;}

#customer th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
a {
  text-decoration: none;
  color: blue;
}
form.searchForm input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 20%;
  background: #f1f1f1;
}

form.searchForm button {
  float: left;
  width: 20%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
  max-width: 50px;
}

form.searchForm button:hover {
  background: #0b7dda;
}

form.searchForm::after {
  content: "";
  clear: both;
  display: table;
}
</style>
    <title>Customer Store - All Customer</title>
    <meta charset="UTF-8">
</head>
<ul>
  <li>
  <a href="index.jsp">Go Back</a>
  </li>
</ul>
    <body>
<%
   String url = "jdbc:derby://localhost:1527/shoedb";
   String user = "nbuser";
   String password = "nbuser";
   String sql = "SELECT * FROM Customer";
   
   try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      Connection conn = DriverManager.getConnection(url, user, password);
      Statement stmt = conn.createStatement();
%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<h1>All Customer</h1>
<form method="post" class='searchForm'>
  <input type="text" placeholder="Search by Customer ID..." id="CUST_ID" name="CUST_ID">
  <button type="submit"><i class="fa fa-search"></i></button>
</form>
<br/>
<table id='customer'>
<tr>
<th>CUSTOMER ID</th>
<th>Name</th>
<th>Phone</th>
<th>Email</th>
<th>PASSWORD</th>
<th>Update</th>
<th>Delete</th>
</tr>
<% 
    String searchCustID = request.getParameter("CUST_ID");
    if (searchCustID != null && !searchCustID.isEmpty()) {
      sql += " WHERE CUST_ID='" + searchCustID + "'";
    }
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) { %>
      <tr>
        <td><%= rs.getString("CUST_ID") %></td>
        <td><%= rs.getString("USERNAME") %></td>
        <td><%= rs.getString("PHONE") %></td>
        <td><%= rs.getString("EMAIL") %></td>
        <td><%= rs.getString("PASSWORD") %></td>
        <td><a href='UpdateCustomer.html?CUST_ID=<%= rs.getString("CUST_ID") %>'>Update</a></td>
        <td><a href='DeleteCustomer.jsp?CUST_ID=<%= rs.getString("CUST_ID") %>'>Delete</a></td>
      </tr>
    <% }
    rs.close();
    stmt.close();
    conn.close();
  } catch (Exception e) {
    e.printStackTrace();
  } 
%>


