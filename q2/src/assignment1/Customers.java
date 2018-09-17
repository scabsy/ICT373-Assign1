package assignment1;

import java.util.ArrayList;

/**
 * @author Samuel Brownley 31691379
 * @version 1.0
 */
public class Customers 
{
    /**
     * List of all customers
     */
    private ArrayList<Customer> cust = new ArrayList<>();
    /**
     * List of matches for the logged in customer (if responder)
     */
    private ArrayList<Customer> matches = new ArrayList<>();
    /**
     * Temporary customer used to determine of logged in
     */
    private Customer temp;
    /**
     * Customer that is logged in
     */
    private Customer loggedIn; 
    
    /**
     * Create a Customers
     * 
     * Set the temp to an empty Customer and then loggedIn to temp.
     * Creates 4 Advertisers and 4 Responders
     */
    Customers()
    {
        temp = new Customer("temp",'M',18,0);
        loggedIn = temp; 
        
        cust.add(new Advertiser("Laura",'F',28,35000,"Walks on the beach",new PartnerSought('M',25,35,25000,50000)));
        cust.add(new Advertiser("Larry",'M',42,35000,"Doing stuff",new PartnerSought('M',25,35,25000,50000)));
        cust.add(new Advertiser("Harry",'M',26,35000,"Playing games",new PartnerSought('F',25,35,25000,50000)));
        cust.add(new Advertiser("Sarah",'F',32,35000,"Not doing much",new PartnerSought('M',25,35,25000,50000)));
        
        cust.add(new Responder("Bill",'M',22,35000));
        cust.add(new Responder("Jim",'M',31,35000));
        cust.add(new Responder("Ashley",'F',33,35000));
        cust.add(new Responder("Lisa",'F',19,35000));
    }
     
    /**
     * Add a responder to the customer list
     * 
     * @param name      name of responder
     * @param gender    gender of responder
     * @param age       age of responder
     * @param income    income of responder
     */
    void add(String name,char gender,int age,int income)
    {
        cust.add(new Responder(name,gender,age,income));
    }
    
    /**
     * Add an advertiser to the customer list
     * 
     * @param name          name of advertiser
     * @param gender        gender of advertiser
     * @param age           age of advertiser
     * @param income        income of advertiser
     * @param advert        advert of advertiser
     * @param lookingGen    lookingGen of advertiser
     * @param MinAge        MinAge of advertiser
     * @param MaxAge        MaxAge of advertiser
     * @param MinIncome     MinIncome of advertiser
     * @param MaxIncome     MaxIncome of advertiser
     */
    void add(String name,char gender,int age,int income,String advert,char lookingGen,int MinAge,int MaxAge,int MinIncome,int MaxIncome)
    {
        cust.add(new Advertiser(name,gender,age,income,advert,new PartnerSought(lookingGen,MinAge,MaxAge,MinIncome,MaxIncome)));
    }
    
    /**
     * Remove user with the username name 
     * 
     * @param name  name of user to remove
     * @return true is customer was deleted and false if it didn't exist
     */
    boolean remove(String name)
    {
        for(int i=0;i<cust.size();i++)
        {
            if(cust.get(i).GetName().equals(name))
            {                     
                cust.remove(i);
                return true;
            }
        }      
        return false;
    }
    
    /**
     * Gets the customer at index i
     * 
     * @param i index to get 
     * @return customer at index i
     */
    Customer get(int i)
    {
        return cust.get(i);
    }
    
    /**
     * Gets the customer with username name
     * 
     * @param name name of user to get
     * @return customer with the username name
     */
    Customer get(String name)
    {
        Customer tmp = null;
        for(int i=0;i<cust.size();i++)
        {
            if(cust.get(i).GetName().equals(name))
            {                     
                tmp = cust.get(i);
            }
        }   
        return tmp;
    }
    
    /**
     * Logs in the appropriate user
     * 
     * @param uname Username to log in
     * @param pword Password of user
     * @return true if user is logged in, false if user doesn't exist or password doesn't match
     */
    boolean Login(String uname, String pword)
    {
        for(int i=0;i<cust.size();i++)
        {
            if(cust.get(i).GetName().equals(uname))
            {            
                if(cust.get(i).GetPwrd().equals(pword))
                {         
                    loggedIn=cust.get(i);
                    return true;
                }
                else 
                {
                    return false;
                }
            }
        }    
        return false;
    }
    
    /**
     * Resets logged in and matches array
     */
    void Logout()
    {
        System.out.println(loggedIn.GetName() + " has been logged out");
        loggedIn=temp;
        matches = new ArrayList<>();
    }
    
    /**
     * Gets whether a user is logged in
     * 
     * @return true if a user is logged in
     */
    boolean isLoggedIn()
    {
        return loggedIn.equals(temp);
    }
    
