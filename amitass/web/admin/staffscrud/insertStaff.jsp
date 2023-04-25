<%@page import="java.sql.*"%>
<%@page import="model.Staff"%>
<%@page import="controller.StaffsDa"%>
<%
    String staffid = request.getParameter("staffID");
    String staffname = request.getParameter("staffName");
    String staffphone = request.getParameter("staffPhone");
    String staffemail = request.getParameter("staffEmail");
    String staffpassword = request.getParameter("staffPass");
    String staffposition = request.getParameter("staffPosition");

    // Make sure no existing record exists in the database
    StaffsDa staffsDa = new StaffsDa();
    Staff staffRecord = staffsDa.search(staffid);

    if(staffRecord == null){
        Staff staff = new Staff(staffid,staffname,staffphone,staffemail,staffpassword,staffposition);
        boolean res = staffsDa.addRecord(staff);
%>
<!DOCTYPE html>
<html>
    <% if(res){ %>
    <script>alert('Staff Insert Successfully!');  window.location.href = "staffinsert.jsp";</script>
    <% }else{ %>    
    <script>alert('Staff Insert Failed!');  window.location.href = "staffinsert.jsp";</script>
    <% } %>
</html>
<% }else{ %>
<script>alert('Staff record already exists! Staff ID must be unique!');  window.location.href = "staffinsert.jsp";</script>
<% } %>