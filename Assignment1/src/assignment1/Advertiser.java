package assignment1;

import java.util.ArrayList;

/**
 * @author Samuel Brownley 31691379
 * @version 1.0
 */
public class Advertiser extends Customer {
    /**
     * The advertisement the users wishes to be seen by other users
     */
    private String advert;
    /**
     * The details of the partners being looked for
     */
    private PartnerSought partnerSought;
    /**
     * A list of messages this user has received
     */
    private ArrayList<ReplyMessage>  replyMessages;
    
    /**
     * Creates an advertiser
     * 
     * Sets the values to the parameters and initialises the message array
     * 
     * @param name          username of the new advertiser
     * @param newG          gender of the new advertiser
     * @param newAge        age of the new advertiser
     * @param newIncome     income of the new advertiser
     * @param newAd         advert of the new advertiser
     * @param newDetails    details of wanted partners
     */
    Advertiser(String name,char newG,int newAge,int newIncome,String newAd,PartnerSought newDetails)
    {
        super(name,newG,newAge,newIncome);
        SetAdvert(newAd);
        SetPart(newDetails);
        replyMessages = new ArrayList<>();
    }
    
    /**
     * Set the advert to newAd
     * 
     * @param newAd 
     */
    void SetAdvert(String newAd)
    {
        advert=newAd;
    }
    
    /**
     * Gets the advert
     * 
     * @return advert
     */
    String GetAdvert()
    {
        return advert;
    }
    
    /**
     * Sets  partnerSought to newPart
     * 
     * @param newPart 
     */
    void SetPart(PartnerSought newPart)
    {
        partnerSought = newPart;
    }
    
    /**
     * Returns the partner details
     * 
     * @return 
     */
    PartnerSought GetPart()
    {
        return partnerSought;
    }
    
    /**
     * Returns the list of messages
     * 
     * @return 
     */
    ArrayList<ReplyMessage> GetMsgs()
    {
        return replyMessages;
    }
    
    /**
     * Add newMsg to the list of messages
     * 
     * @param newMsg 
     */
    void AddMsg(ReplyMessage newMsg)
    {
        replyMessages.add(newMsg);
    }
    
    /**
     * Remove newMsg from the list of messages
     * 
     * @param msg 
     */
    void RemoveMsg(ReplyMessage msg)
    {
        replyMessages.remove(msg);
    }
}
