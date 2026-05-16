import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements MouseListener, ActionListener
{
    JLabel titleLbl, namelbl, passlbl, imglbl, taglineLbl, loginTitleLbl, registerLbl;
    JTextField namefld;
    JPasswordField passfld;
    JButton logbtn;
    JPanel panel, leftPanel, rightPanel;
    Color titleColor, bgColor, panelBgColor, btnColor;  // WHERE TO CHANGE COLORS
    Font titleFont, myfont;
    ImageIcon img;

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
        panel.setBackground(bgColor);

        // ========== LEFT SIDE PANEL ==========
        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(bgColor);
        leftPanel.setBounds(0, 0, 450, 450);

        // Title "HUNGRY TYGER"
        titleLbl = new JLabel("HUNGRY TYGER");
        titleLbl.setBounds(30, 30, 300, 50);
        titleLbl.setFont(titleFont);
        titleLbl.setForeground(titleColor);  // WHERE TO CHANGE: titleColor
        leftPanel.add(titleLbl);

        // Image (Tiger with food)
        // WHERE TO CHANGE IMAGE: Replace path below
        img = new ImageIcon("E:/MY University/2nd semester/FINAL/OOP1/JAVA PROJECT/All images/tiger-food.png");
        imglbl = new JLabel(img);
        imglbl.setBounds(50, 100, 350, 250);
        leftPanel.add(imglbl);

        // Tagline
        taglineLbl = new JLabel("Explore a vast amount of restaurants to satiate your hunger");
        taglineLbl.setBounds(30, 360, 400, 30);
        taglineLbl.setFont(new Font("Cambria", Font.ITALIC, 14));
        taglineLbl.setForeground(titleColor);  // WHERE TO CHANGE: titleColor
        leftPanel.add(taglineLbl);

        panel.add(leftPanel);

        // ========== RIGHT SIDE LOGIN PANEL ==========
        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(panelBgColor);  // WHERE TO CHANGE: panelBgColor
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
        logbtn.setBackground(btnColor);  // WHERE TO CHANGE: btnColor
        logbtn.setForeground(Color.WHITE);
        logbtn.setFont(new Font("Cambria", Font.PLAIN, 20));
        logbtn.setFocusPainted(false);
        logbtn.addMouseListener(this);
        logbtn.addActionListener(this);
        rightPanel.add(logbtn);

        // Register text
        registerLbl = new JLabel("Don't have an account? Register");
        registerLbl.setBounds(40, 330, 250, 40);
        registerLbl.setFont(new Font("Cambria", Font.PLAIN, 14));
        registerLbl.setForeground(titleColor);  // WHERE TO CHANGE: titleColor
        registerLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rightPanel.add(registerLbl);

        panel.add(rightPanel);

        this.add(panel);
        this.setVisible(true);
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
    }

    public void mouseExited(MouseEvent me)
    {
        if(me.getSource() == logbtn)
        {
            logbtn.setBackground(btnColor);  // Back to original color
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == logbtn)
        {
            String s1 = namefld.getText();
            String s2 = passfld.getText();

            if(s1.isEmpty() || s2.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill Up All");
            }
        }
    }
}