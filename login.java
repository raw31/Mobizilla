import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class login implements ActionListener {
ImageIcon i1;
    Frame f;
    JLabel l1, l2,t3;
    TextField t;
    Button b,b1;
JPasswordField t2;
Connection con;
Statement st;
ResultSet rs;

    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mobileshop","root","");
            st= con.createStatement();
            JOptionPane.showMessageDialog(null,"CONNECTED","COMPANY",1);
        }
        catch(Exception h){
            JOptionPane.showMessageDialog(null,h,"COMPANY",0);
        }
    }
    login(){
        f=new Frame("Mobile Shop");
        f.setLayout(null);
        f.setBackground(Color.gray);
       l1= new JLabel("Username :");
       l1.setBounds(400,200,150,50);
       Font f1=new Font("New Times Roman",Font.BOLD,20);
       l1.setFont(f1);
        f.add(l1);
        l2= new JLabel("Password :");
        l2.setBounds(400,300,150,60);
        Font f2=new Font("New Times Roman",Font.BOLD,20);
        l2.setFont(f2);
        f.add(l2);
        t=new TextField();
        t.setBounds(560,220,150,20);
        f.add(t);
        t2=new JPasswordField();
        t2.setBounds(560,320,150,20);
        f.add(t2);
        b=new Button("SUBMIT");
        Font f3=new Font("New Times Roman",Font.BOLD,20);
        b.setFont(f3);
        b.setBounds(500,400,150,30);
        f.add(b);
        t3=new JLabel();
        i1 = new ImageIcon("let.jpg");
        t3.setIcon(i1);
        t3.setBounds(0,5,370,650);
        f.add(t3);

        b1=new Button("BACK TO MENU");
        Font f6=new Font("New Times Roman",Font.BOLD,25);
        b1.setFont(f6);
        b1.setBounds(480,490,250,30);
        f.add(b1);
        b1.addActionListener(this);
        b.addActionListener(this);
        f.setBounds(30,30,900,650);
        f.setVisible(true);
        }
        public void actionPerformed(ActionEvent ae){
        Object ob=ae.getSource();
        if (ob==b){
                String user=t.getText();
                String pass=t2.getText();
                try{
                rs=st.executeQuery("Select * from login where Username ='"+user+"'and Password='"+pass+"' ");
                if (rs.next()){
                    f.setVisible(false);
                    menu m=new menu();
                }
                

                else {
                    JOptionPane.showMessageDialog(null,"USERNAME OR PASSWORD IS INCORRECT","MOBILE SHOP",0);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e,"MOBILE SHOP",0);
            }
        }

        if (ob==b1){
            signupin s=new signupin();
f.setVisible(false);
        }
        }

}


    
