/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import javax.swing.JOptionPane;
import model.Shoes;
import model.Customer;

/**
 *
 * @author user
 */
public class Controller {

    ShoesDa shoeDA = null;
    CustomerDa custDA =null;
    public Controller() {
        try{
            shoeDA = new ShoesDa();
            custDA = new CustomerDa();
        }
        catch(Exception ex){
            
        }
    }
    
    public Shoes getRecord(String id)
    {
        return shoeDA.search(id);
    }
    
    public void updateRecord(Shoes shoes)
    {
        Shoes shoecheck = shoeDA.search(shoes.getShoesId());
        if(shoecheck == null) //check if the record is exist in DB
        {
            JOptionPane.showMessageDialog(null, "Programme is not exist");
        }
        else{
            shoeDA.update(shoes);
        }
    }
    
    public void addRecord(Shoes shoes)   {
         Shoes shoecheck = shoeDA.search(shoes.getShoesId());
        if(shoecheck == null) //check if the record is exist in DB
        {
            shoeDA.addRecord(shoes);
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Programme is exist");
        }
    }
    
    public void deleteRecord(String id)
    {
         Shoes shoecheck = shoeDA.search(id);
        if(shoecheck == null) //check if the record is exist in DB
        {
            JOptionPane.showMessageDialog(null, "Programme is not exist");
        }
        else{
            shoeDA.delete(id);
        }
    }
    
     public Customer Retreive(String id)
    {
        return custDA.search(id);
    }
    
    public void update(Customer cust)
    {
        Customer check = custDA.search(cust.getCustId());
        if(check == null) //check if the record is exist in DB
        {
            JOptionPane.showMessageDialog(null, "Programme is not exist");
        }
        else{
            custDA.update(cust);
        }
    }
    
    public void insert(Customer cust)   {
         Customer check = custDA.search(cust.getCustId());
        if(check == null) //check if the record is exist in DB
        {
            custDA.addRecord(cust);
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Programme is exist");
        }
    }
    
    public void delete(String id)
    {
         Customer check = custDA.search(id);
        if(check == null) //check if the record is exist in DB
        {
            JOptionPane.showMessageDialog(null, "Programme is not exist");
        }
        else{
            custDA.delete(id);
        }
    }
}
