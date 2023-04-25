<%-- 
    Document   : staffinsert
    Created on : Apr 22, 2023, 1:16:00 AM
    Author     : tengz
--%>
<%
    String staff_position_session = (String) session.getAttribute("staff_position_sesion");
    if(staff_position_session.equals("TWFuYWdlcg==")){  
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
   <meta charset="utf-8" />
   <meta name="viewport" content="width=device-width, initial-scale=1" />
   <title>Staff Insert</title>
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
    <h2>Staff Information Insert Form</h2>
    <form action="/amitass/admin/staffscrud/insertStaff.jsp" method="post">
      <label for="staffID">Staff ID:</label>
      <input type="text" id="staffID" name="staffID" placeholder="Enter the Staff ID" required>
      
      <label for="staffName">Staff Name:</label>
      <input type="text" id="staffName" name="staffName" placeholder="Enter the Staff Name" required>
      
      <label for="staffPhone">Staff Phone:</label>
      <input type="tel" id="staffPhone" name="staffPhone" placeholder="Enter the Staff Phone" required>
      
      <label for="staffEmail">Staff Email:</label>
      <input type="email" id="staffEmail" name="staffEmail" placeholder="Enter the Staff email" required>
      
      <label for="staffPass">Staff Password:</label>
      <div style="position: relative;">
      <input type="password" id="staffPass" name="staffPass" placeholder="Enter the Staff password" required>
      <button type="button" class="show-password" onclick="togglePassword()">Show</button>
      </div>
      
      <label for="staffPosition">Staff Position:</label>
      <select name="staffPosition" id="staffPosition">
        <option value="Manager">Manager</option>
        <option value="Staff">Staff</option>
      </select>
      <br/>
      <br/>
      <input type="submit" value="Insert">
    </form>
    </div>
    <script>
      function togglePassword() {
        var passwordInput = document.getElementById("staffPass");
        var showPasswordButton = document.querySelector(".show-password");
        
        if (passwordInput.type === "password") {
          passwordInput.type = "text";
          showPasswordButton.classList.add("visible");
        } else {
          passwordInput.type = "password";
          showPasswordButton.classList.remove("visible");
        }
      }
    </script>
  </body>
</html>
<% }else{ %>
    <script>alert('Insufficient Privileges!');  window.location.href = "../index.jsp";</script>
<% } %>