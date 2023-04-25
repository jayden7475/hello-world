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
    Staff staff = new Staff(staffid,staffname,staffphone,staffemail,staffpassword,staffposition);
    StaffsDa staffsDa = new StaffsDa();
    boolean res = staffsDa.update(staff);
%>
<!DOCTYPE html>
<html>
    <% if(res){ %>
    <script>alert('Staff Update Successfully!');  window.location.href = "staffdisplay.jsp";</script>
    <% }else{ %>    
    <script>alert('Staff Update Failed!');  window.location.href = "staffdisplay.jsp";</script>
    <% } %>
</html>