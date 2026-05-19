package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Entries.*;


public class HomePage extends JFrame 
{
    
    public HomePage() {
        // Basic frame setup
        setTitle("Hungry Tyger");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // ========== TOP PANEL ==========
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(1000, 60));
        topPanel.setBackground(Color.WHITE);
        
        // Title - HUNGRY TYGER
        JLabel titleLabel = new JLabel("HUNGRY TYGER");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(200, 50, 50));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        topPanel.add(titleLabel, BorderLayout.WEST);
        
    
        
        add(topPanel, BorderLayout.NORTH);
        
        // ========== SIDEBAR PANEL ==========
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setPreferredSize(new Dimension(100, 640));
        sidebarPanel.setBackground(new Color(255, 248, 240));
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        // Profile Button
        JButton profileBtn = new JButton("Profile");
        profileBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        profileBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        profileBtn.setMaximumSize(new Dimension(80, 70));

    profileBtn.addActionListener(new ActionListener() 
    {
    public void actionPerformed(ActionEvent e) 
    {
        Profile p = new Profile();  // Open Profile page
        p.setVisible(true);
        dispose();
    }
    });

        sidebarPanel.add(profileBtn);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // Cart Button
        JButton cartBtn = new JButton("Cart");
        cartBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        cartBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartBtn.setMaximumSize(new Dimension(80, 70));
        sidebarPanel.add(cartBtn);
        sidebarPanel.add(Box.createVerticalGlue());
        cartBtn.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
        {
            
            EmptyCart e1 =new EmptyCart();
            e1.setVisible(true);
            HomePage.this.dispose();
            

        }
        
        });
        
        // Logout Button
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFont(new Font("Arial", Font.PLAIN, 14));
        logoutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutBtn.setMaximumSize(new Dimension(80, 30));
        sidebarPanel.add(logoutBtn);

        logoutBtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
                dispose(); 
            }
        });
        
        add(sidebarPanel, BorderLayout.WEST);
        
        // ========== MAIN CONTENT PANEL ==========
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(253, 245, 230));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // --- Popular Categories Section ---
        JLabel categoriesTitle = new JLabel("Popular categories");
        categoriesTitle.setFont(new Font("Arial", Font.BOLD, 20));
        categoriesTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(categoriesTitle);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // Categories Grid Panel
        JPanel categoriesGrid = new JPanel();
        categoriesGrid.setBackground(new Color(253, 245, 230));
        
        // Burger -
        JPanel burgerPanel = createFoodItem("Burger", "/Resources/Burger.jpg");
        categoriesGrid.add(burgerPanel);
        
        // Pizza
        JPanel pizzaPanel = createFoodItem("Pizza", "/Resources/Pizza.jpg");
        categoriesGrid.add(pizzaPanel);
        
        // Drinks -
        JPanel drinksPanel = createFoodItem("Drinks", "/Resources/Drinks.jpg");
        categoriesGrid.add(drinksPanel);
        
        // Kacchi
        JPanel kacchiPanel = createFoodItem("Kacchi", "/Resources/kacchi.jpg");
        categoriesGrid.add(kacchiPanel);
        
        mainPanel.add(categoriesGrid);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        
        // --- Popular Restaurants Section ---
        JLabel restaurantsTitle = new JLabel("Popular restaurants");
        restaurantsTitle.setFont(new Font("Arial", Font.BOLD, 20));
        restaurantsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(restaurantsTitle);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // Restaurants Grid Panel
        JPanel restaurantsGrid = new JPanel();
        restaurantsGrid.setBackground(new Color(253, 245, 230));
        
        // Pizzahut
        JPanel pizzahutPanel = createFoodItem("Pizza Hut", "/Resources/pizza_hut.jpg");
        restaurantsGrid.add(pizzahutPanel);
        
        // Kacchi Bhai 
        JPanel kacchiBhaiPanel = createFoodItem("Kacchi Vai", "/Resources/kacci_vai.jpg");
        restaurantsGrid.add(kacchiBhaiPanel);
        
        // KFC 
        JPanel mfcPanel = createFoodItem("KFC", "/Resources/kfc.png");
        restaurantsGrid.add(mfcPanel);
        
        // AIUB CANTEEN 
        JPanel aiubPanel = createFoodItem("AIUB Canteen", "/Resources/AIUB_CANTEEN.jpg");
        restaurantsGrid.add(aiubPanel);
        
        mainPanel.add(restaurantsGrid);
        
        // Add scroll pane for main panel
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
    }
    
    // Method expects 2 parameters: name and imagePath
    private JPanel createFoodItem(String name, String imagePath) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255,165,0));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        try {
            ImageIcon icon = null;
            java.net.URL imgURL = getClass().getResource(imagePath);
            if (imgURL != null) {
                icon = new ImageIcon(imgURL);
            } else {
                icon = new ImageIcon(imagePath);
            }
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            imageLabel.setText("Image\nPlaceholder");
            imageLabel.setVerticalTextPosition(SwingConstants.CENTER);
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }
        
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(imageLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(nameLabel);
        
panel.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        // ✅ Check which item was clicked
        if(name.equals("Burger")) {
            R1 r = new R1();
            r.setVisible(true);
        }
        else if(name.equals("Pizza")) {
            R2 r = new R2();  // Create R2.java for Pizza
            r.setVisible(true);
        }
        else if(name.equals("Drinks")) {
            R4 r = new R4();  // Create R3.java for Drinks
            r.setVisible(true);
        }
        else if(name.equals("Kacchi")) {
            R3 r = new R3();  // Create R4.java for Kacchi
            r.setVisible(true);
        }
        else if(name.equals("Pizza Hut")) {
            R2 r = new R2();  // Create R5.java for Pizza Hut
            r.setVisible(true);
        }
        else if(name.equals("Kacchi Vai")) {
            R3 r = new R3();  // Create R6.java for Kacchi Bhai
            r.setVisible(true);
        }
        else if(name.equals("KFC")) {
            R1 r = new R1();  // Create R7.java for KFC
            r.setVisible(true);
        }
        else if(name.equals("AIUB Canteen")) {
            R4 r = new R4();  // Create R8.java for AIUB Canteen
            r.setVisible(true);
        }
    }
    
    public void mouseEntered(MouseEvent e) {
        panel.setBackground(new Color(255, 200, 0));
    }
    
    public void mouseExited(MouseEvent e) {
        panel.setBackground(new Color(255, 165, 0));
    }
});
        
        return panel;
    }
}