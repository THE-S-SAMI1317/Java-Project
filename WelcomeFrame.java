import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeFrame extends JFrame implements ActionListener
{
JLabel welcomelbl;
JButton startbtn;
JPanel panel;
Color mycolor,btnColor;
Font myfont,btnfont;
ImageIcon img;
JLabel imglbl;

public WelcomeFrame()
{
	super("Welcome");
	this.setSize(850, 450);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	mycolor=new Color(240,240,240);
	btnColor=new Color(75,201,204);
	
	myfont=new Font("Cambria",Font.ITALIC,36);
	btnfont=new Font("Cambria",Font.PLAIN,20);
	
	panel=new JPanel();
	panel.setLayout(null);
	panel.setBackground(mycolor);
	
	welcomelbl=new JLabel("Welcome");
	welcomelbl.setBounds(365,150,170,50);
	welcomelbl.setFont(myfont);

	panel.add(welcomelbl);
	
	startbtn=new JButton("Get started");
	startbtn.setBounds(350,300,180,45);
	startbtn.setFont(btnfont);
	startbtn.setBackground(new Color(255,165,0));
	startbtn.setForeground(Color.WHITE);
	startbtn.setFocusPainted(false);
	startbtn.addActionListener(this);
	panel.add(startbtn);

    img=new ImageIcon("E:/MY University/2nd semester/FINAL/OOP1/JAVA PROJECT/Final Project/Java-Project/Resources/welcome2.jpg");
	imglbl=new JLabel(img);
	imglbl.setBounds(0,0,850,450);
	panel.add(imglbl);   
	
	this.add(panel);
}

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==startbtn)
	{
		new LoginPage();
		this.dispose();
	}
}
}