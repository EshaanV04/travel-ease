package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateProfile extends JFrame implements ActionListener  {
    
    JLabel labelusername, labelname;
    JComboBox comboId; 
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone;
    JRadioButton rmale, rfemale;
    JButton update, back;
    Choice cid;
    
    UpdateProfile(String username){
        setBounds(450, 200, 850, 550);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("UPDATE PROFILE");
        text.setBounds(300, 5, 300, 25);
        text.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(text);
        
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
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);
        
        cid = new Choice();
        cid.add("Aadhaar Card");
        cid.add("Passport");
        cid.add("PAN Card");
        cid.add("Ration Card");
        cid.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        cid.setBounds(220, 90, 150, 25);
        cid.setBackground(Color.WHITE);
        add(cid);
 
        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);
        
        labelname = new JLabel();
        labelname.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 100, 25);
        rfemale.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblemail.setBounds(30, 330, 150, 25);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        tfemail.setBounds(220, 330, 150, 25);
        add(tfemail);
        
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblphone.setBounds(30, 370, 150, 25);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        tfphone.setBounds(220, 370, 150, 25);
        add(tfphone);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70, 430, 100, 25);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 430, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,100,300,300);
        add(image);
        
        try {
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from account where username = '"+username+"'");
            while(rs1.next()){
                labelusername.setText(rs1.getString("username"));
                labelname.setText(rs1.getString("name")); 
            }
            
            ResultSet rs2 = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs2.next()){
                labelusername.setText(rs2.getString("username"));
                labelname.setText(rs2.getString("name"));
                tfnumber.setText(rs2.getString("number"));
                tfcountry.setText(rs2.getString("country"));
                tfaddress.setText(rs2.getString("address"));
                tfemail.setText(rs2.getString("email"));
                tfphone.setText(rs2.getString("phone"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String username = labelusername.getText();
            String id = cid.getSelectedItem();
            String idNo = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if (rmale.isSelected()){
                gender = "male";
            } else {
                gender = "female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            
            try {
                Conn c = new Conn();
                String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+idNo+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', email = '"+email+"', phone = '"+phone+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Profile Updated Successfully");
                setVisible(false);
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == back) {
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new UpdateProfile("");
    }
}
