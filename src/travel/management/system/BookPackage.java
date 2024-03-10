package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {
    
    JLabel labelusername, labelId, labelIDNo, labelphone, labelprice;
    Choice cpackage;
    JTextField tfmembers;
    JButton checkPrice, bookPackage, back;
    String username;
    
    BookPackage(String username){
        this.username = username;
        
        setBounds(350, 200, 1100, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("BOOK A PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblusername.setBounds(40, 70, 100, 20);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelusername.setBounds(250, 70, 200, 20);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);
        
        JLabel lblmembers = new JLabel("Total Members");
        lblmembers.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblmembers.setBounds(40, 150, 150, 20);
        add(lblmembers);
        
        tfmembers = new JTextField();
        tfmembers.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        tfmembers.setBounds(250, 150, 200, 25);
        add(tfmembers);
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblid.setBounds(40, 190, 150, 20);
        add(lblid);
        
        labelId = new JLabel();
        labelId.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelId.setBounds(250, 190, 200, 20);
        add(labelId);
        
        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblnumber.setBounds(40, 230, 150, 20);
        add(lblnumber);
        
        labelIDNo = new JLabel();
        labelIDNo.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelIDNo.setBounds(250, 230, 200, 20);
        add(labelIDNo);
        
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblphone.setBounds(40, 270, 150, 20);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelphone.setBounds(250, 270, 200, 20);
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lbltotal.setBounds(40, 310, 150, 20);
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelprice.setBounds(250, 310, 200, 20);
        add(labelprice);
        
        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelIDNo.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBounds(60, 380, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);
        
        bookPackage = new JButton("Book Package");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBounds(200, 380, 120, 25);
        bookPackage.addActionListener(this);
        add(bookPackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkPrice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost += 12000;
            } else if(pack.equals("Silver Package")){
                cost += 25000;
            } else if(pack.equals("Bronze Package")){
                cost += 32000;
            }
            
            int persons  = Integer.parseInt(tfmembers.getText());
            cost *= persons;
            labelprice.setText("Rs. " + cost);
        } else if(ae.getSource() == bookPackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfmembers.getText()+"', '"+labelId.getText()+"', '"+labelIDNo.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Package Booked Successfully.");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new BookPackage("");
    }
}
