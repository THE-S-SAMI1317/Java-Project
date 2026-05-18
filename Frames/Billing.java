package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Billing extends JFrame implements ActionListener
{
    JLabel headerLbl, titleLbl, locLbl, addLbl, cityLbl, payLbl, nameLbl, cardLbl, cvvLbl,imglbl;
    JLabel delLbl, expLbl, basicLbl;
    
    JTextField addFld, nameFld, cardFld, cvvFld;
    JComboBox<String> cityBox;
    JRadioButton expBtn, basicBtn;
    ButtonGroup delGroup;
    
    JButton confirmBtn, backBtn;
    
    JPanel mainPanel, formPanel,imgPanel;
    Color primaryOrange, bgLight;
    Font titleFont, labelFont;
    ImageIcon img;

    public Billing()
    {
        super("Hungry Tyger - Check Out");
        this.setSize(850, 650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Colors & Fonts
        primaryOrange = new Color(248, 110, 81);
        bgLight = new Color(253, 245, 230);
        titleFont = new Font("Cambria", Font.BOLD, 28);
        labelFont = new Font("Cambria", Font.PLAIN, 16);
        
        // Main Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(bgLight);
        
        // Form Panel (takes full width now)
        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(bgLight);
        formPanel.setBounds(0, 0, 850, 650);


        img = new ImageIcon(getClass().getResource("/Resources/300x200.png"));
        imglbl = new JLabel(img);
        imglbl.setBounds(435, 200, 350, 250);
        mainPanel.add(imglbl);
        
        // Back Button
        backBtn = new JButton("← Back");
        backBtn.setBounds(20, 20, 80, 30);
        backBtn.setBackground(primaryOrange);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        formPanel.add(backBtn);
        
        // Header
        headerLbl = new JLabel("HUNGRY TYGER");
        headerLbl.setBounds(325, 20, 200, 40);
        headerLbl.setFont(new Font("Cambria", Font.BOLD, 24));
        headerLbl.setForeground(primaryOrange);
        formPanel.add(headerLbl);
        
        // Title
        titleLbl = new JLabel("Check Out");
        titleLbl.setBounds(20, 70, 200, 40);
        titleLbl.setFont(titleFont);
        titleLbl.setForeground(primaryOrange);
        formPanel.add(titleLbl);
        
        // ========== DELIVERY LOCATION ==========
        locLbl = new JLabel("Delivering location");
        locLbl.setBounds(20, 120, 200, 25);
        locLbl.setFont(new Font("Cambria", Font.BOLD, 18));
        formPanel.add(locLbl);
        
        addLbl = new JLabel("Address");
        addLbl.setBounds(20, 155, 100, 20);
        addLbl.setFont(labelFont);
        formPanel.add(addLbl);
        
        addFld = new JTextField();
        addFld.setBounds(20, 180, 400, 30);
        formPanel.add(addFld);
        
        cityLbl = new JLabel("City");
        cityLbl.setBounds(20, 225, 100, 20);
        cityLbl.setFont(labelFont);
        formPanel.add(cityLbl);
        
        String[] cities = {"Dhaka", "Chittagong", "Sylhet", "Rajshahi", "Khulna"};
        cityBox = new JComboBox<>(cities);
        cityBox.setBounds(20, 250, 400, 30);
        formPanel.add(cityBox);
        
        // ========== PAYMENT DETAILS ==========
        payLbl = new JLabel("Payment details");
        payLbl.setBounds(20, 300, 200, 25);
        payLbl.setFont(new Font("Cambria", Font.BOLD, 18));
        formPanel.add(payLbl);
        
        nameLbl = new JLabel("Card Holder Name");
        nameLbl.setBounds(20, 335, 150, 20);
        nameLbl.setFont(labelFont);
        formPanel.add(nameLbl);
        
        nameFld = new JTextField();
        nameFld.setBounds(20, 360, 400, 30);
        formPanel.add(nameFld);
        
        cardLbl = new JLabel("Card Number");
        cardLbl.setBounds(20, 400, 150, 20);
        cardLbl.setFont(labelFont);
        formPanel.add(cardLbl);
        
        cardFld = new JTextField();
        cardFld.setBounds(20, 425, 400, 30);
        formPanel.add(cardFld);
        
        cvvLbl = new JLabel("CVV");
        cvvLbl.setBounds(20, 465, 100, 20);
        cvvLbl.setFont(labelFont);
        formPanel.add(cvvLbl);
        
        cvvFld = new JTextField();
        cvvFld.setBounds(20, 490, 150, 30);
        formPanel.add(cvvFld);
        
        // ========== DELIVERY TYPE ==========
        delLbl = new JLabel("Delivery type");
        delLbl.setBounds(20, 535, 150, 20);
        delLbl.setFont(labelFont);
        formPanel.add(delLbl);
        
        expBtn = new JRadioButton("Express");
        expBtn.setBounds(20, 560, 100, 25);
        expBtn.setFont(labelFont);
        expBtn.setBackground(bgLight);
        formPanel.add(expBtn);
        
        basicBtn = new JRadioButton("Basic");
        basicBtn.setBounds(130, 560, 100, 25);
        basicBtn.setFont(labelFont);
        basicBtn.setBackground(bgLight);
        formPanel.add(basicBtn);
        
        delGroup = new ButtonGroup();
        delGroup.add(expBtn);
        delGroup.add(basicBtn);
        expBtn.setSelected(true);
        
        // ✅ CONFIRM BUTTON (Moved to Bottom-Right)
        confirmBtn = new JButton("Confirm Order");
        confirmBtn.setBounds(520, 550, 300, 50);
        confirmBtn.setBackground(primaryOrange);
        confirmBtn.setForeground(Color.WHITE);
        confirmBtn.setFont(new Font("Cambria", Font.BOLD, 18));
        confirmBtn.addActionListener(this);
        formPanel.add(confirmBtn);
        
        mainPanel.add(formPanel);
        this.add(mainPanel);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == backBtn)
        {
            this.setVisible(false);
            // HomePage hp = new HomePage(); hp.setVisible(true);
        }
        else if(ae.getSource() == confirmBtn)
        {
            // Simple validation
            if(addFld.getText().isEmpty() || nameFld.getText().isEmpty() || 
               cardFld.getText().isEmpty() || cvvFld.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please fill all details!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                // ✅ Show confirmation popup
                JOptionPane.showMessageDialog(this, 
                    "Congratulations!\nOrder has been confirmed\n\nTransaction ID: TXN12345", 
                    "Order Confirmed", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                this.setVisible(false);
            }
        }
    }

}
