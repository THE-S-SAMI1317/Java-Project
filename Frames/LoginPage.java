package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entries.*;

public class LoginPage extends JFrame implements MouseListener, ActionListener
{
    JLabel titleLbl, namelbl, passlbl, imglbl, taglineLbl, loginTitleLbl, registerLbl;
    JTextField namefld;
    JPasswordField passfld;
    JButton logbtn , registerbtn;
    JPanel panel, leftPanel, rightPanel;
    Color titleColor, bgColor, panelBgColor, btnColor;  // WHERE TO CHANGE COLORS
    Font titleFont, myfont;
    ImageIcon img;

    // ✅ Animation variables
    private Timer typingTimer;
    private String fullText = "Explore a vast amount of restaurants to satiate your hunger";
    private String currentText = "";
    private int charIndex = 0;

    public LoginPage()
    {
        super();
        this.setSize(850, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ====== WHERE TO CHANGE COLORS ======
        titleColor = new Color(248, 110, 81);    // Red/Orange for "HUNGRY TYGER"
        bgColor = new Color(240, 240, 240);       // Light gray background
        panelBgColor = new Color(255, 255, 255);  // White for login panel
        btnColor = new Color(248, 110, 81);       // Red/Orange for button
        // =====================================

        myfont = new Font("Cambria", Font.PLAIN, 18);
        titleFont = new Font("Brush Script MT", Font.BOLD, 36);  // Handwritten style

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(253, 245, 230));

        // ========== LEFT SIDE PANEL ==========
        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(255, 251, 240));
        leftPanel.setBounds(0, 0, 450, 450);

        // Title "HUNGRY TYGER"
        titleLbl = new JLabel("HUNGRY TYGER");
        titleLbl.setBounds(30, 30, 300, 50);
        titleLbl.setFont(titleFont);
        titleLbl.setForeground(titleColor);  // WHERE TO CHANGE: titleColor
        leftPanel.add(titleLbl);

        // Image (Tiger with food)
        // WHERE TO CHANGE IMAGE: Replace path below
        img = new ImageIcon("E:/MY University/2nd semester/FINAL/OOP1/JAVA PROJECT/Final Project/Java-Project/Resources/300x200.png");
        imglbl = new JLabel(img);
        imglbl.setBounds(50, 100, 350, 250);
        leftPanel.add(imglbl);

        // ✅ Tagline with typing animation
        taglineLbl = new JLabel("");  // Start empty for animation
        taglineLbl.setBounds(30, 360, 400, 30);
        taglineLbl.setFont(new Font("Cambria", Font.ITALIC, 14));
        taglineLbl.setForeground(titleColor);
        leftPanel.add(taglineLbl);


        panel.add(leftPanel);

        // ========== RIGHT SIDE LOGIN PANEL ==========
        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(255, 251, 240));  
        rightPanel.setBounds(500, 40, 320, 350);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Login Title (underlined)
        loginTitleLbl = new JLabel("Login");
        loginTitleLbl.setBounds(120, 40, 100, 30);
        loginTitleLbl.setFont(new Font("Cambria", Font.BOLD, 24));
        loginTitleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        rightPanel.add(loginTitleLbl);

        // Email Label
        namelbl = new JLabel("Email");
        namelbl.setBounds(30, 90, 100, 25);
        namelbl.setFont(new Font("Cambria", Font.PLAIN, 16));
        rightPanel.add(namelbl);

        // Email Field
        namefld = new JTextField();
        namefld.setBounds(30, 120, 260, 40);
        namefld.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        rightPanel.add(namefld);

        // Password Label
        passlbl = new JLabel("Password");
        passlbl.setBounds(30, 180, 100, 25);
        passlbl.setFont(new Font("Cambria", Font.PLAIN, 16));
        rightPanel.add(passlbl);

        // Password Field
        passfld = new JPasswordField();
        passfld.setBounds(30, 210, 260, 40);
        passfld.setEchoChar('*');
        passfld.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        rightPanel.add(passfld);

        // Login Button (Sign in)
        logbtn = new JButton("Sign in");
        logbtn.setBounds(30, 270, 260, 45);
        logbtn.setBackground(new Color(230, 90, 60));  // WHERE TO CHANGE: btnColor
        logbtn.setForeground(Color.WHITE);
        logbtn.setFont(new Font("Cambria", Font.PLAIN, 20));
        logbtn.setFocusPainted(false);
        logbtn.addMouseListener(this);
        logbtn.addActionListener(this);
        rightPanel.add(logbtn);

            // "Don't have an account?" label
        registerLbl = new JLabel("Don't have an account?");
        registerLbl.setBounds(80, 325, 150, 25);
        registerLbl.setFont(new Font("Cambria", Font.PLAIN, 13));
        registerLbl.setForeground(Color.GRAY);
        rightPanel.add(registerLbl);

        // "Register" button (styled to look like a link)
        registerbtn = new JButton("Register");
        registerbtn.setBounds(160, 325, 150, 25);  // Positioned right after the label
        registerbtn.setBackground(Color.WHITE);   // No background
        registerbtn.setForeground(titleColor);     // Same orange/red color
        registerbtn.setFont(new Font("Cambria", Font.BOLD , 13));
        registerbtn.setFocusPainted(false);
        registerbtn.setBorderPainted(false);       // No border
        registerbtn.setContentAreaFilled(false);   // Transparent background
        registerbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerbtn.addMouseListener(this);
        registerbtn.addActionListener(this);
        rightPanel.add(registerbtn); 

        // ✅ Start animation AFTER frame is visible
        this.setVisible(true);
        startTypingAnimation();  // ✅ Call animation method here

        panel.add(rightPanel);

        this.add(panel);
        this.setVisible(true);
    }

    // ✅ Animation method
    private void startTypingAnimation() {
        typingTimer = new Timer(50, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (charIndex < fullText.length()) {
                    currentText += fullText.charAt(charIndex);
                    taglineLbl.setText(currentText);
                    charIndex++;
                } else 
                    {
                         charIndex = 0;
                         currentText = "";
                    }
            }
        });
        typingTimer.start();
    }

    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}

    public void mouseEntered(MouseEvent me)
    {
        if(me.getSource() == logbtn)
        {
            logbtn.setBackground(new Color(230, 100, 70));  // Darker on hover
        }

        else if(me.getSource() == registerbtn)
        {
            registerbtn.setBackground(Color.WHITE);
            registerbtn.setForeground(titleColor);
        }
    }

    

    public void mouseExited(MouseEvent me)
    {
        if(me.getSource() == logbtn)
        {
            logbtn.setBackground(btnColor);  // Back to original color
        }

       else if(me.getSource() == registerbtn)
        {
            registerbtn.setBackground(Color.BLUE);
            registerbtn.setForeground(Color.BLUE);
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == logbtn)
        {
            String s1 = namefld.getText();
            String s2 = new String(passfld.getPassword());

            if(s1.isEmpty() || s2.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill Up All");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Login Successful!\nEmail: " + s1, "Success", JOptionPane.INFORMATION_MESSAGE);
                
                this.setVisible(false);
                HomePage h1= new HomePage();
                h1.setVisible(true);
            }
        }
 
        else if(ae.getSource() == registerbtn)
        {
            
            this.setVisible(false);
            Register r1 = new Register();
            r1.setVisible(true);
        }
    }
    
}