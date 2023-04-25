<%@page import="java.sql.*"%>
<%@page import="model.Staff"%>
<%@page import="controller.StaffsDa"%>
<%
    String staffid = request.getParameter("staffID");
    String staff_position_session = (String) session.getAttribute("staff_position_sesion");

    // Make sure no existing record exists in the database
    StaffsDa staffsDa = new StaffsDa();
    Staff staffRecord = staffsDa.search(staffid);

    // Manager Position Verification before process
    if(staff_position_session.equals("TWFuYWdlcg==") && staffRecord != null){
        boolean res = staffsDa.delete(staffid);
%>
<!DOCTYPE html>
<html>
    <% if(res){ %>
    <script>alert('Staff Delete Successfully!');  window.location.href = "../index.jsp";</script>
    <% }else{ %>    
    <script>alert('Staff Delete Failed!');  window.location.href = "../index.jsp";</script>
    <% } %>
</html>
<% } %>