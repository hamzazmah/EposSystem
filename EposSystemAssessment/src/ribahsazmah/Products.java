//This is the products class
package ribahsazmah;

public class Products 
{
    //Attributes   
    private int productId;
    private int screen;
    private String productName;
    private String description;
    private double price;
    private String imageFileName;
    private String category;
    
    //Methods 
    //Getters
    public int getProductId()
    {
        return this.productId;
    }
    public int getScreen()
    {
        return  this.screen;
    }
    public String getProductName()
    {
        return this.productName;
    }
    public String getDescription()
    {
        return this.description;
    }
    public double getPrice()
    {
        return this.price;
    }
    public String getImageFileName()
    {
        return this.imageFileName;
    }
    public String getCategory()
    {
        return this.category;
    }
    
    //Setters
    public void setProductId(int pProductId)
    {
        if (pProductId >= 0)
        {
            this.productId = pProductId;
        }
    }
    public void setScreen(int pScreen)
    {
        if ( pScreen >= 0 )
        {
            this.screen = pScreen;
        }
    }
    public void setProductName(String pProductName)
    {
        if (!pProductName.equals(""))
        {
            this.productName=pProductName;
        }
    }
    public void setDescription(String pDescrption)
    {
        if (!pDescrption.equals(""))
        {
            this.description=pDescrption;
        }
    }
    public void setPrice(double pPrice)
    {
        if (pPrice >= 0)
        {
            this.price=pPrice;
        }
    }
    public void setImageFileName(String pImageFileName)
    {
        if (!pImageFileName.equals(""))
        {
            this.imageFileName=pImageFileName;
        }
    }
    public void setCategory(String pCategory)
    {
        if(!pCategory.equals(""))
        {
            this.category=pCategory;
        }
    }
    
    //Constructors
    public Products()
    {
        productId = 0;
        screen = 0;
        productName = "";
        description = "";
        price = 0.00;
        imageFileName = "";
        category = "";
    }
    public Products(int pProductId, int pScreen, String pProductName, String pDescrption, double pPrice, String pImageFileName, String pCategory)
    {
        this.productId = pProductId;
        this.screen = pScreen;
        this.productName=pProductName;
        this.description=pDescrption;
        this.price=pPrice;
        this.imageFileName=pImageFileName;
        this.category=pCategory;
    }
    public Products(int pProductId)
    {
        this.productId = pProductId;
    }
    
    //Override toString Method
    @Override
       public String toString(){

           StringBuilder theStringVersionOfTheProducts= new StringBuilder();
           
           theStringVersionOfTheProducts.append(this.screen ).append(" , ");
           theStringVersionOfTheProducts.append(this.productName).append(" , ");
           theStringVersionOfTheProducts.append(this.description ).append(" , ");
           theStringVersionOfTheProducts.append(String.format("%.2f", this.price )).append(" , ");
           theStringVersionOfTheProducts.append(this.imageFileName ).append(" , ");
           theStringVersionOfTheProducts.append(this.category);
           
           return theStringVersionOfTheProducts.toString();
       }
}
