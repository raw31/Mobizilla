import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class school implements ActionListener {
    Frame f;
    Label l1, l2, l3, l4;
    Button b1, b2, b3, b4, b5, b6;
    TextField t1, t2, t3, t4;
    Connection con;
    Statement st;
    ResultSet Rs;
    boolean p;
    int id;
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
            st=con.createStatement();
            JOptionPane.showMessageDialog(null,"CONNECTED","COMPANY",1);
        }
        catch(Exception h){
            JOptionPane.showMessageDialog(null,h,"COMPANY",0);
        }
    }

    school()
    {
        f = new Frame("FACULTY");
        f.setLayout(null);
        Color c = new Color(100, 150, 200);
        f.setBackground(c);
        l1 = new Label(" Name: ");
        l1.setBounds(10, 310, 150, 20);
        f.add(l1);
        l2 = new Label(" Subject:");
        l2.setBounds(10, 370, 150, 20);
        f.add(l2);
        l3 = new Label(" Result:");
        l3.setBounds(10, 430, 150, 20);
        f.add(l3);
        l4 = new Label(" Ratings:");
        l4.setBounds(10, 490, 150, 20);
        f.add(l4);

        t1 = new TextField();
        t1.setBounds(180, 310, 100, 20);
        f.add(t1);
        t2 = new TextField();
        t2.setBounds(180, 370, 100, 20);
        f.add(t2);
        t3 = new TextField();
        t3.setBounds(180, 430, 100, 20);
        f.add(t3);
        t4 = new TextField();
        t4.setBounds(180, 490, 100, 20);
        f.add(t4);
        b1 = new Button("ADD");
        b1.setBounds(400, 290, 100, 20);
        f.add(b1);
        b2 = new Button("CLEAR");
        b2.setBounds(400, 340, 100, 20);
        f.add(b2);
        b3 = new Button("END");
        b3.setBounds(400, 390, 100, 20);
        f.add(b3);
        b4 = new Button("SHOWALL");
        b4.setBounds(400, 440, 100, 20);
        f.add(b4);
        b5 = new Button("SEARCH");
        b5.setBounds(400, 490, 100, 20);
        f.add(b5);
        b6 = new Button("FIND");
        b6.setBounds(400, 540, 100, 20);
        f.add(b6);
        t1.setEnabled(false);
        t2.setEnabled(false);
        t3.setEnabled(false);
        t4.setEnabled(false);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        f.setSize(800, 600);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        Object ob =ae.getSource();
        if(ob==b1){
            try{
                if (b1.getLabel().equals("ADD")){
                    t1.setEnabled(true);
                    t2.setEnabled(true);
                    t3.setEnabled(true);
                    t4.setEnabled(true);
                    b1.setLabel("SAVE");
                }
        else{
            String a,b;
            a=t1.getText();
            b=t2.getText();
           int c=Integer.parseInt(t3.getText());
            int x=Integer.parseInt(t4.getText());
             st.execute("insert into employee (name,subject,result,ratings) values('"+a+"','"+b+"',"+c+","+x+")");
                    JOptionPane.showMessageDialog(null,"record inserted","COMPANY",1);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t1.setEnabled(false);
                    t2.setEnabled(false);
                    t3.setEnabled(false);
                    t4.setEnabled(false);
            }
            
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,e,"SCHOOL",0);
            }
            
                }

                if (ob==b2){
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                }
                if (ob==b3){
                    JOptionPane.showConfirmDialog(null,"do you want to exit","KIIT",1);
            System.exit(0);
                }
            }
            
 


    
    public static void main (String args []){
        school s=new school();
    }
    }