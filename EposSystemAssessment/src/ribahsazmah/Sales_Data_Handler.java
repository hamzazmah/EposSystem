//This is Sales Data Handler
package ribahsazmah;

//Imports
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Sales_Data_Handler 
{
    public ArrayList<Sales> getAllSales()
    {
        DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist
        ArrayList<Sales> salesList = new ArrayList<>();
         try 
            {
                Connection con = DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM Sales ");
                while (rs.next())//move to first record
                {    
                Sales sale = new Sales(rs.getInt("SaleID"),rs.getString("EmployeeNumber"),rs.getDouble("SaleValue"));
                salesList.add(sale);
                }
            }
         catch(SQLException e)
            {
                System.out.println("getValidUser : Error");
                System.out.println("SQL exception occured" + e);
            }
     
    //==========================================================='  
        return salesList;
    }
    
    public boolean checkSaleIsValid(Sales pSale){
        boolean saleExistsInDatabase = false;
      
         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM Sales WHERE SaleID = " + pSale.getSaleId());
                while (rs.next()) 
                {        
                  saleExistsInDatabase=true; // set if at least one record is found
                }
                
            }
         catch(SQLException ex)
            {
                System.out.println("checkSpiceIsValid : Error");
                System.out.println("SQL exception occured\n" + ex);
            }

    //==========================================================='  
    return (saleExistsInDatabase);
    }
    
    public void insertSale(Sales pSale)
    {
         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                String mySql = "INSERT INTO Sales (SaleID, EmployeeNumber  , SaleValue) VALUES (" + pSale.getSaleId() + " , '" 
                             + pSale.getEmployeeNumber()+ "' , '" + pSale.getSaleValue()+ "')";
                System.out.println("the sql  - " + mySql);
                stmt.executeUpdate(mySql);
              

            }
         catch(SQLException ex)
            {
                System.out.println("checkUserIsValid : Error");
                System.out.println("SQL exception occured\n" + ex);
            }

//      ==========================================================='
    }

    public void deleteSales(Sales pSale)
    {
         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                stmt.executeUpdate("DELETE * FROM Sales");
            }
         catch(SQLException ex)
            {
                System.out.println("checkSpiceIsValid : Error");
                System.out.println("SQL exception occured\n" + ex);
            }
    }    
}
