package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewHotel extends JFrame implements ActionListener {
    
    JLabel labelusername, labelhotel, labelpersons, labeldays, labelac, labelfood, labelID, labelIDNo, labelphone, labelprice;
    JButton back;
    
    ViewHotel(String username){
        setBounds(40, 200, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW HOTEL DETAILS");
        text.setBounds(60, 10, 400, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        JLabel lblhotel = new JLabel("Hotel");
        lblhotel.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblhotel.setBounds(30, 90, 150, 25);
        add(lblhotel);
        
        labelhotel = new JLabel();
        labelhotel.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelhotel.setBounds(220, 90, 150, 25);
        add(labelhotel);
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblpersons.setBounds(30, 130, 150, 25);
        add(lblpersons);
        
        labelpersons = new JLabel();
        labelpersons.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelpersons.setBounds(220, 130, 150, 25);
        add(labelpersons);
        
        JLabel lbldays = new JLabel("Total Days");
        lbldays.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lbldays.setBounds(30, 170, 150, 25);
        add(lbldays);
        
        labeldays = new JLabel();
        labeldays.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labeldays.setBounds(220, 170, 150, 25);
        add(labeldays);
        
        JLabel lblac = new JLabel("AC / Non AC");
        lblac.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblac.setBounds(30, 210, 150, 25);
        add(lblac);
        
        labelac = new JLabel();
        labelac.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelac.setBounds(220, 210, 150, 25);
        add(labelac);
        
        JLabel lblfood = new JLabel("Total Persons");
        lblfood.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblfood.setBounds(30, 250, 150, 25);
        add(lblfood);
        
        labelfood = new JLabel();
        labelfood.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelfood.setBounds(220, 250, 150, 25);
        add(labelfood);
         
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblid.setBounds(30, 290, 150, 25);
        add(lblid);
        
        labelID = new JLabel();
        labelID.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelID.setBounds(220, 290, 150, 25);
        add(labelID);
        
        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblnumber.setBounds(30, 330, 150, 25);
        add(lblnumber);
        
        labelIDNo = new JLabel();
        labelIDNo.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelIDNo.setBounds(220, 330, 150, 25);
        add(labelIDNo);
        
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblphone.setBounds(30, 370, 150, 25);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelphone.setBounds(220, 370, 150, 25);
        add(labelphone);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblprice.setBounds(30, 410, 150, 25);
        add(lblprice);
        
        labelprice = new JLabel();
        labelprice.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelprice.setBounds(220, 410, 150, 25);
        add(labelprice);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 460, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);
        
        try{
            Conn c = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelhotel.setText(rs.getString("hotel"));
                labelpersons.setText(rs.getString("persons"));
                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
                labelID.setText(rs.getString("id"));
                labelIDNo.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new ViewHotel("");
    }
}
