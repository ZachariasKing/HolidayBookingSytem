
/**
 * 'Holiday' models a Tops Travel holiday in the sense that it has a reference number, a type of holiday
 *  and also how much it will cost per person.
 *
 * @author Zacharias King
 * @version 14/11/2017
 */
public class Holiday
{
    // Unique reference number associated with particular holiday 
    private String refNo;
    // The type of holiday
    private String type;
    // The price per person of the holiday (This needs to be public so we can alter the value when discount can be applied)
    public double price;

    /**
     * Constructor for objects of class Holiday
     * This Constructor creates a new Holiday object using the arguments we give it.
     * 
     * @param newType this is the type of holiday
     * @param newPrice this is the price per person for the holiday
     * @param newRefNo this is the unique reference number we want to assign to the holiday.
     */
    public Holiday(String newRefNo, String newType, int newPrice)
    {
        type = newType;
        price = newPrice;
        refNo = newRefNo;
    }
    
    /**
     * This method returns the unique reference number of the holiday.
     */
    public String getRefNo()
    {
        return refNo;
    }
    
    /**
     * This method returns the type of holiday.
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * This method returns the current price of the holiday.
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * This method allows us to change the price per person of the holiday. 
     * 
     * @param newPrice this is what we want the new price to be.
     */
    public void setPrice(int newPrice)
    {
        price = newPrice;
    }
    
    /**
     * This method allows us to change the type of holiday.
     * 
     * @param newType this is what we want the new type to be.
     */
    public void setType(String newType)
    {
        type = newType;
    }
}
