
/**
 * 'Member' models a member of Tops Travel in the sense that it has a membership number, an email, a login status
 *  and also the holiday they have selected.
 *
 * @author Zacharias King
 * @version 14/11/2017
 */
public class Member
{
    // Email address of the member
    private String email;
    // Unique membership number associated with member
    private int membershipNo;
    // Determines whether the user is logged into a website or not
    private boolean loginStatus;
    // Used to store the holiday object selected by a member
    private Holiday holiday;
    // Used to store reference to the website the member has logged in to
    private Website website;
    // This is used to gather the number of members and from that number create a unique ID from both it and a 6 digit code.
    private static int uniqueIDCounter;

    /**
     * Constructor for objects of class Member
     * This constructor creates a new Member object using the arguments we give it.
     * 
     * @param newEmail this is the email of the member.
     */
    public Member(String newEmail)
    {
        email = newEmail;
        loginStatus = false;
        uniqueIDCounter = 0;
        uniqueIDCounter++;
        membershipNo += uniqueIDCounter;
    }

    /**
     * This method returns the membership number of the member.
     */
    public int getMembershipNo()
    {
        return membershipNo;
    }

    /**
     * This method returns the email of the member.
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * This method returns the 'Holiday' object selected by the member.
     */
    public Holiday getHoliday()
    {
        return holiday;
    }

    /**
     * This method returns the login status of the member.
     */
    public boolean getLoginStatus()
    {
        return loginStatus;
    }

    /**
     * This method returns the 'Website' object selected by the member.
     */
    public Website getWebsite()
    {
        return website;
    }

    /**
     * This method allows us to select a new 'Website' object, changing the value of the field: website.
     * 
     * @param newWebsite this is the new website we want to select for the 'Member' object.
     */
    public void setWebsite(Website newWebsite)
    {
        website = newWebsite;
    }

    /**
     * This method allows us to change the value of the member's login status to true or false manually.
     * 
     * @param newLoginStatus this is what we want to change the value of loginStatus to (which will be either true or false).
     */
    public void setLoginStatus(boolean newLoginStatus)
    {
        loginStatus = newLoginStatus;
    }

    /**
     * This method allows us to select a new 'Holiday' object as long as the 'Member' object's login status is set to true (i.e they are logged in).
     * A message will be output, either confirming the selection or prompting the user to login first depending on their login status.
     * 
     * @param selectedHoliday this is the new holiday we want to select for the 'Member' object.
     */
    public void selectHoliday(Holiday selectedHoliday)
    {
        if(loginStatus == true)
        {
            holiday = selectedHoliday;
            System.out.println("Member " + membershipNo + " has selected holiday ref number " + holiday.getRefNo() + ", a " + holiday.getType() + 
            " holiday at £" + holiday.getPrice() + " per person." );
        }
        else
        {
            System.out.println("Pleas login in order to select a holiday.");
        }

    }

    /**
     * This method models the 'Member' object paying for the holiday by making an external method call
     * to the 'Website' class. It checks whether the member has actually chosen a holiday first before paying, otherwise they are prompted
     * with a message.
     */
    public void payForHoliday()
    {
        if(holiday != null)
        {
            website.checkout(this, holiday);
        }
        else
        {
            System.out.println("You haven't selected a holiday yet, so you cannot proceed to payment!");
        }
    }
}
