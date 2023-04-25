<%-- 
    Document   : index2.html
    Created on : Apr 21, 2023, 12:23:17 AM
    Author     : tengz
--%>
<%@page import="java.util.Base64"%>
<%
    // Validate whether login session "user" exists
    String uid = (String)session.getAttribute("staff_login_sesion");
    if (uid == null)
    {
%>
        <!-- NOT LOGGED IN, REDIRECT TO login.jsp -->
        <jsp:forward page="login.jsp"/>
<%	
    }
    else
    {
%>
        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Staff"%>
<%@ page import="java.sql.*" %>
<%@page import="controller.StaffsDa"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="dss/adminlte.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {
    font-family: "Raleway", sans-serif
}
.modal {
  display: none; 
  position: fixed; 
  z-index: 1; 
  padding-top: 100px; 
  left: 0;
  top: 0;
  width: 100%; 
  height: 100%; 
  overflow: auto; 
  background-color: rgb(0,0,0); 
  background-color: rgba(0,0,0,0.4);
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 50%;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  animation-name: fade;
  animation-duration: 1.5s;
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}
.w3-container w3-red w3-padding-16{
    margin: 5px;
}
.well{
    background-color: wheat;
    padding: 16px;
}
</style>
</head>
<body class="w3-light-grey">
<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
<!--  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>-->
<!--  <span class="w3-bar-item w3-right">Villain</span>-->
   <p class="alert alert-info">
            <marquee behavior="" scrollamount="2" direction="">SHOES Admin Home Page!!!
            </marquee>
        </p>
</div>
<br/>
<br/>
<br/>
<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="mySidebar"><br/>
<br/>
<br/>
<br/>
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="../images/old.jpg" alt="User Image" class="w3-circle w3-margin-right" style="width:50px;height: 50px">
    </div>
    <div class="w3-col s8 w3-bar">
      <span>Welcome, <strong>Staff</strong></span><br>
          <a href="admin.php" class="brand-link">
<form>  
<label for="current-date">Current Date:</label>  
<input type="text" id="current-date" style="width:130px" disabled>  
</form> 
            </a>
    </div>
  </div>
  <hr>
  <div class="w3-container">
    <h5>Dashboard</h5>
  </div>
  <div class="w3-bar-block">
    <a href="home.html" class="w3-bar-item w3-button w3-padding">Home</a>
    <a href="" class="w3-bar-item w3-button w3-padding">Admin</a>
    <div class="w3-dropdown-click">
      <button class="w3-button" onclick="myFunction()">
        SHOES <i class="fa fa-caret-down"></i>
      </button>
      <div id="shoes" class="w3-dropdown-content w3-bar-block w3-card">
        <a href="ShoeInsert.html" class="w3-bar-item w3-button">Insert</a>
        <a href="Search.html" class="w3-bar-item w3-button">Search</a>
        <a href="Display.jsp" class="w3-bar-item w3-button">Display</a>
        <a href="Delete.html" class="w3-bar-item w3-button">Delete</a>
      </div>
    </div>
    <div class="w3-dropdown-click">
      <button class="w3-button" onclick="staffsFunction()">
        STAFFS <i class="fa fa-caret-down"></i>
      </button>
      <div id="staffs" class="w3-dropdown-content w3-bar-block w3-card">
        <a href="staffscrud/staffinsert.jsp" class="w3-bar-item w3-button">Insert</a>
        <a href="staffscrud/staffdisplay.jsp" class="w3-bar-item w3-button">Display</a>
        <a href="staffscrud/staffdelete.jsp" class="w3-bar-item w3-button">Delete</a>
      </div>
    </div>
       <a href="CustomerDetail.jsp" class="w3-bar-item w3-button w3-padding">CUSTOMER</a>
    <a href="logout.jsp" class="w3-bar-item w3-button w3-padding">Logout</a><br><br>
  </div>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding" onclick="document.getElementById('contact').style.display='block'">Profile</a> 
</nav>
</nav>
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">
       <h2>&#128094;Shoe&#128095;</h2>
        <div class="w3-display-container w3-container">
    <img src="../images/home1.png" alt="shoes" style="width:90%;height: 450px">
    <div class="w3-display-topleft w3-text-black" style="padding:10px 20px">
      <h1 class="w3-jumbo w3-hide-small">New arrivals</h1>
      <h1 class="w3-hide-large w3-hide-medium">New arrivals</h1>
      <h1 class="w3-hide-small">COLLECTION 2023</h1>
    </div>
  </div>
<br/>
<button id="myBtn">New Product Today</button>
<br/>
<br/>
<div id="myModal" class="modal">

  <div class="modal-content">
  <span class="close">&times;</span>
  </br>
<div class="slideshow-container">
    
<div class="mySlides fade">
  <img src="../images/shoe1.jpg" style="width:710px;height: 400px">
</div>

<div class="mySlides fade">
  <img src="../images/shoe2.jpg" style="width:710px;height: 400px">
</div>

<div class="mySlides fade">
  <img src="../images/shoes.png" style="width:710px;height: 400px">
</div>
  </div>
</div>
<br>
<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>
</div>
   
<div id="contact" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom w3-small w3-center" style="padding:20px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('contact').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <div class="w3-row-padding">
        <h2>Admin Details</h2>
<% 
String url = "jdbc:derby://localhost:1527/shoedb";
String user = "nbuser";
String password = "nbuser";
String sql = "SELECT * FROM STAFF WHERE STAFF_ID = ?";

try {
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection conn = DriverManager.getConnection(url, user, password);
    String staff_id = new String(Base64.getDecoder().decode(uid));
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, staff_id);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) { 
%>
        <form>
          <p><input class="w3-input w3-border" type="text"  name="Staff ID" value="<%= rs.getString("STAFF_ID") %>"readonly></p>
          <p><input class="w3-input w3-border" type="text"  name="Name" value="<%= rs.getString("STAFF_NAME") %>" readonly></p>
          <p><input class="w3-input w3-border" type="tel" name="Phone" value="<%= rs.getString("PHONE") %>" readonly></p>
          <p><input class="w3-input w3-border" type="email"  name="Email" value="<%= rs.getString("EMAIL") %>" readonly></p>
          <p><input class="w3-input w3-border" type="text"  name="Position" value="<%= rs.getString("POSITION") %>" readonly></p>
        </form>
<% 
    }
    rs.close();
    stmt.close();
    conn.close();
} catch (Exception e) {
    e.printStackTrace();
} 
%>
    </div>
  </div>
</div>
<script>
document.getElementById("current-date").value = new Date().toLocaleDateString(); 
</script>
<script>
function myFunction() {
  var x = document.getElementById("shoes");
  if (x.className.indexOf("w3-show") === -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}

function staffsFunction() {
  var x = document.getElementById("staffs");
  if (x.className.indexOf("w3-show") === -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>
<script>
let slideIndex = 0;
showSlides();

function showSlides() {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>
<script>
var modal = document.getElementById("myModal");

var btn = document.getElementById("myBtn");

var span = document.getElementsByClassName("close")[0];

btn.onclick = function() {
  modal.style.display = "block";
}

span.onclick = function() {
  modal.style.display = "none";
}

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>
</body>
</html>
<%
    }
%> 