package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
    
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    
    ForgetPassword() {
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500,280);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(180, 20, 190, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBounds(380, 20, 100, 25);
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 60, 100, 25);
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(180, 60, 190, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblquestion = new JLabel("Security Question");
        lblquestion.setBounds(40, 100, 150, 25);
        lblquestion.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        p1.add(lblquestion);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(180, 100, 190, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(40, 140, 150, 25);
        lblanswer.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(180, 140, 190, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBounds(380, 140, 100, 25);
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 180, 150, 25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(180, 180, 190, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.setBounds(150, 230, 100, 25);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security")); 
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == retrieve){
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));

                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[]){
        new ForgetPassword();
    }
}
