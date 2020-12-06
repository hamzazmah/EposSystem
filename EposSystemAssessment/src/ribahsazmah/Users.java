//This is the User Class

package ribahsazmah;

public class Users 
{
    //Attributes
    private int userID;
    private String employeeNumber;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
    
    //Methods
    //Getters
    public int getUserID()
    {
        return this.userID;
    }
    public String getEmployeeNumber()
    {
        return this.employeeNumber;
    }
    public String getFirstName()
    {
        return this.firstName;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public String getPassword()
    {
        return this.password;
    }
    public String getRole()
    {
        return this.role;
    }
    
    //Setters
    
    public void setUserID(int pUserID)
    {
        if ( pUserID >= 0 )
        {
            this.userID=pUserID;
        }
        
    }
    public void setEmployeeNumber(String pEmployeeNumber)
    {
        //Guard Accessor Methods
        if (!pEmployeeNumber.equals(""))
        {
            this.employeeNumber=pEmployeeNumber;
        }
    }
    public void setFirstName(String pFirstName)
    {
        if (!pFirstName.equals(""))
        {
            this.firstName=pFirstName;
        }
    }
    public void setLastName(String pLastName)
    {
        if (!pLastName.equals(""))
        {
            this.lastName=pLastName;
        }
    }
    public void setPassword(String pPassword)
    {
        if (!pPassword.equals(""))
        {
            this.password=pPassword;
        }
    }
    public void setRole(String pRole)
    {
        if (!pRole.equals(""))
        {
            this.role=pRole;
        }
    }
    
     //Constructors
    public Users()
    {
        userID = 0;
        employeeNumber = "";
        firstName = "";
        lastName = "";
        password = "";
        role = "";
    }
    public Users (int pUserID,String pEmployeeNumber, String pFirstName, String pLastName, String pPassword, String pRole)
    {
         this.userID=pUserID;
        this.employeeNumber=pEmployeeNumber;
        this.firstName=pFirstName;
        this.lastName=pLastName;
        this.password=pPassword;
        this.role=pRole;
    }
    
    //Override toString Method
    @Override
       public String toString(){

           StringBuilder theStringVersionOfTheUsers= new StringBuilder();
           
           theStringVersionOfTheUsers.append(this.employeeNumber ).append(" , ");
           theStringVersionOfTheUsers.append(this.firstName).append(" , ");
           theStringVersionOfTheUsers.append(this.lastName ).append(" , ");
           theStringVersionOfTheUsers.append(this.password ).append(" , ");
           theStringVersionOfTheUsers.append(this.role );
           
           return theStringVersionOfTheUsers.toString();
       }
}
