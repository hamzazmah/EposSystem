//This is Sales Class
package ribahsazmah;

public class Sales 
{
    //Attributes
    private int saleId;
    private String employeeNumber;
    private double saleValue;
    
    //Methods
    //Getters
    public int getSaleId()
    {
        return this.saleId;
    }
    public String getEmployeeNumber()
    {
        return this.employeeNumber;
    }
    public double getSaleValue()
    {
        return this.saleValue;
    }
    
    //Setters
    public void setSaleId(int pSaleId)
    {
        if (pSaleId >= 0)
        {
            this.saleId = pSaleId;
        }
    }
    
    public void setEmployeeNumber(String pEmlpoyeeNumber)
    {
        if (!pEmlpoyeeNumber.equals(""))
        {
            this.employeeNumber = pEmlpoyeeNumber;
        }
    }
    
    public void setSaleValue(double pSaleValue)
    {
        if (pSaleValue >= 0)
        {
            this.saleValue = pSaleValue;
        }
    }
    
    //Constructors
    public Sales()
    {
        saleId = 0;
        employeeNumber = "";
        saleValue = 0.00;
    }
    
    public Sales(int pSaleId, String pEmlpoyeeNumber, double pSaleValue)
    {
        this.saleId = pSaleId;
        this.employeeNumber = pEmlpoyeeNumber;
        this.saleValue = pSaleValue;
    }
    
    //Override toString Method
    @Override
    public String toString()
    {
        StringBuilder theStringVersionOfSales= new StringBuilder();
           
        theStringVersionOfSales.append(this.saleId ).append(" , ");
        theStringVersionOfSales.append(this.employeeNumber).append(" , ");
        theStringVersionOfSales.append(String.format("%.2f", this.saleValue )).append(" , ");
        
        return theStringVersionOfSales.toString();
        
    }
}
