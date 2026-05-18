package Entries;

import java.lang.*;
import java.util.*;
import java.io.*;
import Frames.*;

public class Account
{
	public static String currentUser = "";  //Holds logged-in username
	
	private String userName;
	private String userMail;
	private String pass;
	File entryFile;
	FileWriter enWrite, reWrite;
	Scanner sc;
	
	public Account()
	{
		
	}
	
	public Account(String userName, String userMail, String pass)
	{
		this.userName=userName;
		this.userMail=userMail;
		this.pass=pass;
	}
	
	public void setUserName(String userName)
	{
		this.userName=userName;
	}
	
	public void setUserMail(String userMail)
	{
		this.userMail=userMail;
	}
	
	public void setPass(String pass)
	{
		this.pass=pass;
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
	
	public void addAccount()
	{
		try
		{
			entryFile = new File("./Data/Data.txt");

			if (entryFile.getParentFile() != null && !entryFile.getParentFile().exists()) {
				entryFile.getParentFile().mkdirs();
			}

			entryFile.createNewFile();
			
			enWrite = new FileWriter(entryFile,true);
			
			enWrite.write(getUserName()+"\t");
			enWrite.write(getUserMail()+"\t");
			enWrite.write(getPass()+"\n");
			
			
			enWrite.flush();
			enWrite.close();
			
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public boolean getAccount(String uname, String umail, String upass)
	{
		boolean flag=false;
		try
		{
			entryFile=new File("./Data/Data.txt");
			
			sc=new Scanner(entryFile);
			
			while(sc.hasNextLine())
			{
				String line=sc.nextLine();
				String value[]=line.split("\t");
				if(value[0].equals(uname)&&value[1].equals(umail)&&value[2].equals(upass))
				{
					flag=true;
					break;
				}
			}
			
			sc.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return flag;
		}
	

		public void deleteAccount(String userName, String userMail, String userPass)
	{
		try
		{
			File oldFile = new File("./Data/Data.txt");
			File tempFile = new File("./Data/temp.txt");
			
			Scanner sc = new Scanner(oldFile);
			FileWriter fw = new FileWriter(tempFile);
			
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				String[] value = line.split("\t");
				
				if(value.length >= 3)
				{
					// Write all lines EXCEPT the one to delete
					if(!(value[0].equals(userName) && value[1].equals(userMail) && value[2].equals(userPass)))
					{
						fw.write(line + "\n");
					}
				}
			}
			
			sc.close();
			fw.flush();
			fw.close();
			
			// Replace old file with new file
			oldFile.delete();
			tempFile.renameTo(oldFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// ✅ ADD THIS: Update account method
	public void updateAccount(String oldName, String newName, String newMail, String newPass)
	{
		try
		{
			File oldFile = new File("./Data/Data.txt");
			File tempFile = new File("./Data/temp.txt");
			
			Scanner sc = new Scanner(oldFile);
			FileWriter fw = new FileWriter(tempFile);
			
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				String[] value = line.split("\t");
				
				if(value.length >= 3 && value[0].equals(oldName))
				{
					// Update this user's data
					fw.write(newName + "\t" + newMail + "\t" + newPass + "\n");
				}
				else
				{
					// Keep other users unchanged
					fw.write(line + "\n");
				}
			}
			
			sc.close();
			fw.flush();
			fw.close();
			
			// Replace old file with updated file
			oldFile.delete();
			tempFile.renameTo(oldFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// ✅ ADD THIS: Check if file is empty
	public boolean checkIfFileEmpty()
	{
		try
		{
			entryFile = new File("./Data/Data.txt");
			
			if(!entryFile.exists())
			{
				return true;
			}
			
			sc = new Scanner(entryFile);
			boolean hasContent = false;
			
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				if(!line.trim().isEmpty())
				{
					hasContent = true;
					break;
				}
			}
			sc.close();
			
			return !hasContent;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return true;
		}
	}
}