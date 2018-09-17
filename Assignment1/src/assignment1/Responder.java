package assignment1;

/**
 * @author Samuel Brownley 31691379
 * @version 1.0
 */
public class Responder extends Customer{
    /**
     * Creates a new responder
     * 
     * Calls the parent constructor with the params
     * 
     * @param name          username of the new responder
     * @param newG          gender of the new responder
     * @param newAge        age of the new responder
     * @param newIncome     income of the new responder
     */
    Responder(String name,char newG,int newAge,int newIncome)
    {
        super(name,newG,newAge,newIncome);
    }
}
