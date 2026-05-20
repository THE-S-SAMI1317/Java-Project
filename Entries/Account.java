package Entries;

import java.lang.*;
import java.util.*;
import java.io.*;
import Frames.*;

public class Account
{
    public static String currentUser = "";
    
    private String userName;
    private String userMail;
    private String pass;
    
    public Account() 
	{
		
	}
    
    public Account(String userName, String userMail, String pass)
    {
        this.userName = userName;
        this.userMail = userMail;
        this.pass = pass;
    }
    
   
    public void setUserName(String userName)
	{ 
		this.userName = userName;
	}
    public void setUserMail(String userMail) 
	{
		this.userMail = userMail; 
	}
    public void setPass(String pass)
	{
		this.pass = pass;
	}
    
    
    public String getUserName() 
	{
		return userName; 
	}
    public String getUserMail() 
	{
		return userMail;
	}
    public String getPass()
	{
		return pass;
	}
    
    // Add new account 
    public void addAccount()
    {
        try
        {
            FileWriter fw = new FileWriter("./Data/Data.txt", true);
            fw.write(userName + "\t" + userMail + "\t" + pass + "\n");
            fw.close();
        }
        catch(IOException e)
		{
			e.printStackTrace();
		}
    }
    
    
    public boolean getAccount(String umail, String upass)
    {
        try
        {
            Scanner sc = new Scanner(new File("./Data/Data.txt"));
            while(sc.hasNextLine())
            {
                String[] data = sc.nextLine().split("\t");
                
                if(data.length >= 3 && data[1].equals(umail) && data[2].equals(upass))
                {
                    sc.close();
                    return true;
                }
            }
            sc.close();
        }
        catch(Exception e)
		{
			e.printStackTrace();
		}
        return false;
    }
    
    
    public void updateAccount(String oldUserName, String newName, String newMail, String newPass)
    {
        try
        {
            Scanner sc = new Scanner(new File("./Data/Data.txt"));
            String allData = "";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String data[] = line.split("\t");
                
                if(data.length >= 3 && data[0].equals(oldUserName))
                    allData += newName + "\t" + newMail + "\t" + newPass + "\n";
                else
                    allData += line + "\n";
            }
            sc.close();
            
            FileWriter fw = new FileWriter("./Data/Data.txt");
            fw.write(allData);
            fw.close();
        }
        catch(Exception e)
		{
			e.printStackTrace(); 
		}
    }
    
    
    public void deleteAccount(String userName, String userMail, String pass)
    {
        try
        {
            Scanner sc = new Scanner(new File("./Data/Data.txt"));
            String allData = "";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String data[] = line.split("\t");
                
                if(data.length < 3 || !data[0].equals(userName) || !data[1].equals(userMail) || !data[2].equals(pass))
                {
                    allData += line + "\n";
                }
            }
            sc.close();
            
            FileWriter fw = new FileWriter("./Data/Data.txt");
            fw.write(allData);
            fw.close();
        }
        catch(Exception e)
		{
			e.printStackTrace(); 
		}
    }
}