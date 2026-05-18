package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entries.*;

public class Register extends JFrame implements ActionListener, MouseListener
{
	JLabel logoLbl, regisLbl, uNameLbl, uMailLbl, passLbl, rePassLbl, messageRLbl, qLogLbl;
	JPasswordField passFld, rePassFld;
	JTextField uNameFld, uMailFld;
	JButton regisBtn, logBacBtn;
	JPanel panel, rightPanel, leftPanel;
	Color primaryOrange, secondryYellow, backgrdWhite1, backgrdWhite2, txtBlu;
	Font logoFnt, pgTitleFnt, secTitleFnt, txtFnt, reBtnFnt;
	ImageIcon logoIcon;
	
	public Register()
	{
		super("HUNGRY TYGER Registration Page");
		this.setSize(850, 450);
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
		
		// Left Panel
		leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setBackground(backgrdWhite1);
		leftPanel.setBounds(0, 0, 450, 450);
		
		// Right Panel 
		rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setBackground(backgrdWhite2);
		rightPanel.setBounds(480, 10, 320, 390);
        
		// Logo Label 
		logoLbl = new JLabel("HUNGRY TYGER");
		logoLbl.setBounds(30, 30, 300, 50);
		logoLbl.setFont(logoFnt);
		logoLbl.setForeground(primaryOrange);
		leftPanel.add(logoLbl);
		
		
		// Message Label 
		messageRLbl = new JLabel("Explore a vast amount of restaurants to satiate your hunger");
		messageRLbl.setBounds(30, 360, 400, 30);
		messageRLbl.setFont(new Font("Cambria", Font.ITALIC, 14));
		messageRLbl.setForeground(primaryOrange);
		leftPanel.add(messageRLbl);

		// Registration Title
		regisLbl = new JLabel("Registration");
		regisLbl.setBounds(0, 10, 320, 35);
		regisLbl.setForeground(primaryOrange);
		regisLbl.setFont(pgTitleFnt);
		regisLbl.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(regisLbl);
		
		// User Name Label & Field
		uNameLbl = new JLabel("User Name");
		uNameLbl.setBounds(30, 50, 260, 20);
		uNameLbl.setForeground(txtBlu);
		uNameLbl.setFont(secTitleFnt);
		rightPanel.add(uNameLbl);
		
		uNameFld = new JTextField();
		uNameFld.setBounds(30, 70, 260, 30);
		rightPanel.add(uNameFld);
		
		// Email Label & Field
		uMailLbl = new JLabel("E-mail");
		uMailLbl.setBounds(30, 110, 260, 20);
		uMailLbl.setForeground(txtBlu);
		uMailLbl.setFont(secTitleFnt);
		rightPanel.add(uMailLbl);
		
		uMailFld = new JTextField();
		uMailFld.setBounds(30, 130, 260, 30);
		rightPanel.add(uMailFld);
		
		// Password Label & Field
		passLbl = new JLabel("Password");
		passLbl.setBounds(30, 170, 260, 20);
		passLbl.setForeground(txtBlu);
		passLbl.setFont(secTitleFnt);
		rightPanel.add(passLbl);
		
		passFld = new JPasswordField();
		passFld.setBounds(30, 190, 260, 30);
		passFld.setEchoChar('*');
		rightPanel.add(passFld);
		
		// Re-enter Password Label & Field
		rePassLbl = new JLabel("Re-enter Password");
		rePassLbl.setBounds(30, 230, 260, 20);
		rePassLbl.setForeground(txtBlu);
		rePassLbl.setFont(secTitleFnt);
		rightPanel.add(rePassLbl);
		
		rePassFld = new JPasswordField();
		rePassFld.setBounds(30, 250, 260, 30);
		rePassFld.setEchoChar('*');
		rightPanel.add(rePassFld);
		
		// Register Button
		regisBtn = new JButton("Register");
		regisBtn.setBounds(30, 295, 260, 40);
		regisBtn.setBackground(primaryOrange);
		regisBtn.setForeground(Color.WHITE);
		regisBtn.setFont(reBtnFnt);
		regisBtn.addMouseListener(this);
		regisBtn.addActionListener(this);
		rightPanel.add(regisBtn);
		
		// Login page back Label
		qLogLbl = new JLabel("Already have an account?");
		qLogLbl.setBounds(40, 345, 160, 30);
		qLogLbl.setForeground(txtBlu);
		qLogLbl.setFont(txtFnt);
		rightPanel.add(qLogLbl);
		
		// Login Page back Button
		logBacBtn = new JButton("Login");
		logBacBtn.setBounds(200, 345, 80, 30); 
		logBacBtn.setBackground(primaryOrange);
		logBacBtn.setForeground(Color.WHITE);
		logBacBtn.setFont(txtFnt);
		logBacBtn.addMouseListener(this);
		logBacBtn.addActionListener(this);
		rightPanel.add(logBacBtn);
		
		panel.add(rightPanel);
		panel.add(leftPanel);
		this.add(panel);
	}
	
	public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me) 
	{
		if(me.getSource()==regisBtn)
		{
			regisBtn.setBackground(secondryYellow);
			regisBtn.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==logBacBtn)
		{
			logBacBtn.setBackground(secondryYellow);
			logBacBtn.setForeground(Color.BLACK);
		}
	}
	
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==regisBtn)
		{
			regisBtn.setBackground(primaryOrange);
			regisBtn.setForeground(Color.WHITE);
		}
		
		else if(me.getSource()==logBacBtn)
		{
			logBacBtn.setBackground(primaryOrange);
			logBacBtn.setForeground(Color.WHITE);
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==logBacBtn)
		{
			this.setVisible(false);
			LoginPage lp1 = new Loginpage();
            lp1.setVisible(true);
		}
		else if(ae.getSource()==regisBtn)
		{
			String s1=uNameFld.getText();
			String s2=uMailFld.getText();
			String s3=passFld.getText();
			String s4=rePassFld.getText();
			
			if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Fill out all the Details");
			}
			
			else
			{
				if(s3 == s4)
				{
					Account a1=new Account(s1,s2,s3);
					a1.addAccount();
					this.setVisible(false);
					LoginPage lp1 = new Loginpage();
					lp1.setVisible(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Re-entered Password does not match");
				}
					
				
			}
		}
	}
	
    
}