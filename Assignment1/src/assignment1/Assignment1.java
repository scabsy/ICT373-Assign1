package assignment1;

import java.util.Scanner;

/**
 * @author Samuel Brownley 31691379
 * @version 1.0
 */
public class Assignment1 {
    static private Customers cust = new Customers();
    static private Scanner scan = new Scanner(System.in).useDelimiter("\\n");
    static private int input;
    
    public static void main(String[] args) 
    {            
        
        PrintOptions();
        input = GetValidInt();
        System.out.println();
        while(input!=0)
        {
            if (input==1)
            {
                if(cust.isLoggedIn())
                {                    
                    String uname,pwrd;
                    int pwrdCnt=1;
                    System.out.print("Enter your username: ");
                    uname=GetValidStr();   
                    if (cust.CustExist(uname))
                    {
                        System.out.print("Enter your password: ");
                        pwrd=GetValidStr();
                        while(pwrdCnt<3 && !cust.Login(uname, pwrd))
                        {                
                            pwrdCnt++;
                            System.out.println("Incorrect password. Try again.");
                            System.out.print("Enter your password: ");
                            pwrd=GetValidStr();
                        }
                        if(cust.Login(uname, pwrd))
                        {
                            System.out.println(uname + " has been logged in.");
                        }
                        else
                        {
                            System.out.println("Password attempt limit has been reached.");
                        }
                    }
                    else
                    {
                        System.out.println("That user does not exist.");
                    }
                }
                else
                {
                    cust.Logout();
                }
            }
            else if(input==2)
            {    
                System.out.println("1. Advertiser");
                System.out.println("2. Responder");
                System.out.println("0. Go back");
                int input=GetValidInt();

                if(input!=0)
                {           
                    String name;
                    char gender;
                    int age;
                    int income;

                    System.out.print("\nEnter name(username): ");
                    name=GetValidStr();
                    System.out.print("Enter gender(M/F): ");
                    gender=GetValidStr().charAt(0);
                    System.out.print("Enter age: ");
                    age=GetValidInt();
                    System.out.print("Enter income: ");
                    income=GetValidInt();

                    if(input==1)
                    {
                        String advert;
                        char lookingGen;
                        int MinAge;
                        int MaxAge;
                        int MinIncome;
                        int MaxIncome;

                        System.out.print("Enter a short introduction to yourself: ");
                        advert=GetValidStr();
                        System.out.println("The following questions are about the type of people you are looking for.");                    
                        System.out.print("Enter gender(M/F): ");
                        lookingGen=GetValidStr().charAt(0);
                        System.out.print("Enter minimum age: ");
                        MinAge=GetValidInt();
                        System.out.print("Enter maximum age: ");
                        MaxAge=GetValidInt();
                        System.out.print("Enter minimum income: ");
                        MinIncome=GetValidInt();
                        System.out.print("Enter maximum income: ");
                        MaxIncome=GetValidInt();

                        cust.add(name,gender,age,income,advert,lookingGen,MinAge,MaxAge,MinIncome,MaxIncome);
                    }
                    else if(input==2)
                    {
                        cust.add(name,gender,age,income);
                    }
                    System.out.println(name + " has been created.");
                }
            }
            else if(input==3)
            {
                String name;
                boolean removed;
                System.out.print("Enter a username to delete: ");
                name=GetValidStr();

                removed=cust.remove(name);

                if(!removed)
                {
                    System.out.println("Customer does not exist.");
                }
                else
                {
                    System.out.println(name + " has been removed.");
                }
            }
            else if(input==4)
            {            
                System.out.println("Name    Gender  Age Income    Advert");
                PrintAdvertisers();
            }
            else if(input==5)
            {
                System.out.println("Name    Gender  Age Income");
                PrintResponders();
            }
            else if(input==6)
            {
                if(cust.isResponder())
                {
                    int matchCount;
                    matchCount=cust.FindMatches();
                    if(matchCount>0)
                    {        
                        String message;
                        PrintMatchesOpt();
                        System.out.print("Enter a number for who you would like the message: ");
                        input=GetValidInt();
                        while(input!=0)
                        {                            
                            System.out.println("Enter a message you would like to send to " + cust.GetMatches().get(input-1).GetName() + ": ");
                            message=GetValidStr();
                            
                            cust.SendMessage(cust.GetMatches().get(input-1), message);
                            
                            PrintMatchesOpt();
                            System.out.print("Enter a number for who you would like the message: ");
                            input=GetValidInt();
                        }
                    }
                    else
                    {
                        System.out.println("No matches.");
                    }
                }
                else if(cust.isAdvertiser())
                {
                    PrintMessOpt();
                    input=GetValidInt();
                    while(input!=0)
                    {
                        if(input==1)
                        {
                            int msgToRead;
                            System.out.println("\nYou have " + cust.GetMsgCount()+ " messages.");
                            PrintMessNames();
                            
                            System.out.print("Enter number of message to read: ");
                            msgToRead=GetValidInt();
                            
                            while(msgToRead!=0)
                            {
                                if(msgToRead<=cust.GetMsgCount())
                                {
                                    System.out.println("From: " + cust.GetMsgs().get(msgToRead-1).GetOwner().GetName());
                                    System.out.println("Message: " + cust.GetMsgs().get(msgToRead-1).GetMsg());

                                    PrintMessNames();

                                    System.out.print("Enter number of message to read: ");
                                    msgToRead=GetValidInt();
                                }
                                else
                                {
                                    System.out.println("Invalid message number.\n");
                                    PrintMessNames();

                                    System.out.print("Enter number of message to read: ");
                                    msgToRead=GetValidInt();
                                    
                                }
                                
                            }
                        }
                        else if(input==2)
                        {
                            int msgToDelete;
                            System.out.println("\nYou have " + cust.GetMsgCount() + " messages.");
                            PrintMessNames();
                            
                            System.out.print("Enter number of message to delete: ");
                            msgToDelete=GetValidInt();
                            
                            while(msgToDelete!=0)
                            {         
                                if(msgToDelete<=cust.GetMsgCount())
                                {
                                    cust.RemoveMsg(msgToDelete-1);

                                    PrintMessNames();

                                    System.out.print("Enter number of message to delete: ");
                                    msgToDelete=GetValidInt();
                                }
                                else
                                {
                                    System.out.println("Invalid message number.\n");
                                    PrintMessNames();

                                    System.out.print("Enter number of message to delete: ");
                                    msgToDelete=GetValidInt();
                                    
                                }
                            }
                        }
                        PrintMessOpt();
                        input=GetValidInt();
                    }
                }
            }
            
            System.out.println();
            
            PrintOptions();
            input = GetValidInt();
            System.out.println();
        }
    }
    
