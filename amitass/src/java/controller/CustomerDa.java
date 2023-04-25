package controller;

import model.Customer;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDa {

    private String host = "jdbc:derby://localhost:1527/shoedb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Customer";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlQueryStr = "SELECT * from " + tableName + " Where CUST_ID = ? ";
    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?)";
    private String sqlDeleteStr = "Delete from " + tableName + " Where CUST_ID = ? ";
    private String sqlUpdateStr = "UPDATE " + tableName + " SET USERNAME = ?, PHONE = ? , EMAIL = ? , PASSWORD = ?  Where CUST_ID = ? ";

    public CustomerDa() throws ClassNotFoundException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
            // stmt = conn.prepareStatement(sqlQueryStr);
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public Customer getCurrentRecord() {
        Customer cust = null;
        try {
            ResultSet rs = stmt.executeQuery();
            cust = new Customer(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return cust;
    }

    public void addRecord(Customer cust) {
        try {
        PreparedStatement insertStmt = conn.prepareStatement(sqlInsertStr);
        insertStmt.setString(1,cust.getCustId() );
        insertStmt.setString(2,cust.getUsername());
        insertStmt.setString(3,cust.getPhone());
        insertStmt.setString(4,cust.getEmail());
        insertStmt.setString(5,cust.getPassword());
        insertStmt.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    public Customer search(String custId){
        Customer custDa=null;
//        Connection conn = null;
        try{
            PreparedStatement searchstm = conn.prepareStatement(sqlQueryStr);
            searchstm.setString(1, custId);
            ResultSet rs = searchstm.executeQuery();
            
            if(rs.next()){
                custDa = new Customer();
                custDa.setCustId(rs.getString("CUST_ID"));
                custDa.setUsername(rs.getString("USERNAME"));
                custDa.setPhone(rs.getString("PHONE"));
                custDa.setEmail(rs.getString("EMAIL"));
                custDa.setPassword(rs.getString("PASSWORD"));
            }
            
        }
        catch (SQLException ex) {
            ex.getMessage();
        }
        finally{
            try{
                if(conn!=null){
                    conn.close();
                }
            }
           catch (SQLException ex) {
            ex.getMessage();
        }
        }
        return custDa;
     }

    public void delete(String id) {   
        try{
        PreparedStatement deletestmt = conn.prepareStatement(sqlDeleteStr);
        deletestmt.setString(1,id);
        deletestmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.getMessage();
        }
    }
    public ArrayList<Customer> getCustomer() {

        ArrayList<Customer> cust = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cust.add(getCurrentRecord());
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return cust;
    }
    
        public void update(Customer cust) {
        try{
        PreparedStatement updateStmt = conn.prepareStatement(sqlUpdateStr);
        updateStmt.setString(1,cust.getUsername());
        updateStmt.setString(2,cust.getPhone());
        updateStmt.setString(3,cust.getEmail());
        updateStmt.setString(4,cust.getPassword());
        updateStmt.setString(5,cust.getCustId());
        updateStmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.getMessage();
         }
    }
}