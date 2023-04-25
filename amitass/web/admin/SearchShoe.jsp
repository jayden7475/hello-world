<%@page import="controller.ShoesDa"%>
<%@page import="model.Shoes"%>
<%@page import="controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    Controller control= new Controller();
    Shoes shoes = control.getRecord(id);
// Display shoes details
%>
<!DOCTYPE html>
<html>
    <style>
body {
  background-image:  url("../images/2.png");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
input:focus, select:focus, textarea:focus {
   background-color: rgb(255, 255, 180);
}

label {
   display: inline-block;
   width: 120px;
}

input[type="submit"],
input[type="reset"]{
   height: 50px;
   width: 200px;
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

.center {
  margin: auto;
  width: 50%;
  border: 3px solid black;
  padding: 10px;
  margin-top: 50px;
  background-color: #f2f2f2;
}

/* Style the input fields */
input[type=text], input[type=number]{
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
}

select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
}

/* Style the submit button */
input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

/* Style the form */
form {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
    width: 80%;
    margin: auto;
}

/* Style the form header */
h2 {
    text-align: center;
    font-family: Arial, Helvetica, sans-serif;
}
</style>
<head>
<meta charset="UTF-8">
<title>Show Shoes Details</title>
</head>
<ul>
  <li>
  <a href="index.jsp">Admin Page</a>
  </li>
  <li><a href="Search.html">Go Back</a></li>
</ul>
<body>
      <div class="center">
      <h2>Shoes Information</h2>
      <form>
         <div>
         <label>Shoes ID</label>
            <input type="text" value="<%=id%>" readonly/>
         </div>
         <div>
         <label>Shoes Name</label>
            <input type="text" value="<%=shoes.getShoesName() %>" readonly/>
         </div>
         <div>
            <label>Shoes Type</label>
            <input type="text" value="<%=shoes.getShoesType() %>" readonly/>
         </div>
         <div>
            <label>Shoes Price</label>
            <input type="number"  value="<%=shoes.getShoesPrice() %>" readonly/>
         </div>
         <div>
         <label>Shoes Size:</label>
            <input type="text"  value="<%=shoes.getShoesSize() %>" readonly/>
        </div>
        <div>
            <label>Shoes Stock</label>
            <input type="number"   value="<%=shoes.getShoesStock() %>" readonly/>
        </div>
      </form>
</body>
</html>