//Users Data Handler
package ribahsazmah;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Users_Data_Handler 
{
    public Users getValidUser(Users pUser){
        
        DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist
    
         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM Users WHERE EmployeeNumber = '" + pUser.getEmployeeNumber()+ "' AND Password = '" + pUser.getPassword() + "'" ) ;
               
                rs.next();//move to first record
                

                pUser.setFirstName(rs.getString("FirstName"));
                pUser.setLastName(rs.getString("LastName"));
                pUser.setPassword(rs.getString("Password"));
                pUser.setRole(rs.getString("Role"));

            }
         catch(SQLException e)
            {
                System.out.println("getValidUser : Error");
                System.out.println("SQL exception occured" + e);
            }
     
    //==========================================================='  
        return pUser;
    }
   
    public boolean checkUserIsValid(Users pUser){
        boolean userExistsInDatabase = false;
      
         try 
            { 
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM Users WHERE EmployeeNumber = '" + pUser.getEmployeeNumber()+ "' AND Password = '" + pUser.getPassword() + "'" );
                if (rs.next()) 
                {
                    System.out.println("Found the Employee!");
                    userExistsInDatabase=true; // set if at least one record is found
                }
                else 
                {
                    System.out.println("Employee Not found!");
                }
                
            }
         catch(SQLException ex)
            {
                System.out.println("checkUserIsValid : Error");
                System.out.println("SQL exception occured\n" + ex);
            }

    //==========================================================='  
    return (userExistsInDatabase);
    }
    
    public ArrayList<Users> getAllUsers()
    {
        DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist
        ArrayList<Users> userList = new ArrayList<>();
         try 
            {
                Connection con = DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM Users ");
                while (rs.next())//move to first record
                {    
                Users user = new Users(rs.getInt("ID"),rs.getString("EmployeeNumber"),rs.getString("FirstName"),rs.getString("LastName"), rs.getString("Password"), rs.getString("Role"));
                userList.add(user);
                }
            }
         catch(SQLException e)
            {
                System.out.println("getValidUser : Error");
                System.out.println("SQL exception occured" + e);
            }
     
    //==========================================================='  
        return userList;
    }
    
    
    public void updateUser(Users pUser )
    {
          try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                pUser.getEmployeeNumber();
               
                String mySql = "UPDATE Users SET ";
                mySql = mySql +  ("EmployeeNumber = '" +  pUser.getEmployeeNumber()   + "' , ") ;
                mySql = mySql +  ("FirstName = '" +    pUser.getFirstName()    + "' , ") ;
                mySql = mySql +  ("LastName = '" +    pUser.getLastName()   + "' , ") ;
                mySql = mySql +  ("Password = '"  +   pUser.getPassword() + "' , " ) ;
                mySql = mySql +  ("Role = '" +   pUser.getRole()   + "' ") ;    
                mySql = mySql +  ("WHERE ID = " + pUser.getUserID()) ;  
                
                System.out.println("the SQL  - " + mySql);
                stmt.executeUpdate(mySql);
              

            }
         catch(SQLException ex)
            {
                System.out.println("checkUserIsValid : Error");
                System.out.println("SQL exception occured\n" + ex);
            }

    //==========================================================='  
   
        
    }
    
    public void deleteUser(Users pUser )
    {
        try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                stmt.executeUpdate("DELETE * FROM Users WHERE ID = " + pUser.getUserID());
            }
         catch(SQLException ex)
            {
                System.out.println("Error");
                System.out.println("SQL exception occured\n" + ex);
            }
        
    }
    
    public void insertUser(Users pUser)
    {

         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                pUser.getEmployeeNumber();
               
                String mySql = "INSERT INTO Users";
                mySql = mySql +  ("(ID, EmployeeNumber, FirstName  , LastName , Password , Role)");
                mySql = mySql +  ("VALUES (") ;
                mySql = mySql +  ("" +  pUser.getUserID()+ ",") ;
                mySql = mySql +  ("'" +  pUser.getEmployeeNumber()   + "',") ;
                mySql = mySql +  ("'" +    pUser.getFirstName()    + "',") ;
                mySql = mySql +  ("'" +    pUser.getLastName()   + "',") ;
                mySql = mySql +  ( "'"  +   pUser.getPassword() + "'," ) ;  // no apostrophe pinnumber is an integer
                mySql = mySql +  ("'" +   pUser.getRole()   + "'") ;    
                mySql = mySql +  (")") ;     
                System.out.println("the SQL  - " + mySql);
                stmt.executeUpdate(mySql);
              

            }
         catch(SQLException ex)
            {
                System.out.println("checkUserIsValid : Error");
                System.out.println("SQL exception occured\n" + ex);
            }

    //==========================================================='  
   
    }   
        
}    
