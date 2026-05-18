package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import Entries.*;

public class Profile extends JFrame implements ActionListener, MouseListener
{
	JLabel logoLbl, proflLbl, uNameLbl, uMailLbl, passLbl, rePassLbl;
	JPasswordField passFld, rePassFld;
	JTextField uNameFld, uMailFld;
	JButton updateBtn, deletBtn, bacBtn;
	JPanel panel, panelA;
	Color primaryOrange, secondryYellow, backgrdWhite1, backgrdWhite2, txtBlu;
	Font logoFnt, pgTitleFnt, secTitleFnt, txtFnt, reBtnFnt;
	ImageIcon logoIcon;
	
	void loadCurrentData()
	{
		try
		{
			Scanner sc = new Scanner(new File("./Data/Data.txt"));
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				String[] value = line.split("\t");
				if(value[0].equals(Account.currentUser)) {
					uNameFld.setText(value[0]);
					uMailFld.setText(value[1]);
			
					break;
				}
			}
			sc.close();
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	
	public Profile()
	{
		super("HUNGRY TYGER Profile Page");
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Colors
		primaryOrange = new Color(248, 110, 81);
		secondryYellow = new Color(242, 200, 91);
		backgrdWhite1 = new Color(253, 245, 230);
		backgrdWhite2 = new Color(255, 251, 240);
		txtBlu = new Color(31, 41, 55);
		
		// Fonts
		logoFnt = new Font("Cambria", Font.BOLD, 32);
		pgTitleFnt = new Font("Cambria", Font.BOLD, 24);
		secTitleFnt = new Font("Cambria", Font.PLAIN, 16);
		txtFnt = new Font("Cambria", Font.PLAIN, 13);
		reBtnFnt = new Font("Cambria", Font.PLAIN, 20);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(backgrdWhite1);
		
		panelA = new JPanel();
		panelA.setLayout(null);
		panelA.setBackground(backgrdWhite2);
		panelA.setBounds(20,20,950,650);
		
		// User Name Label & Field
		uNameLbl = new JLabel("Enter new username");
		uNameLbl.setBounds(125, 100, 200, 30);
		uNameLbl.setForeground(txtBlu);
		uNameLbl.setFont(secTitleFnt);
		panelA.add(uNameLbl);
		
		uNameFld = new JTextField();
		uNameFld.setBounds(350, 100, 450, 30);
		panelA.add(uNameFld);
		
		// Email Label & Field
		uMailLbl = new JLabel("Enter New E-mail");
		uMailLbl.setBounds(125, 170, 200, 30);
		uMailLbl.setForeground(txtBlu);
		uMailLbl.setFont(secTitleFnt);
		panelA.add(uMailLbl);
		
		uMailFld = new JTextField();
		uMailFld.setBounds(350, 170, 450, 30);
		panelA.add(uMailFld);
		
		// Password Label & Field
		passLbl = new JLabel("Enter New Password");
		passLbl.setBounds(125, 240, 200, 30);
		passLbl.setForeground(txtBlu);
		passLbl.setFont(secTitleFnt);
		panelA.add(passLbl);
		
		passFld = new JPasswordField();
		passFld.setBounds(350, 240, 450, 30);
		passFld.setEchoChar('*');
		panelA.add(passFld);
		
		// Re-enter Password Label & Field
		rePassLbl = new JLabel("Re-enter New Password");
		rePassLbl.setBounds(125, 310, 200, 30);
		rePassLbl.setForeground(txtBlu);
		rePassLbl.setFont(secTitleFnt);
		panelA.add(rePassLbl);
		
		rePassFld = new JPasswordField();
		rePassFld.setBounds(350, 310, 450, 30);
		rePassFld.setEchoChar('*');
		panelA.add(rePassFld);
		
		// Update Button
		updateBtn = new JButton("Update");
		updateBtn.setBounds(225, 420, 140, 50);
		updateBtn.setBackground(Color.GREEN);
		updateBtn.setForeground(Color.WHITE);
		updateBtn.setFont(reBtnFnt);
		updateBtn.addMouseListener(this);
		updateBtn.addActionListener(this);
		panelA.add(updateBtn);
		
		// Delete Button
		deletBtn = new JButton("Delete");
		deletBtn.setBounds(405, 420, 140, 50);
		deletBtn.setBackground(Color.RED);
		deletBtn.setForeground(Color.WHITE);
		deletBtn.setFont(reBtnFnt);
		deletBtn.addMouseListener(this);
		deletBtn.addActionListener(this);
		panelA.add(deletBtn);
		
		// back Button
		bacBtn = new JButton("Back");
		bacBtn.setBounds(585, 420, 140, 50); 
		bacBtn.setBackground(secondryYellow);
		bacBtn.setForeground(Color.WHITE);
		bacBtn.setFont(txtFnt);
		bacBtn.addMouseListener(this);
		bacBtn.addActionListener(this);
		panelA.add(bacBtn);
		
		panel.add(panelA);
		this.add(panel);
		
	}
	
	
	public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me) 
	{
		if(me.getSource()==updateBtn)
		{
			updateBtn.setBackground(secondryYellow);
			updateBtn.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==bacBtn)
		{
			bacBtn.setBackground(secondryYellow);
			bacBtn.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==deletBtn)
		{
			deletBtn.setBackground(secondryYellow);
			deletBtn.setForeground(Color.BLACK);
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSourse()==updateBtn)
		{
			updateBtn.setBackground(Color.GREEN);
			updateBtn.setForeground(Color.WHITE);
		}
		
		else if(me.getSource()==bacBtn)
		{
			bacBtn.setBackground(secondryYellow);
			bacBtn.setForeground(Color.WHITE);
		}
		
		else if(me.getSource()==deletBtn)
		{
			deletBtn.setBackground(Color.RED);
			deletBtn.setForeground(Color.WHITE);
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bacBtn)
		{
			this.setVisible(false);
			HomePage h1 = new HomePage();
            h1.setVisible(true);
		}
		else if(ae.getSource()==deletBtn)
		{
			int confirmDel = JOptionPane.showConfirmDialog(this, "Delete this account?");
			if(confirmDel == 0)  // 0 = YES
			{
				String mail = uMailFld.getText();
				String pass = new String(passFld.getPassword());
				
				Account acc = new Account();
				acc.deleteAccount(Account.currentUser, mail, pass);
				
				Account.currentUser = "";  // Clear login
				JOptionPane.showMessageDialog(this, "Deleted!");
				this.dispose();
				LoginPage lp2 = new Loginpage();
				lp2.setVisible(true);
			}
		}
		else if(ae.getSource()==updateBtn)
		{
			String newName = uNameFld.getText();
			String newMail = uMailFld.getText();
			String newPass = new String(passFld.getPassword());
			
			// Using Account's update method
			Account acc = new Account();
			acc.updateAccount(Account.currentUser, newName, newMail, newPass);
			
			// Update static tracker if username changed
			Account.currentUser = newName;
			
			JOptionPane.showMessageDialog(this, "Updated!");
		}
	}
	
	loadCurrentData(); //cons for profile details
}
		