package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {
    
    JLabel labelusername, labelId, labelIDNo, labelphone, labelprice;
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    JButton checkPrice, bookHotel, back;
    String username;
    
    BookHotel(String username){
        this.username = username;
        
        setBounds(350, 200, 1100, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("BOOK A HOTEL");
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
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblpersons.setBounds(40, 150, 150, 20);
        add(lblpersons);
        
        tfpersons = new JTextField();
        tfpersons.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lbldays.setBounds(40, 190, 150, 20);
        add(lbldays);
        
        tfdays = new JTextField();
        tfdays.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);
        
        JLabel lblac = new JLabel("AC / Non AC");
        lblac.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblac.setBounds(40, 230, 150, 20);
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblfood.setBounds(40, 270, 150, 20);
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblid.setBounds(40, 310, 150, 20);
        add(lblid);
        
        labelId = new JLabel();
        labelId.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelId.setBounds(250, 310, 200, 20);
        add(labelId);
        
        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblnumber.setBounds(40, 350, 150, 20);
        add(lblnumber);
        
        labelIDNo = new JLabel();
        labelIDNo.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelIDNo.setBounds(250, 350, 200, 20);
        add(labelIDNo);
        
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblphone.setBounds(40, 390, 150, 20);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelphone.setBounds(250, 390, 200, 20);
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lbltotal.setBounds(40, 430, 150, 20);
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelprice.setBounds(250, 430, 200, 20);
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
        checkPrice.setBounds(60, 490, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);
        
        bookHotel = new JButton("Book Hotel");
        bookHotel.setBackground(Color.BLACK);
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setBounds(200, 490, 120, 25);
        bookHotel.addActionListener(this);
        add(bookHotel);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,600,400);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkPrice){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costpp"));
                    int ac = Integer.parseInt(rs.getString("ac"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    
                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    
                    if(persons * days > 0){
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total += total * persons * days;
                        labelprice.setText("Rs. " + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } else if(ae.getSource() == bookHotel){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelId.getText()+"', '"+labelIDNo.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully.");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new BookHotel("");
    }
}
