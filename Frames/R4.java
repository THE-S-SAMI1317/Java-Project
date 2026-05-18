package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class R4	extends JFrame implements ActionListener 
{
    
    
    JPanel panel, panelA;
    JLabel titleLbl, itemLbl1, priceLbl1, qtyLbl1, totalLbl;
    JLabel itemLbl2, priceLbl2, qtyLbl2;
    JTextField qtyFld1, qtyFld2;
    JButton buyNowBtn, backBtn;
    Color primaryOrange, secondryYellow, backgrdWhite1, backgrdWhite2, txtBlu;
    
    
    int priceMojo = 20;
    int priceClemon = 25;
    
    // Store order details
    ArrayList<String> itemNames = new ArrayList<>();
    ArrayList<Integer> itemPrices = new ArrayList<>();
    ArrayList<Integer> itemQuantities = new ArrayList<>();
    int grandTotal = 0;

    public R4()
	{
        super("Hungry Tyger");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		primaryOrange = new Color(248, 110, 81);
		secondryYellow = new Color(242, 200, 91);
		backgrdWhite1 = new Color(253, 245, 230);
		backgrdWhite2 = new Color(255, 251, 240);
		txtBlu = new Color(31, 41, 55);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(backgrdWhite1);
        
        panelA = new JPanel();
        panelA.setLayout(null);
        panelA.setBackground(new Color(250, 250, 250));
        panelA.setBounds(20, 20, 950, 630);
        
        // Title
        titleLbl = new JLabel("AIUB Canteen");
        titleLbl.setBounds(350, 30, 300, 50);
        titleLbl.setFont(new Font("Cambria", Font.BOLD, 30));
        titleLbl.setForeground(primaryOrange);
        panelA.add(titleLbl);
        
        // Back Button
        backBtn = new JButton("Back");
        backBtn.setBounds(50, 30, 80, 30);
        backBtn.setBackground(secondryYellow);
        backBtn.setForeground(txtBlu);
        backBtn.addActionListener(this);
        panelA.add(backBtn);
        
        // --- Item 1: Mojo ---
        itemLbl1 = new JLabel("Mojo");
        itemLbl1.setBounds(100, 120, 200, 30);
        itemLbl1.setFont(new Font("Cambria", Font.PLAIN, 18));
        panelA.add(itemLbl1);
        
        priceLbl1 = new JLabel("Tk. " + priceMojo);
        priceLbl1.setBounds(400, 120, 100, 30);
        priceLbl1.setFont(new Font("Cambria", Font.PLAIN, 18));
        panelA.add(priceLbl1);
        
        JLabel qtyLabel1 = new JLabel("Quantity (Max 30):");
        qtyLabel1.setBounds(550, 120, 150, 30);
        panelA.add(qtyLabel1);
        
        qtyFld1 = new JTextField("1");
        qtyFld1.setBounds(720, 120, 50, 30);
        panelA.add(qtyFld1);
        
        // --- Item 2: Clemon ---
        itemLbl2 = new JLabel("Clemon");
        itemLbl2.setBounds(100, 200, 200, 30);
        itemLbl2.setFont(new Font("Cambria", Font.PLAIN, 18));
        panelA.add(itemLbl2);
        
        priceLbl2 = new JLabel("Tk. " + priceClemon);
        priceLbl2.setBounds(400, 200, 100, 30);
        priceLbl2.setFont(new Font("Cambria", Font.PLAIN, 18));
        panelA.add(priceLbl2);
        
        JLabel qtyLabel2 = new JLabel("Quantity (Max 30):");
        qtyLabel2.setBounds(550, 200, 150, 30);
        panelA.add(qtyLabel2);
        
        qtyFld2 = new JTextField("1");
        qtyFld2.setBounds(720, 200, 50, 30);
        panelA.add(qtyFld2);
        
        // --- Buy Now Button ---
        buyNowBtn = new JButton("BUY NOW");
        buyNowBtn.setBounds(350, 300, 250, 50);
        buyNowBtn.setBackground(primaryOrange);
        buyNowBtn.setForeground(Color.WHITE);
        buyNowBtn.setFont(new Font("Cambria", Font.BOLD, 20));
        buyNowBtn.addActionListener(this);
        panelA.add(buyNowBtn);
        
        // Total Label
        totalLbl = new JLabel("Total: Tk. 0");
        totalLbl.setBounds(350, 380, 300, 40);
        totalLbl.setFont(new Font("Cambria", Font.BOLD, 20));
        panelA.add(totalLbl);
        
        panel.add(panelA);
        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae)
	{
        if (ae.getSource() == backBtn) {
            this.dispose();
            // new HomePage().setVisible(true); NEED TO  ADD
        } 
        else if (ae.getSource() == buyNowBtn) {
            placeOrder();
        }
    }
    
    private void placeOrder() {
        try {
            int qty1 = Integer.parseInt(qtyFld1.getText());
            int qty2 = Integer.parseInt(qtyFld2.getText());
            
            // Validate Max 30
            if(qty1 > 30 || qty2 > 30) {
                JOptionPane.showMessageDialog(this, "Maximum quantity is 30 per item!");
                return;
            }
            if(qty1 < 0 || qty2 < 0) {
                JOptionPane.showMessageDialog(this, "Quantity cannot be negative!");
                return;
            }
            
            // Clear previous order
            itemNames.clear();
            itemPrices.clear();
            itemQuantities.clear();
            grandTotal = 0;
            
            // Add Mojo if quantity > 0
            if(qty1 > 0) 
			{
                itemNames.add("Mojo");
                itemPrices.add(priceMojo);
                itemQuantities.add(qty1);
                grandTotal += qty1 * priceMojo;
            }
            
            // Add Clemon if quantity > 0
            if(qty2 > 0) 
			{
                itemNames.add("Clemon");
                itemPrices.add(priceClemon);
                itemQuantities.add(qty2);
                grandTotal += qty2 * priceClemon;
            }
            
            // Check if any items selected
            if(itemNames.isEmpty()) 
			{
                JOptionPane.showMessageDialog(this, "Please select at least one item!");
                return;
            }
            
            //Open Checkout with order details
            Checkout checkoutFrame = new Checkout(itemNames, itemPrices, itemQuantities, grandTotal);
            checkoutFrame.setVisible(true);
            this.dispose(); // Close restaurant frame
            
        } 
		
		catch (NumberFormatException ex)
		{
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for quantity.");
        }
    }
}