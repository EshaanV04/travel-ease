package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener {
    
    JLabel labelusername, labelpackage, labelmembers, labelID, labelIDNo, labelphone, labelprice;
    JButton back;
    
    ViewPackage(String username){
        setBounds(450, 200, 900, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(60, 10, 300, 30);
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
        
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblpackage.setBounds(30, 90, 150, 25);
        add(lblpackage);
        
        labelpackage = new JLabel();
        labelpackage.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelpackage.setBounds(220, 90, 150, 25);
        add(labelpackage);
        
        JLabel lblmembers = new JLabel("Total Members");
        lblmembers.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblmembers.setBounds(30, 130, 150, 25);
        add(lblmembers);
        
        labelmembers = new JLabel();
        labelmembers.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelmembers.setBounds(220, 130, 150, 25);
        add(labelmembers);
         
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblid.setBounds(30, 170, 150, 25);
        add(lblid);
        
        labelID = new JLabel();
        labelID.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelID.setBounds(220, 170, 150, 25);
        add(labelID);
        
        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblnumber.setBounds(30, 210, 150, 25);
        add(lblnumber);
        
        labelIDNo = new JLabel();
        labelIDNo.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelIDNo.setBounds(220, 210, 150, 25);
        add(labelIDNo);
        
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblphone.setBounds(30, 250, 150, 25);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelphone.setBounds(220, 250, 150, 25);
        add(labelphone);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblprice.setBounds(30, 290, 150, 25);
        add(lblprice);
        
        labelprice = new JLabel();
        labelprice.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelprice.setBounds(220, 290, 150, 25);
        add(labelprice);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 360, 100, 25);
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
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("package"));
                labelmembers.setText(rs.getString("persons"));
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
        new ViewPackage("");
    }
}