    /**
     * Returns the loggedIn customer
     * 
     * @return loggedIn
     */
    Customer CurrCust()
    {
        return loggedIn;
    }
    
    /**
     * Checks if logged in user is an Advertiser
     * 
     * @return true if advertiser, false otherwise
     */
    boolean isAdvertiser()
    {
        return loggedIn instanceof Advertiser;
    }
    
    /**
     * Checks if logged in user is an Responder
     * 
     * @return true if responder, false otherwise
     */
    boolean isResponder()
    {
        return loggedIn instanceof Responder;
    }
    
    /**
     * Sends the rm to Customer c
     * 
     * @param c     Customer the message is going to
     * @param rm    Message being sent
     */
    void SendMessage(Customer c, String rm)
    {
        Advertiser ad = (Advertiser)c;
        for(int i=0;i<cust.size();i++)
        {
            if(cust.get(i) instanceof Advertiser)
            {                
                if(cust.get(i).equals(ad))
                {                 
                    ((Advertiser)cust.get(i)).AddMsg(new ReplyMessage((Responder)loggedIn,rm));
                    System.out.println("Message sent.\n");
                    break;
                }
            }
        }   
    }
    
    /**
     * Check if certain customer exists in customer array
     * 
     * @param name username of user 
     * @return true if customer exists, false otherwise
     */
    boolean CustExist(String name)
    {
        for(int i=0;i<cust.size();i++)
        {
            if(cust.get(i).GetName().equals(name))
            {                     
                return true;
            }
        }    
        return false;
    }
    
    /**
     * Finds the number of matches for a user and populates the matches array
     * 
     * @return count of matches
     */
    int FindMatches()
    {
        int mCount=0;
        for (Customer cust1 : cust) 
        {
            if(cust1 instanceof Advertiser)
            {
                if(CompatiblePair((Responder)loggedIn,(Advertiser)cust1))
                {
                    matches.add(cust1);
                    mCount++;
                }
            }
        }
        return mCount;        
    }
    
    /**
     * Gets matches
     * 
     * @return matches
     */
    ArrayList<Customer> GetMatches()
    {
        return matches;
    }
    
    /**
     * Gets the number of messages a user has
     * 
     * @return number of messages of current user
     */
    int GetMsgCount()
    {
        return ((Advertiser)loggedIn).GetMsgs().size();
    }
    
    /**
     * Gets the messages a user has
     * 
     * @return list of messages
     */
    ArrayList<ReplyMessage> GetMsgs()
    {
        return ((Advertiser)loggedIn).GetMsgs();
    }
    
    /**
     * Removes a message at index mi
     * 
     * @param mi index of message
     */
    void RemoveMsg(int mi)
    {
        ((Advertiser)loggedIn).RemoveMsg(((Advertiser)loggedIn).GetMsgs().get(mi));
    }
    
    /**
     * Gets list of all advertisers
     * 
     * @return list of advertisers
     */
    ArrayList<Advertiser> GetAdvertiser()
    {
        ArrayList<Advertiser> ads = new ArrayList<>();
        for(int i=0;i<cust.size();i++)
        {
            if(cust.get(i) instanceof Advertiser)
            {
                ads.add((Advertiser) cust.get(i));
                //System.out.println(String.format("%-8s%-8s%-4s%-10s", cust.get(i).GetName(),cust.get(i).GetGender(),cust.get(i).GetAge(),cust.get(i).GetIncome()));
            }
        }  
        return ads;
    }
    
    /**
     * Gets list of all responders
     * 
     * @return list responder
     */
    ArrayList<Responder> GetResponder()
    {
        ArrayList<Responder> res = new ArrayList<>();
        for(int i=0;i<cust.size();i++)
        {
            if(cust.get(i) instanceof Responder)
            {
                res.add((Responder) cust.get(i));
                //System.out.println(String.format("%-8s%-8s%-4s%-10s", cust.get(i).GetName(),cust.get(i).GetGender(),cust.get(i).GetAge(),cust.get(i).GetIncome()));
            }
        }  
        return res;
    }
    
    /**
     * Compares a responders against the search criteria of an advertiser
     * 
     * @param a responder to be compared
     * @param b advertiser to be compared
     * @return false if any criteria is not met, true if all are met
     */
    private boolean CompatiblePair(Responder a, Advertiser b)
    {
        PartnerSought adPS = b.GetPart();
        if(a.GetGender()!=adPS.GetGender())
        {
            return false;
        }
        if(a.GetAge()<adPS.GetMinAge() || a.GetAge()>adPS.GetMaxAge())
        {
            return false;
        }
        if(a.GetIncome()<adPS.GetMinIncome() || a.GetIncome()>adPS.GetMaxIncome())
        {
            return false;
        }
        return true;
    }    
}