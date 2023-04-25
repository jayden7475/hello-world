<%-- 
    Document   : UpdateShoe
    Created on : Apr 21, 2023, 7:19:16 PM
    Author     : User
--%>

<%@page import="java.sql.*"%>
<%@page import="model.Customer"%>
<%@page import="controller.CustomerDa"%>
<%
    String custId = request.getParameter("custId");
    String name = request.getParameter("username");
    String phone = request.getParameter("phone");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    Customer cust = new Customer(custId,name,phone,email,password);
    CustomerDa custDa = new CustomerDa();
    custDa.update(cust);
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
<head>
<meta charset="UTF-8">
<title>Update Customer Details</title>
</head>
<ul>
  <li>
  <a href="CustomerDetail.jsp">Go Back</a>
  </li>
</ul>
<body>
      <div class="center">
      <h2>Customer Details Saved</h2>
      <form>
         <div>
         <label>Customer ID</label>
            <input type="text" value="<%=custId%>" readonly/>
         </div>
         <div>
         <label>Customer Name</label>
            <input type="text" value="<%=name%>" readonly/>
         </div>
         <div>
            <label>Phone Number</label>
            <input type="tel" value="<%=phone%>" readonly/>
         </div>
         <div>
            <label>Customer Email</label>
            <input type="email"  value="<%=email%>" readonly/>
         </div>
         <div>
         <label>Password</label>
         <div style="position: relative;">
            <input type="password" id="pwd" value="<%=password%>" readonly/>
            <button type="button" class="show-password" onclick="togglePassword()">Show</button>
        </div>
         </div>
      </form>
      <script>
      function togglePassword() {
        var passwordInput = document.getElementById("pwd");
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