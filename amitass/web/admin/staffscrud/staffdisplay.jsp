<%@page import="model.Staff"%>
<%@ page import="java.sql.*" %>
<%@page import="controller.StaffsDa"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  background-color: #f2f2f2;
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
#staff {
  font-family: "Times New Roman", Times, serif;
  border-collapse: collapse;
  width: 100%;
}

#staff td, #staff th {
  border: 1px solid #ddd;
  padding: 8px;
}

#staff tr{background-color: #ddd;}

#staff tr:hover {background-color: wheat;}

#staff th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
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
a {
  text-decoration: none;
  color: blue;
}
</style>
    <title>Shoe Store - All Staff</title>
    <meta charset="UTF-8">
</head>
<ul>
  <li>
  <a href="../index.jsp">Go Back</a>
  </li>
</ul>
    <body>
<%
   String url = "jdbc:derby://localhost:1527/shoedb";
   String user = "nbuser";
   String password = "nbuser";
   String sql = "SELECT * FROM STAFF";
   
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
<h1>All Staff</h1>
<form method="post" class='searchForm'>
  <input type="text" placeholder="Search by Staff ID..." id="staff-id" name="staff-id">
  <button type="submit"><i class="fa fa-search"></i></button>
</form>
<br/>
<table id='staff'>
<tr>
<th>Staff ID</th>
<th>Staff Name</th>
<th>Phone</th>
<th>Email</th>
<th>Position</th>
<th>Update Info</th>
</tr>
<% 
    String searchStaffID = request.getParameter("staff-id");
    if (searchStaffID != null && !searchStaffID.isEmpty()) {
      sql += " WHERE STAFF_ID='" + searchStaffID + "'";
    }
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) { %>
      <tr>
        <td><%= rs.getString("STAFF_ID") %></td>
        <td><%= rs.getString("STAFF_NAME") %></td>
        <td><%= rs.getString("PHONE") %></td>
        <td><%= rs.getString("EMAIL") %></td>
        <td><%= rs.getString("POSITION") %></td>
        <td><a href='staffupdate.jsp?STAFF_ID=<%= rs.getString("STAFF_ID") %>'>Update</a></td>
      </tr>
    <% }
    rs.close();
    stmt.close();
    conn.close();
  } catch (Exception e) {
    e.printStackTrace();
  } 
%>
