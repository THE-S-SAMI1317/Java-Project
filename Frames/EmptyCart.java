package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmptyCart extends JFrame implements ActionListener 
{
    JLabel headerLbl, emptyLbl, msgLbl, imgLbl;
    JButton backBtn;
    JPanel panel;
    Color primaryOrange, bgColor;

    public EmptyCart() 
    {
        super("Hungry Tyger - Empty Cart");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Colors
        primaryOrange = new Color(248, 110, 81);
        bgColor = new Color(253, 245, 230);

        // Main Panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(bgColor);

        // Header
        headerLbl = new JLabel("HUNGRY TYGER");
        headerLbl.setBounds(300, 20, 200, 40);
        headerLbl.setFont(new Font("Cambria", Font.BOLD, 24));
        headerLbl.setForeground(primaryOrange);
        panel.add(headerLbl);

        // "Cart is Empty" Message
        emptyLbl = new JLabel("Your Cart is Empty!");
        emptyLbl.setBounds(150, 150, 500, 50);
        emptyLbl.setFont(new Font("Cambria", Font.BOLD, 32));
        emptyLbl.setForeground(primaryOrange);
        emptyLbl.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(emptyLbl);

        //LOGO
        imgLbl = new JLabel("/Resources/300x200.png");
        

        // Subtitle Message
        msgLbl = new JLabel("Please add some delicious items to continue.");
        msgLbl.setBounds(150, 210, 500, 30);
        msgLbl.setFont(new Font("Cambria", Font.PLAIN, 18));
        msgLbl.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(msgLbl);

        // Back Button
        backBtn = new JButton("Back to Home");
        backBtn.setBounds(300, 300, 200, 50);
        backBtn.setBackground(primaryOrange);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(new Font("Cambria", Font.BOLD, 18));
        backBtn.addActionListener(this);
        panel.add(backBtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == backBtn) 
        {
            this.dispose(); // Close Empty Cart page
            new HomePage().setVisible(true); // Open Home Page
        }
    }
}