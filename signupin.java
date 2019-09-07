import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signupin implements ActionListener {
 Frame f;
 ImageIcon i1,i2;
 JLabel t3;
 Button b1,b2;
 signupin(){
     f=new Frame("sign up or sign in");
     f.setLayout(null);
     f.setBackground(Color.gray);
     b1= new Button("SIGNUP");
     Font f3=new Font("New Times Roman",Font.BOLD,20);
     b1.setFont(f3);
     b1.setBounds(350,340,180,70);
     f.add(b1);
     b2= new Button("SIGNIN");
     Font f4=new Font("New Times Roman",Font.BOLD,20);
     b2.setFont(f4);
     b2.setBounds(560,340,180,70);
     f.add(b2);
     t3=new JLabel();
     i1 = new ImageIcon("let.jpg");
     t3.setIcon(i1);
     t3.setBounds(0,5,370,650);
     f.add(t3);
     b1.addActionListener(this);
     b2.addActionListener(this);

     f.setVisible(true);
     f.setSize(900,650);

 }
    public void actionPerformed(ActionEvent ae) {
        Object ob = ae.getSource();
        if (ob == b1) {
            signup s= new signup();
        f.setVisible(false);
        }
        if (ob == b2) {
            login l= new login();
            f.setVisible(false);
        }

    }
 public static void main(String args []){
     signupin s=new signupin();
 }
}

