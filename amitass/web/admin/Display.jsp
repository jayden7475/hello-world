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
#shoes {
  font-family: "Times New Roman", Times, serif;
  border-collapse: collapse;
  width: 100%;
}

#shoes td, #shoes th {
  border: 1px solid #ddd;
  padding: 8px;
}

#shoes tr:nth-child(even){background-color: wheat;}

#shoes tr:hover {background-color: #ddd;}

#shoes th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
a {
  text-decoration: none;
  color:blue;
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
        <title>Shoe Store - All Shoes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
   String sql = "SELECT * FROM shoes";
   
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
<h1>All Shoes</h1>
<form method="post" class='searchForm'>
  <input type="text" placeholder="Search by Shoe ID..." id="SHOES_ID" name="SHOES_ID">
  <button type="submit"><i class="fa fa-search"></i></button>
</form>
</br>
<table id='shoes'>
<tr>
<th>Shoe ID</th>
<th>Shoe Name</th>
<th>Shoe Type</th>
<th>Shoe Price</th>
<th>Shoe Size</th>
<th>Shoe Stock</th>
<th>Shoe PNG</th>
<th>Update</th>
</tr>
<% 
    String searchShoeID = request.getParameter("SHOES_ID");
    if (searchShoeID != null && !searchShoeID.isEmpty()) {
      sql += " WHERE SHOES_ID='" + searchShoeID + "'";
    }
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) { %>
      <tr>
        <td><%= rs.getString("SHOES_ID") %></td>
        <td><%= rs.getString("SHOES_NAME") %></td>
        <td><%= rs.getString("SHOES_TYPE") %></td>
        <td><%= rs.getDouble("SHOES_PRICE") %></td>
        <td><%= rs.getString("SHOES_SIZE") %></td>
	<td><%= rs.getString("SHOES_STOCK") %></td>
        <td><img src='../shoes_images/<%= rs.getString("SHOES_PNG") %>' width='100' height='100'></td>
        <td><a href='Update.html?SHOES_ID=<%= rs.getString("SHOES_ID") %>'>Update</a></td>
      </tr>
    <% }
    rs.close();
    stmt.close();
    conn.close();
  } catch (Exception e) {
    e.printStackTrace();
  } 
%>