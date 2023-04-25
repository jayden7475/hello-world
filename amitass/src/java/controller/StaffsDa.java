/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Staff;
import java.sql.*;
import java.util.ArrayList;
import java.util.function.Supplier;
/**
 *
 * @author tengz
 */
public class StaffsDa {
    private String host = "jdbc:derby://localhost:1527/shoedb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "STAFF";
    private Connection conn;
    private PreparedStatement stmt;

    private String sqlQueryStr = "SELECT * FROM STAFF WHERE STAFF_ID = ?";
    private String sqlInsertStr = "INSERT INTO STAFF VALUES (?, ?, ?, ?, ?, ?)";
    private String sqlDeleteStr = "DELETE FROM STAFF WHERE STAFF_ID = ?";
    private String sqlUpdateStr = "UPDATE STAFF SET STAFF_NAME = ? , PHONE = ? , EMAIL = ? , PASSWORD = ?, POSITION = ? Where STAFF_ID = ?";

//    public StaffsDa() {
//        try {
////            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            conn = DriverManager.getConnection(host, user, password);
//            // stmt = conn.prepareStatement(sqlQueryStr);
//        } catch (SQLException ex) {
//            ex.getMessage();
//        }
//    }
    
    public StaffsDa() {
        // Initialize the database connection
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Staff getCurrentRecord() {
        Staff staff = null;
        try {
            ResultSet rs = stmt.executeQuery();
            staff = new Staff(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return staff;
    }

    public boolean addRecord(Staff staff) {
        boolean success = false;
        try {
            PreparedStatement insertStmt = conn.prepareStatement(sqlInsertStr);
            insertStmt.setString(1,staff.getStaffId());
            insertStmt.setString(2,staff.getStaffName());
            insertStmt.setString(3,staff.getPhone());
            insertStmt.setString(4,staff.getEmail());
            insertStmt.setString(5,staff.getPassword());
            insertStmt.setString(6,staff.getPosition());
            int rows = insertStmt.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
            if (rows > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    
    public Staff search(String staffID){
        Staff staff = null;
        try{
            PreparedStatement searchstm = conn.prepareStatement(sqlQueryStr);
            searchstm.setString(1, staffID);
            ResultSet rs = searchstm.executeQuery();
            
            if(rs.next()){
                staff = new Staff();
                staff.setStaffId(rs.getString("STAFF_ID"));
                staff.setStaffName(rs.getString("STAFF_NAME"));
                staff.setPhone(rs.getString("PHONE"));
                staff.setEmail(rs.getString("EMAIL"));
                staff.setPassword(rs.getString("PASSWORD"));
                staff.setPosition(rs.getString("POSITION"));
            }
            
        }
        catch (SQLException ex) {
            ex.getMessage();
        }
        return staff;
     }
    
    public boolean delete(String staffID) {   
        try {
            PreparedStatement deletestmt = conn.prepareStatement(sqlDeleteStr);
            deletestmt.setString(1, staffID);
            int rowsDeleted = deletestmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.getMessage();
            return false;
        }
    }

    
    public ArrayList<Staff> getStaff() {

        ArrayList<Staff> staff = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                staff.add(getCurrentRecord());
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return staff;
    }
    
    public boolean update(Staff staff) {
        try{
            PreparedStatement updateStmt = conn.prepareStatement(sqlUpdateStr);
            updateStmt.setString(1,staff.getStaffName());
            updateStmt.setString(2,staff.getPhone());
            updateStmt.setString(3,staff.getEmail());
            updateStmt.setString(4,staff.getPassword());
            updateStmt.setString(5,staff.getPosition());
            updateStmt.setString(6,staff.getStaffId() );
            int rowsUpdated = updateStmt.executeUpdate();
            return rowsUpdated > 0;
        }
        catch (SQLException ex) {
            ex.getMessage();
            return false;
        }
    }
}