    //Prints the options the program starts with and alters based on the type of user logged in
    static void PrintOptions()
    {
        if (cust.isLoggedIn())
        {                
            System.out.println("1. Login");
        }
        else
        {
            System.out.println("1. Logout");
        }
        System.out.println("2. Create account");
        System.out.println("3. Delete account");            
        System.out.println("4. List all advertisers");      
        System.out.println("5. List all responders");   
        if (cust.isResponder())
            System.out.println("6. Check matches");
        else if(cust.isAdvertiser())
            System.out.println("6. Check messages");
        System.out.println("0. Exit");
    }
    
    //Print Create Account options
    static void PrintCAOpt()
    {
        System.out.println("1. Advertiser");
        System.out.println("2. Responder");
        System.out.println("0. Go back");
    }
    
    //Prints match options
    static void PrintMatchesOpt()
    {
        for (int j=0;j<cust.FindMatches();j++) 
        {
            System.out.println((j+1) + ". " + cust.GetMatches().get(j).GetName());
        }
        System.out.println("0. Back");
    }
    
    //Prints message options
    static void PrintMessOpt()
    {
        System.out.println("1. Read messages");
        System.out.println("2. Delete messages");                    
        System.out.println("0. Back");
    }
    
    //Print the options when selecting to read/delete messages
    static void PrintMessNames()
    {
        for (int i=0;i<cust.GetMsgCount();i++) 
        {
            ReplyMessage GetMsg=cust.GetMsgs().get(i);
            System.out.println((i+1) + ". From: " + GetMsg.GetOwner().GetName());
        }
        System.out.println("0. Back");
    }
    
    //Prints all the advertisers in Customers    
    static void PrintAdvertisers()
    {
        for(int i=0;i<cust.GetAdvertiser().size();i++)
        {
            System.out.println(String.format("%-8s%-8s%-4s%-10s%s", cust.GetAdvertiser().get(i).GetName(),cust.GetAdvertiser().get(i).GetGender(),cust.GetAdvertiser().get(i).GetAge(),cust.GetAdvertiser().get(i).GetIncome(),cust.GetAdvertiser().get(i).GetAdvert()));
        }
    }
    
    //Prints all the responders in Customers
    static void PrintResponders()
    {
        for(int i=0;i<cust.GetResponder().size();i++)
        {
            System.out.println(String.format("%-8s%-8s%-4s%-10s", cust.GetResponder().get(i).GetName(),cust.GetResponder().get(i).GetGender(),cust.GetResponder().get(i).GetAge(),cust.GetResponder().get(i).GetIncome()));
        }
    }
        
    //Gets a valid integer
    static int GetValidInt()
    {
        int a = 0;
        boolean valid=false;
        
        do
        {
            if(scan.hasNextInt())
            {
                a=scan.nextInt();
                valid=true;
            }
            else
            {                
                scan.nextLine();
                System.out.print("Enter a valid number: ");
            }
        }
        while(!valid);
        return a;
    }
    
    //Gets a valid string 
    static String GetValidStr()
    {
        String a = "";
        boolean valid=false;
        
        do
        {
            if(scan.hasNext())
            {
                a=scan.next();
                valid=true;
            }
            else
            {                
                scan.nextLine();
                System.out.print("Enter a valid string: ");
            }
        }
        while(!valid);
        return a;
    }
}
