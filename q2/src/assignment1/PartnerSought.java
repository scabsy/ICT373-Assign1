package assignment1;

/**
 * @author Samuel Brownley 31691379
 * @version 1.0
 */
public class PartnerSought {
    /**
     * Gender being looked for
     */
    private char gender;
    /**
     * Minimum age being looked for
     */
    private int MinAge;
    /**
     * Maximum age being looked for
     */
    private int MaxAge;
    /**
     * Minimum income being looked for
     */
    private int MinIncome;
    /**
     * Maximum income being looked for
     */
    private int MaxIncome;
    
    /**
     * Creates a PartnerSought 
     * 
     * Creates a PartnerSought with the params
     * 
     * @param newGen
     * @param minA
     * @param maxA
     * @param minI
     * @param maxI 
     */
    PartnerSought(char newGen,int minA,int maxA,int minI,int maxI)
    {
        SetGender(newGen);
        SetMinAge(minA);
        SetMaxAge(maxA);
        SetMinIncome(minI);
        SetMaxIncome(maxI);
    }
    
    /**
     * Gets the gender
     * 
     * @return gender
     */
    char GetGender()
    {
        return gender;
    }
    
    /**
     * Get the minimum ages
     * 
     * @return MinAge
     */
    int GetMinAge()
    {
        return MinAge;
    }
    
    /**
     * Gets the maximum age
     * 
     * @return MaxAge
     */
    int GetMaxAge()
    {
        return MaxAge;
    }
    
    /**
     * Gets the minimum income
     * 
     * @return MinIncome
     */
    int GetMinIncome()
    {
        return MinIncome;
    }
    
    /**
     * Gets the maximum income
     * 
     * @return MaxIncome
     */
    int GetMaxIncome()
    {
        return MaxIncome;
    }
    
    /**
     * Set gender to newG. If newG is not M or F, default is set
     * 
     * @param newG 
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
     * Sets minimum age to age. If age is below 18, minimum age is set to 18
     * 
     * @param age 
     */
    void SetMinAge(int age)
    {
        if (age>18)
        {
            MinAge=age;            
        }
        else
        {
            System.out.println("The age values entered were not valid. Minimum age has been set to 18.");
            MinAge=18;
        }
    }
    
    /**
     * Set maximum age to age. If maximum age is less than minimum age, maximum age is set to minimum age plus 1
     * 
     * @param age 
     */
    void SetMaxAge(int age)
    {
        if(age>MinAge)
        {            
            MaxAge=age;
        }
        else
        {
            System.out.println("The age values entered were not valid. Maximum age has been set to minimum age plus 1.");
            MaxAge=MinAge+1;
        }
    }
    
    /**
     * Sets minimum income to income. If income is below 0, minimum income is set to 0
     * 
     * @param income 
     */
    void SetMinIncome(int income)
    {
        if(income<0)
        {
            MinIncome=0;
        }
        else
        {
            System.out.println("The income values entered were not valid. Minimum income has been set to 0.");
            MinIncome=income;
        }
    }
    
    /**
     * Set maximum income to income. If maximum income is less than minimum income, maximum income is set to minimum income plus 1
     * 
     * @param income 
     */
    void SetMaxIncome(int income)
    {
        if(income>MinIncome)
        {
            MaxIncome=income;
        }
        else
        {
            System.out.println("The income values entered were not valid. Maximum income has been set to minimum income plus 1.");
            MaxIncome=MinIncome+1;
        }
    }
}
