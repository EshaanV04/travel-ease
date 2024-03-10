package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    JButton updateProfile, viewProfile, deleteProfile, exploreDestinations, explorePackages, bookPackage, viewPackage, exploreHotels, bookHotel, viewHotel, payment, calender, notepad, about, logout;
    String username;
    
    Dashboard(String username) {
        this.username = username;
        //setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 2000, 85);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(10,10,70,70);
        p1.add(icon);
        
        JLabel heading = new JLabel("Travelia");
        heading.setBounds(95, 20, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 35));
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 85, 300, 1000);
        add(p2);
        
        updateProfile = new JButton("Update Profile");
        updateProfile.setBounds(0, 0, 300, 55);
        updateProfile.setBackground(new Color(0, 0, 102));
        updateProfile.setForeground(Color.WHITE);
        updateProfile.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        updateProfile.setMargin(new Insets(0, 0, 0, 90));
        updateProfile.addActionListener(this);
        p2.add(updateProfile);
        
        viewProfile = new JButton("View Profile");
        viewProfile.setBounds(0, 60, 300, 55);
        viewProfile.setBackground(new Color(0, 0, 102));
        viewProfile.setForeground(Color.WHITE);
        viewProfile.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        viewProfile.setMargin(new Insets(0, 0, 0, 115));
        viewProfile.addActionListener(this);
        p2.add(viewProfile);
        
        deleteProfile = new JButton("Delete Profile");
        deleteProfile.setBounds(0, 120, 300, 55);
        deleteProfile.setBackground(new Color(0, 0, 102));
        deleteProfile.setForeground(Color.WHITE);
        deleteProfile.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        deleteProfile.setMargin(new Insets(0, 0, 0, 95));
        deleteProfile.addActionListener(this);
        p2.add(deleteProfile);
        
        exploreDestinations = new JButton("Explore Destinations");
        exploreDestinations.setBounds(0, 180, 300, 55);
        exploreDestinations.setBackground(new Color(0, 0, 102));
        exploreDestinations.setForeground(Color.WHITE);
        exploreDestinations.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        exploreDestinations.setMargin(new Insets(0, 0, 0, 15));
        exploreDestinations.addActionListener(this);
        p2.add(exploreDestinations);
        
        explorePackages = new JButton("Explore Packages");
        explorePackages.setBounds(0, 240, 300, 55);
        explorePackages.setBackground(new Color(0, 0, 102));
        explorePackages.setForeground(Color.WHITE);
        explorePackages.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        explorePackages.setMargin(new Insets(0, 0, 0, 45));
        explorePackages.addActionListener(this);
        p2.add(explorePackages);
        
        bookPackage = new JButton("Book A Package");
        bookPackage.setBounds(0, 300, 300, 55);
        bookPackage.setBackground(new Color(0, 0, 102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        bookPackage.setMargin(new Insets(0, 0, 0, 60));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);
        
        viewPackage = new JButton("View Booked Package");
        viewPackage.setBounds(0, 360, 300, 55);
        viewPackage.setBackground(new Color(0, 0, 102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        viewPackage.setMargin(new Insets(0, 5, 0, 0));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);
        
        exploreHotels = new JButton("Explore Hotels");
        exploreHotels.setBounds(0, 420, 300, 55);
        exploreHotels.setBackground(new Color(0, 0, 102));
        exploreHotels.setForeground(Color.WHITE);
        exploreHotels.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        exploreHotels.setMargin(new Insets(0, 0, 0, 85));
        exploreHotels.addActionListener(this);
        p2.add(exploreHotels);
        
        bookHotel = new JButton("Book A Hotel");
        bookHotel.setBounds(0, 480, 300, 55);
        bookHotel.setBackground(new Color(0, 0, 102));
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        bookHotel.setMargin(new Insets(0, 0, 0, 95));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);
        
        viewHotel = new JButton("View Booked Hotel");
        viewHotel.setBounds(0, 540, 300, 55);
        viewHotel.setBackground(new Color(0, 0, 102));
        viewHotel.setForeground(Color.WHITE);
        viewHotel.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        viewHotel.setMargin(new Insets(0, 0, 0, 30));
        viewHotel.addActionListener(this);
        p2.add(viewHotel);
        
        payment = new JButton("Payment Gateway");
        payment.setBounds(0, 600, 300, 55);
        payment.setBackground(new Color(0, 0, 102));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        payment.setMargin(new Insets(0, 0, 0, 35));
        payment.addActionListener(this);
        p2.add(payment);
        
        calender = new JButton("Calender");
        calender.setBounds(0, 660, 300, 55);
        calender.setBackground(new Color(0, 0, 102));
        calender.setForeground(Color.WHITE);
        calender.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        calender.setMargin(new Insets(0, 0, 0, 140));
        calender.addActionListener(this);
        p2.add(calender);
        
        notepad = new JButton("Notepad");
        notepad.setBounds(0, 720, 300, 55);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        notepad.setMargin(new Insets(0, 0, 0, 145));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about = new JButton("About");
        about.setBounds(0, 780, 300, 55);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        about.setMargin(new Insets(0, 0, 0, 170));
        about.addActionListener(this);
        p2.add(about);
        
        logout = new JButton("Logout");
        logout.setBounds(0, 900, 300, 55);
        logout.setBackground(new Color(0, 0, 102));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        logout.setMargin(new Insets(0, 0, 0, 160));
        logout.addActionListener(this);
        p2.add(logout);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(2000, 1100, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,2000,1100);
        add(image);
        
        JLabel text = new JLabel("Explore The World");
        text.setBounds(870, 110, 800, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        image.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == updateProfile){
            new UpdateProfile(username);
        } else if(ae.getSource() == viewProfile){
            new ViewCustomer(username);
        } else if(ae.getSource() == deleteProfile){
            new DeleteProfile(username);
        } else if(ae.getSource() == explorePackages) {
            new ExplorePackages();
        } else if(ae.getSource() == bookPackage) {
            new BookPackage(username);
        } else if(ae.getSource() == viewPackage) {
            new ViewPackage(username);
        } else if(ae.getSource() == exploreDestinations) {
            new ExploreDestinations();
        } else if(ae.getSource() == exploreHotels) {
            new ExploreHotels();
        } else if(ae.getSource() == bookHotel) {
            new BookHotel(username);
        } else if(ae.getSource() == viewHotel) {
            new ViewHotel(username);
        } else if(ae.getSource() == payment) {
            new Payment();
        } else if(ae.getSource() == calender) {
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "http://www.google.com/calendar/render");
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == about){
            new About();
        } else if(ae.getSource() == logout){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[]){
        new Dashboard("");
    }
}
