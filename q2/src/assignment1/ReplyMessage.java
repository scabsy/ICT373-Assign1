package assignment1;

/**
 * @author Samuel Brownley 31691379
 * @version 1.0
 */
public class ReplyMessage {
    /**
     * Customer who sent the message
     */
    private Responder owner;
    /**
     * Text of the message
     */
    private String msgText;
    
    /**
     * Creates a ReplyMessage
     * 
     * Creates a new ReplyMessage using the given params
     * 
     * @param newO      
     * @param newMsg    
     */
    ReplyMessage(Responder newO,String newMsg)
    {
        SetOwner(newO);
        SetMsg(newMsg);
    }
    
    /**
     * Sets owner to newO
     * 
     * @param newO 
     */
    void SetOwner(Responder newO)
    {
        owner = newO;
    }
    
    /**
     * Gets owner
     * 
     * @return owner
     */
    Responder GetOwner()
    {
        return owner;
    }
    
    /**
     * Sets msgText to newMsg
     * 
     * @param newMsg 
     */
    void SetMsg(String newMsg)
    {        
        msgText = newMsg;
    }
    
    /**
     * Get msgText
     * 
     * @return msgText
     */
    String GetMsg()
    {
        return msgText;
    }
}
