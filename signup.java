import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class signup implements ActionListener {
    Frame f;
    JLabel l1,l2,l3,t3,l4,l5,l6;
    JPasswordField p1,p2;
    TextField t,t1;
    ImageIcon i1;
    Button b ,b1;
    Connection con;
    ResultSet rs;
    Statement st;
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
signup(){
f=new Frame("SIGNUP");
f.setLayout(null);
f.setBackground(Color.gray);
    l1= new JLabel("Username :");
    l1.setBounds(400,120,120,50);
    Font f1=new Font("New Times Roman",Font.BOLD,15);
    l1.setFont(f1);
    f.add(l1);
    l2= new JLabel("Password :");
    l2.setBounds(400,180,120,60);
    Font f2=new Font("New Times Roman",Font.BOLD,15);
    l2.setFont(f2);
    f.add(l2);
    l3= new JLabel("|| ENTER YOUR USERNAME AND PASSWORD TO REGISTER ||");
   l3.setBounds(400,70,1000,20);
   f.add(l3);
    t=new TextField();
    t.setBounds(520,135,150,20);
    f.add(t);
    p1=new JPasswordField();
    p1.setBounds(520,195,150,20);
    f.add(p1);

    l4= new JLabel("|| ENTER ANY EXISTING USER-PASSWORD TO REGISTER ||");
    l4.setBounds(400,320,1000,20);
    f.add(l4);
    l5= new JLabel("Username :");
    l5.setBounds(400,370,120,50);
    Font f4=new Font("New Times Roman",Font.BOLD,15);
    l5.setFont(f4);
    f.add(l5);
    l6= new JLabel("Password :");
    l6.setBounds(400,430,120,60);
    Font f3=new Font("New Times Roman",Font.BOLD,15);
    l6.setFont(f3);
    f.add(l6);
    t3=new JLabel();
    i1 = new ImageIcon("let.jpg");
    t3.setIcon(i1);
    t3.setBounds(0,5,370,650);
    f.add(t3);
    t1=new TextField();
    t1.setBounds(520,385,150,20);
    f.add(t1);
    p2=new JPasswordField();
    p2.setBounds(520,445,150,20);
    f.add(p2);
    b=new Button("VERIFY");
    Font f5=new Font("New Times Roman",Font.BOLD,20);
    b.setFont(f5);
    b.setBounds(500,545,150,30);
    f.add(b);
    b1=new Button("BACK TO MENU");
    Font f6=new Font("New Times Roman",Font.BOLD,25);
    b1.setFont(f6);
    b1.setBounds(500,590,200,30);
    f.add(b1);
    t.setEnabled(false);
    p1.setEnabled(false);
    f.setSize(900,650);
f.setVisible(true);
b.addActionListener(this);
b1.addActionListener(this);

}
    public void actionPerformed(ActionEvent ae){
        Object ob=ae.getSource();
        if (ob==b1){
        signupin s=new signupin();
        f.setVisible(false);
    }
    if (ob==b){
        String user=t.getText();
        String pass=p2.getText();

        rs=st.executeQuery("Select * from login where Username ='"+user+"'and Password='"+pass+"' ");
        if (rs.next()){
            f.setVisible(false);
            menu m=new menu();
        }


        else {
            JOptionPane.showMessageDialog(null,"USERNAME OR PASSWORD IS INCORRECT","MOBILE SHOP",0);
        }
    }
}
public static void main(String args []){

    signup s= new signup();

}
}

