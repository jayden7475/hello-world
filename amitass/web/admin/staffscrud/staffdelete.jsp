<%-- 
    Document   : staffdelete
    Created on : Apr 22, 2023, 1:16:00 AM
    Author     : tengz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
   <meta charset="utf-8" />
   <meta name="viewport" content="width=device-width, initial-scale=1" />
   <title>Staff Delete</title>
</head>
<style>
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
input[type=text], input[type=email], input[type=tel], input[type=password] {
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

/* Style the show password button */
.show-password {
position: absolute;
right: 5px;
top: 50%;
transform: translateY(-50%);
background-color: transparent;
border: none;
cursor: pointer;
font-size: 16px;
color: #ccc;
z-index: 1;
}

</style>
<ul>
  <li>
  <a href="../index.jsp">Go Back</a>
  </li>
</ul>
<body>
    <div class="center"> 
    <h2>Staff Delete Form</h2>
    <form action="/amitass/admin/staffscrud/deleteStaff.jsp" method="post">
      <label for="staffID">Staff ID:</label>
      <input type="text" id="staffID" name="staffID" placeholder="Enter the Staff ID" required>
      <br/>
      <br/>
      <input type="submit" value="Delete" onclick="return confirm('This will delete the staff record.\n Are you sure?')">
    </form>
    </div>
  </body>
</html>
