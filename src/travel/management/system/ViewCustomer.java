package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {
    
    JLabel labelusername, labelID, labelIDNo, labelname, labelgender, labelcountry, labeladdress, labelemail, labelphone;
    JButton back;
    
    ViewCustomer(String username){
        setBounds(450, 180, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblid.setBounds(30, 100, 150, 25);
        add(lblid);
        
        labelID = new JLabel();
        labelID.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelID.setBounds(220, 100, 150, 25);
        add(labelID);
        
        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblnumber.setBounds(30, 150, 150, 25);
        add(lblnumber);
        
        labelIDNo = new JLabel();
        labelIDNo.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelIDNo.setBounds(220, 150, 150, 25);
        add(labelIDNo);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblname.setBounds(30, 200, 150, 25);
        add(lblname);
        
        labelname = new JLabel();
        labelname.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelname.setBounds(220, 200, 150, 25);
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblgender.setBounds(30, 250, 150, 25);
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelgender.setBounds(220, 250, 150, 25);
        add(labelgender);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblcountry.setBounds(450, 50, 150, 25);
        add(lblcountry);
        
        labelcountry = new JLabel();
        labelcountry.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelcountry.setBounds(650, 50, 150, 25);
        add(labelcountry);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lbladdress.setBounds(450, 100, 150, 25);
        add(lbladdress);
        
        labeladdress = new JLabel();
        labeladdress.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labeladdress.setBounds(650, 100, 150, 25);
        add(labeladdress);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblemail.setBounds(450, 150, 150, 25);
        add(lblemail);
        
        labelemail = new JLabel();
        labelemail.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelemail.setBounds(650, 150, 150, 25);
        add(labelemail);
        
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblphone.setBounds(450, 200, 150, 25);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelphone.setBounds(650, 200, 150, 25);
        add(labelphone);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 300, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/profile1.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,230,800,500);
        add(image);
        
        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelID.setText(rs.getString("id"));
                labelIDNo.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelemail.setText(rs.getString("email"));
                labelphone.setText(rs.getString("phone"));
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
        new ViewCustomer("");
    }
}
