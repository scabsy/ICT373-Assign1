package assignment1;

/**
 * @author Samuel Brownley 31691379
 * @version 1.0
 */
public class Customer {
    /**
     * Username of the customer
     */
    private String name;
    /**
     * Password of the customer
     */
    private String password;
    /**
     * Gender of the customer
     */
    private char gender;
    /**
     * Age of the customer
     */
    private int age;
    /**
     * Income of the customer
     */
    private int income;
    
    /**
     * Creates a new customer
     * 
     * Sets the values of the customer to the parameters
     * 
     * @param newName       username of the new customer
     * @param newG          gender of the new customer
     * @param newAge        age of the new customer
     * @param newIncome     income of the new customer
     */
    Customer(String newName, char newG,int newAge,int newIncome)
    {
        SetName(newName);
        SetPwrd(newName+"1");
        SetGender(newG);
        SetAge(newAge);
        SetIncome(newIncome);
    }
    
    /**
     * Gets the username
     * 
     * @return username of customer
     */
    String GetName()
    {
        return name;
    }
    
    /**
     * Gets the password
     * 
     * @return password of the customer
     */
    String GetPwrd()
    {
        return password;
    }
    
    /**
     * Gets the gender
     * 
     * @return gender of the customer
     */
    char GetGender()
    {
        return gender;
    }
    
    /**
     * Gets the age
     * 
     * @return age of the customer
     */
    int GetAge()
    {
        return age;
    }
    
    /**
     * Gets the income
     * 
     * @return income of the customer
     */
    int GetIncome()
    {
        return income;
    }
    
    /**
     * Sets the name to the param
     * 
     * @param newName new username
     */
    void SetName(String newName)
    {
        name=newName;
    }
    
    /**
     * Sets the password to the param
     * 
     * @param pwrd new password
     */
    void SetPwrd(String pwrd)
    {
        password=pwrd;
    }
    
    /**
     * Sets the gender to the param
     * 
     * @param newG new gender
     */
    void SetGender(char newG)
    {
        char gen = Character.toUpperCase(newG);
        if(gen=='M' || gen=='F')
        {
            gender=gen;            
        }
        else
        {
            System.out.println("You have entered an invalid gender. You have been assigned the default gender of M");
            gender='M';
        }
    }
    
    /**
     * Sets the age to param
     * 
     * @param newAge new age
     */
    void SetAge(int newAge)
    {
        if (newAge < 18)
        {
            newAge = 18;
            System.out.println("You have entered an invalid age. Age has been set to 18");
        }
        age=newAge;
    }
    
    /**
     * Sets the income to param
     * 
     * @param newIncome new income
     */
    void SetIncome(int newIncome)
    {
        income=newIncome;
    } 
}
