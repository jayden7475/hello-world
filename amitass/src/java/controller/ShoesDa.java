package controller;

import model.Shoes;
import java.sql.*;
import java.util.ArrayList;

public class ShoesDa {

    private String host = "jdbc:derby://localhost:1527/shoedb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Shoes";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlQueryStr = "SELECT * from " + tableName + " Where SHOES_ID = ? ";
    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?, ?)";
    private String sqlDeleteStr = "Delete from " + tableName + " Where SHOES_ID = ? ";
    private String sqlUpdateStr = "UPDATE " + tableName + " SET SHOES_NAME = ?, SHOES_TYPE = ? , SHOES_PRICE = ? , SHOES_SIZE = ? , SHOES_STOCK = ? Where SHOES_ID = ? ";

    public ShoesDa() throws ClassNotFoundException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
            // stmt = conn.prepareStatement(sqlQueryStr);
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public Shoes getCurrentRecord() {
        Shoes shoes = null;
        try {
            ResultSet rs = stmt.executeQuery();
            shoes = new Shoes(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                    ,rs.getDouble(4),
                    rs.getString(5),
                    rs.getInt(6));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return shoes;
    }

    public void addRecord(Shoes shoes) {
        try {
        PreparedStatement insertStmt = conn.prepareStatement(sqlInsertStr);
        insertStmt.setString(1,shoes.getShoesId());
        insertStmt.setString(2,shoes.getShoesName());
        insertStmt.setString(3,shoes.getShoesType());
        insertStmt.setDouble(4,shoes.getShoesPrice());
        insertStmt.setString(5,shoes.getShoesSize());
        insertStmt.setInt(6,shoes.getShoesStock());
        insertStmt.setString(7,shoes.getShoesPng());
        insertStmt.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    public Shoes search(String id){
        Shoes shoesDa=null;
//        Connection conn = null;
        try{
            PreparedStatement searchstm = conn.prepareStatement(sqlQueryStr);
            searchstm.setString(1, id);
            ResultSet rs = searchstm.executeQuery();
            
            if(rs.next()){
                shoesDa = new Shoes();
                shoesDa.setShoesId(rs.getString("SHOES_ID"));
                shoesDa.setShoesName(rs.getString("SHOES_NAME"));
                shoesDa.setShoesType(rs.getString("SHOES_TYPE"));
                shoesDa.setShoesPrice(rs.getDouble("SHOES_PRICE"));
                shoesDa.setShoesSize(rs.getString("SHOES_SIZE"));
                shoesDa.setShoesStock(rs.getInt("SHOES_STOCK"));
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
        return shoesDa;
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
    public ArrayList<Shoes> getShoes() {

        ArrayList<Shoes> shoes = new ArrayList<Shoes>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                shoes.add(getCurrentRecord());
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return shoes;
    }
    
        public void update(Shoes shoes) {
        try{
        PreparedStatement updateStmt = conn.prepareStatement(sqlUpdateStr);
        updateStmt.setString(1,shoes.getShoesName());
        updateStmt.setString(2,shoes.getShoesType());
        updateStmt.setDouble(3,shoes.getShoesPrice());
        updateStmt.setString(4,shoes.getShoesSize());
        updateStmt.setInt(5,shoes.getShoesStock());
        updateStmt.setString(6,shoes.getShoesId());
        updateStmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.getMessage();
         }
    }
}