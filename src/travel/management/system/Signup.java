package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {
    
    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfanswer;
    Choice security;
    
    Signup(){
        setBounds(350, 200, 900, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblname.setBounds(60, 20, 125, 25);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 20, 220, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblusername.setBounds(60, 60, 125, 25);
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(220, 60, 220, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblpassword.setBounds(60, 100, 125, 25);
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(220, 100, 220, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblsecurity.setBounds(60, 140, 150, 25);
        p1.add(lblsecurity);
        
        security = new Choice();
        security.add("What was the first exam you failed?");
        security.add("What city were you born in?");
        security.add("What is your favourite movie/series?");
        security.add("Who is your favourite Marvel superhero?");
        security.add("What is you lucky number?");
        security.setBounds(220, 140, 220, 25);
        p1.add(security);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        lblanswer.setBounds(60, 180, 125, 25);
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(220, 180, 220, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        create = new JButton("Create");
        create.setBounds(80, 250, 100, 30);
        create.setBackground(Color.white);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBounds(250, 250, 100, 30);
        back.setBackground(Color.white);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(540,25,300,300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String name = tfname.getText();
            String username = tfusername.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
            String s = " ";
            
            String query = "insert into account values('"+name+"','"+username+"','"+password+"','"+question+"','"+answer+"')";
            String query1 = "insert into customer values('"+username+"','"+s+"','"+s+"','"+name+"','"+s+"','"+s+"','"+s+"','"+s+"','"+s+"')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                
                setVisible(false);
                new Login();
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[]){
        new Signup();
    }
}
