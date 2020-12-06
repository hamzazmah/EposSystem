/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ribahsazmah;

//Imports
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Products_Data_Handler 
{
    public ArrayList<Products> getAllProducts()
    {
        DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist
        ArrayList<Products> productList = new ArrayList<>();
         try 
            {
                Connection con = DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM Products ");
                while (rs.next())//move to first record
                {    
                Products product = new Products(rs.getInt("ProductID"),rs.getInt("Screen"),rs.getString("ProductName"), rs.getString("Description"), rs.getDouble("Price"), rs.getString("ImageFileName"), rs.getString("Category"));
                productList.add(product);
                }
            }
         catch(SQLException e)
            {
                System.out.println("Error");
                System.out.println("SQL exception occured" + e);
            }
     
    //==========================================================='  
        return productList;
    }
    
    public boolean checkProductIsValid(Products pProduct){
        boolean productExistsInDatabase = false;
      
         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM Products WHERE ProductID = " + pProduct.getProductId()); //+ "SpiceName='" + pSpice.getSpiceName()+ "' AND " + " Description=" + pSpice.getSpiceDescription());
                while (rs.next()) 
                {        
                  productExistsInDatabase=true; // set if at least one record is found
                }
                
            }
         catch(SQLException ex)
            {
                System.out.println("Error");
                System.out.println("SQL exception occured\n" + ex);
            }

    //==========================================================='  
    return (productExistsInDatabase);
    }
    
    public void updateProduct(Products pProduct)
    {
          try 
            {
                Connection con=DB_Utils.getConnection();
                
                
                //String mysql = ("UPDATE Products SET Screen = ? ," + " ProductName = ? ," + " Description = ? ," + " Price = ? ," + " ImageFileName = ? ," + " Category = ? " + " WHERE ProductID = ?" );
                Statement stmt = con.createStatement();
                stmt.executeUpdate("UPDATE Products SET Screen = " + pProduct.getScreen()+ " , ProductName = '" + pProduct.getProductName() + "' , Description = '" + pProduct.getDescription() + "' , Price = '" + pProduct.getPrice() + "' , ImageFileName = '" + pProduct.getImageFileName() + "' , Category = '" + pProduct.getCategory() + "' WHERE ProductID = " + pProduct.getProductId());  
                System.out.println("the sql  - " + stmt);
            }
         catch(SQLException ex)
            {
                System.out.println(" Error");
                System.out.println("SQL exception occured\n" + ex);
            }  
        
    }
    
    

    public void deleteProduct(Products pProduct)
    {
         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                stmt.executeUpdate("DELETE * FROM Products WHERE ProductID = " + pProduct.getProductId());
            }
         catch(SQLException ex)
            {
                System.out.println("Error");
                System.out.println("SQL exception occured\n" + ex);
            }
    }
    
    public void insertProduct(Products pProduct)
    {

         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();

                String mySql = "INSERT INTO Products (ProductID, Screen, ProductName, Description, Price, ImageFileName, Category) VALUES (" + pProduct.getProductId() + " , " 
                        + pProduct.getScreen()+ " , '" + pProduct.getProductName()+ "' , '" + pProduct.getDescription() + "' , " + pProduct.getPrice() + " , '" + pProduct.getImageFileName() + "' , '" + pProduct.getCategory() + "')";
                System.out.println("the sql  - " + mySql);
                stmt.executeUpdate(mySql);
              

            }
         catch(SQLException ex)
            {
                System.out.println(" Error");
                System.out.println("SQL exception occured\n" + ex);
                //JOptionPane.showMessageDialog(this, "The user has been inserted.");
            }

//==========================================================='
    }    
   
}

