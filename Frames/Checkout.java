package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Checkout extends JFrame implements ActionListener 
{
    
    JPanel panel, panelA;
    JLabel titleLbl, subtitleLbl;
    JLabel itemHeader, priceHeader, qtyHeader, subtotalHeader;
    
    // Dynamic labels for items
    ArrayList<JLabel> itemLabels = new ArrayList<>();
    ArrayList<JLabel> priceLabels = new ArrayList<>();
    ArrayList<JLabel> qtyLabels = new ArrayList<>();
    ArrayList<JLabel> subtotalLabels = new ArrayList<>();
    
    JLabel totalLbl, thankYouLbl;
    JButton confirmBtn, backBtn;
    
    
    int finalTotal;
   
    public Checkout()
    {
        super("Hungry Tyger Checkout");
        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
      
        

        HomePage hp = new HomePage();
        hp.setVisible(true);
    }

    public Checkout(ArrayList<String> names, ArrayList<Integer> prices, ArrayList<Integer> quantities, int total)
	{
        
        super("Hungry Tyger Checkout");
        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Colors
		Color orange = new Color(248, 110, 81);
		Color yellow = new Color(242, 200, 91);
		Color green = new Color(76, 175, 80);
		Color dark = new Color(31, 41, 55);
		Color lightGray = new Color(240, 240, 240);
        
        this.finalTotal = total;
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(lightGray);
        
        panelA = new JPanel();
        panelA.setLayout(null);
        panelA.setBackground(Color.WHITE);
        panelA.setBounds(20, 20, 750, 650);
        
        // Title
        titleLbl = new JLabel("CHECKOUT");
        titleLbl.setBounds(275, 20, 300, 40);
        titleLbl.setFont(new Font("Cambria", Font.BOLD, 32));
        titleLbl.setForeground(orange);
        panelA.add(titleLbl);
        
        subtitleLbl = new JLabel("Order Summary");
        subtitleLbl.setBounds(300, 60, 200, 30);
        subtitleLbl.setFont(new Font("Cambria", Font.PLAIN, 16));
        subtitleLbl.setForeground(dark);
        panelA.add(subtitleLbl);
        
        // Back Button
        backBtn = new JButton("← Back");
        backBtn.setBounds(50, 20, 100, 35);
        backBtn.setBackground(yellow);
        backBtn.setForeground(dark);
        backBtn.setFont(new Font("Cambria", Font.PLAIN, 14));
        backBtn.addActionListener(this);
        panelA.add(backBtn);
        
        // Table Headers
        int headerY = 110;
        itemHeader = new JLabel("Item");
        itemHeader.setBounds(50, headerY, 250, 30);
        itemHeader.setFont(new Font("Cambria", Font.BOLD, 16));
        itemHeader.setForeground(dark);
        panelA.add(itemHeader);
        
        priceHeader = new JLabel("Price");
        priceHeader.setBounds(320, headerY, 100, 30);
        priceHeader.setFont(new Font("Cambria", Font.BOLD, 16));
        priceHeader.setForeground(dark);
        panelA.add(priceHeader);
        
        qtyHeader = new JLabel("Qty");
        qtyHeader.setBounds(440, headerY, 80, 30);
        qtyHeader.setFont(new Font("Cambria", Font.BOLD, 16));
        qtyHeader.setForeground(dark);
        panelA.add(qtyHeader);
        
        subtotalHeader = new JLabel("Subtotal");
        subtotalHeader.setBounds(550, headerY, 120, 30);
        subtotalHeader.setFont(new Font("Cambria", Font.BOLD, 16));
        subtotalHeader.setForeground(dark);
        panelA.add(subtotalHeader);
        
        // Separator line
        JSeparator separator1 = new JSeparator();
        separator1.setBounds(50, 145, 650, 2);
        panelA.add(separator1);
        
        // Display Items
        int startY = 160;
        int rowHeight = 50;
        
        for(int i = 0; i < names.size(); i++) {
            int y = startY + (i * rowHeight);
            
            // Item Name
            JLabel itemLbl = new JLabel(names.get(i));
            itemLbl.setBounds(50, y, 250, 30);
            itemLbl.setFont(new Font("Cambria", Font.PLAIN, 16));
            panelA.add(itemLbl);
            itemLabels.add(itemLbl);
            
            // Price
            JLabel priceLbl = new JLabel("Tk. " + prices.get(i));
            priceLbl.setBounds(320, y, 100, 30);
            priceLbl.setFont(new Font("Cambria", Font.PLAIN, 16));
            panelA.add(priceLbl);
            priceLabels.add(priceLbl);
            
            // Quantity
            JLabel qtyLbl = new JLabel("x" + quantities.get(i));
            qtyLbl.setBounds(440, y, 80, 30);
            qtyLbl.setFont(new Font("Cambria", Font.PLAIN, 16));
            panelA.add(qtyLbl);
            qtyLabels.add(qtyLbl);
            
            // Subtotal
            int subtotal = prices.get(i) * quantities.get(i);
            JLabel subtotalLbl = new JLabel("Tk. " + subtotal);
            subtotalLbl.setBounds(550, y, 120, 30);
            subtotalLbl.setFont(new Font("Cambria", Font.PLAIN, 16));
            panelA.add(subtotalLbl);
            subtotalLabels.add(subtotalLbl);
        }
        
        // Separator before total
        int totalY = startY + (names.size() * rowHeight) + 10;
        JSeparator separator2 = new JSeparator();
        separator2.setBounds(50, totalY, 650, 2);
        panelA.add(separator2);
        
        // Grand Total
        totalLbl = new JLabel("TOTAL: Tk. " + finalTotal);
        totalLbl.setBounds(450, totalY + 20, 250, 40);
        totalLbl.setFont(new Font("Cambria", Font.BOLD, 24));
        totalLbl.setForeground(orange);
        panelA.add(totalLbl);
        
        // Thank You Message
        thankYouLbl = new JLabel("Thank you for your order!");
        thankYouLbl.setBounds(285, totalY + 70, 350, 30);
        thankYouLbl.setFont(new Font("Cambria", Font.PLAIN, 16));
        thankYouLbl.setForeground(dark);
        panelA.add(thankYouLbl);
        
        // Confirm Button
        confirmBtn = new JButton("CONFIRM ORDER");
        confirmBtn.setBounds(275, totalY + 120, 200, 45);
        confirmBtn.setBackground(green);
        confirmBtn.setForeground(Color.WHITE);
        confirmBtn.setFont(new Font("Cambria", Font.BOLD, 18));
        confirmBtn.addActionListener(this);
       
        panelA.add(confirmBtn);

    
        panel.add(panelA);
        this.add(panel);
    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backBtn) {

           
            this.dispose();
            
            new HomePage().setVisible(true);
        } 
        else if (e.getSource() == confirmBtn) {
            Billing b1 = new Billing();
            b1.setVisible(true);
                
                this.dispose();
                
            }
        }
    }

