import java.util.Scanner; // This is used to recieve user input on line 38.
/**
 * 'Website' models a website hosted by Tops Travel in the sense that it has a name, the amounts of hits its had
 *  and also the total sales made through the checkout.
 *
 * @author Zacharias King
 * @version 14/11/2017
 */
public class Website
{
    // Name of the website
    private String websiteName;
    // The number of browsers who have logged into the website
    private int hits;
    // Total amount of money taken at checkouts
    private double salesTotal;

    /**
     * Constructor for objects of class Website
     * This constructor creates a new Website object using the arguments we give it.
     * 
     * @param newName the name of the website.
     */
    public Website(String newName)
    {
        websiteName = newName;
        hits = 0;
        salesTotal = 0;
    }

    /**
     * This method returns the name of the website.
     */
    public String getWebsiteName()
    {
        return websiteName;
    }

    /**
     * This method returns the amount of hits the webiste has had.
     */
    public int getHits()
    {
        return hits;
    }

    /**
     * This method returns the total amount of sales made from this website.
     */
    public double getSalesTotal()
    {
        return salesTotal;
    }

    /**
     * This method takes a selected 'Member' object as an argument and then checks to see if the 'Member' object's 
     * 'loginStatus' is false (modelling being logged out). If this is the case, their loginStatus is set to true. However, if their 'loginStatus'
     * is set to true already, a message is outputted to screen letting them know.
     * field from the 'Member' class to true using an external method call to the 'Member' class.
     * 
     * @param loginMember this is the Member object we want to use as an argument to set their 'loginStatus' to true.
     */
    public void memberLogin(Member loginMember)
    {
        if (loginMember.getLoginStatus() == false)
        {
            loginMember.setLoginStatus(true);
            System.out.println(websiteName + " welcomes member " + loginMember.getMembershipNo() + ", you are now logged in.");
            loginMember.setWebsite(this);        
            hits++;
        }
        else
        {
            System.out.println("You are already logged in, please progress to selecting a holiday.");
        }
    }

    /**
     * This method takes a selected 'Member' object as an argument and then checks to see if that member's 'loginStatus' is set to true.
     * If so, it's 'loginStatus' will be set to false (modelling logging out) using an external method call to the 'Member' class and a 
     * message confirming that the user has logged out will appear on screen. However, If the 'Member' object we have selected has their 
     * 'loginStatus' set to false, a message will be output letting them know that they haven't logged in.
     * 
     * @param logoutMember this is the Member object we want to use as an argument to their 'loginStatus' to false.
     */
    public void memberLogout(Member logoutMember)
    {
        if (logoutMember.getLoginStatus() == true)
        {
            logoutMember.setLoginStatus(false);
            System.out.println(websiteName + " is sad to see member " + logoutMember.getMembershipNo() + " go.\nWe hope you are back soon!" );
            logoutMember.setWebsite(null);
        }
        else
        {
            System.out.println("Member " + logoutMember.getMembershipNo() + "is not logged in and so there is no need to logout!");
        }
    }

    /**
     * This method checks to see if the hits have reached a multiple of 10 (to represent every tenth member), 
     * and if so discount is applied to the purchase price.
     * 
     * @param checkMember this is the member for whom we are going to give discount.
     */
    public boolean checkHitDiscount(Member checkMember)
    {
        if (hits % 10 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method models a selected 'Member' object paying for a selected 'Holiday object'. It first uses an internal method call
     * to see if we can apply a discount. Following this check, it provides our user with a confirmation message of purchasing their holiday
     * and then adds the price of the holiday to the sales total. When this is finished, the user is prompted to enter some text, and based on their
     * answer, they will either log out or remain logged in.
     * 
     * @param newMember this is the member purchasing the holiday.
     * @param newHoliday this is the holiday the member is going to purchase.
     */
    public void checkout(Member newMember, Holiday newHoliday)
    {
           if (checkHitDiscount(newMember) == true)
        {
            double priceDiscount = newMember.getHoliday().getPrice() / 10;
            newMember.getHoliday().price = newMember.getHoliday().price - priceDiscount;
            System.out.println("Congratulations, your 10% discount has been applied!");
        }
        else
        {
            System.out.println("There is no discount available.");
        }
        
        System.out.println("Member " + newMember.getMembershipNo() + ", your purchase of a " + newHoliday.getType() + " holiday (ref number: " + 
        newHoliday.getRefNo() + ") was successful.\nThe total you have paid is £" + newHoliday.getPrice());
        
        salesTotal += newHoliday.getPrice();
        
        System.out.println("Would you like to log off now?, Please enter either Yes or No");
        //A Java utility called Scanner recieves input from user saying either "Yes" or "No"
        Scanner input = new Scanner(System.in); 
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("Yes"))
        {
            memberLogout(newMember);
            System.out.println("You have been logged out successfully.");
        }
        else if(answer.equalsIgnoreCase("No"))
        {
            System.out.println("Ok, you will remain logged in.");
        }
    }  
}


