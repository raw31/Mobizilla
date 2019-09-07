import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Updatemobile extends Panel  {
    Button b1, b2, b3;
    Frame f;
    TextField t1, t2, t3, t4, t5, t6;
    Label l1, l2, l3, l4, l5, l6, l7;
    Checkbox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9;
    CheckboxGroup cbg;
    ResultSet Rs;
    Statement st;
    Connection con;

    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newmobile", "root", "");
            st = con.createStatement();
            JOptionPane.showMessageDialog(null, "CONNECTED", "newmobile", 1);
        } catch (Exception h) {
            JOptionPane.showMessageDialog(null, h, "COMPANY", 0);
        }
    }

    Updatemobile() {
        setLayout(null);
        //label

        System
        l1 = new Label("Mobile ID :");
        //l1.setBackground(Color.CYAN);
        l1.setBounds(40, 40, 100, 20);
        add(l1);
        l2 = new Label("Mobile Company Name :");
        //l2.setBackground(Color.CYAN);
        l2.setBounds(40, 80, 100, 20);
        add(l2);

        l3 = new Label("Model No :");
        //l3.setBackground(Color.CYAN);
        l3.setBounds(30, 120, 100, 20);
        add(l3);

        l4 = new Label("IMEI :");
        //l4.setBackground(Color.CYAN);
        l4.setBounds(30, 160, 100, 20);
        add(l4);

        l5 = new Label("Ammount :");
        // l5.setBackground(Color.CYAN);
        l5.setBounds(30, 200, 100, 20);
        add(l5);
        l6 = new Label("Colour :");
        // l6.setBackground(Color.CYAN);
        l6.setBounds(30, 240, 100, 20);
        add(l6);
        l7 = new Label("Features :");
        //  l7.setBackground(Color.CYAN);
        l7.setBounds(30, 320, 100, 20);
        add(l7);
        //textfield
        t1 = new TextField("");
        t1.setBounds(170, 40, 100, 20);
        add(t1);
        t2 = new TextField("");
        t2.setBounds(170, 80, 100, 20);
        add(t2);
        t3 = new TextField("");
        t3.setBounds(170, 120, 100, 20);
        add(t3);
        t4 = new TextField("");
        t4.setBounds(170, 160, 100, 20);
        add(t4);
        t5 = new TextField("");
        t5.setBounds(170, 200, 100, 20);
        add(t5);
//checkbox
        cbg = new CheckboxGroup();
        cb1 = new Checkbox("ROSE GOLD", cbg, true);
        cb1.setBounds(80, 260, 100, 30);
        add(cb1);
        cb2 = new Checkbox("White", cbg, true);
        cb2.setBounds(200, 260, 100, 30);
        add(cb2);
        cb3 = new Checkbox("black", cbg, true);
        cb3.setBounds(320, 260, 100, 30);
        add(cb3);
        cb4 = new Checkbox("Golden", cbg, true);
        cb4.setBounds(80, 280, 100, 30);
        add(cb4);
        cb5 = new Checkbox("Dual Camera");
        cb5.setBounds(80, 340, 100, 30);
        add(cb5);

        cb6 = new Checkbox("fg");
        cb6.setBounds(180, 340, 100, 30);
        add(cb6);

        cb7 = new Checkbox("Fingerprint");
        cb7.setBounds(280, 340, 100, 30);
        add(cb7);

        cb8 = new Checkbox("3Dscreen");
        cb8.setBounds(80, 370, 100, 30);
        add(cb8);


        b1 = new Button("Update");
        Font f3 = new Font("New Times Roman", Font.BOLD, 8);
        b1.setFont(f3);
        b1.setBounds(220, 450, 60, 30);
        add(b1);

        b2 = new Button("Cancel");
        Font f4 = new Font("New Times Roman", Font.BOLD, 8);
        b2.setFont(f4);
        b2.setBounds(350, 450, 60, 30);
        add(b2);
        b3 = new Button("Search");
        Font f5 = new Font("New Times Roman", Font.BOLD, 8);
        b3.setFont(f5);
        b3.setBounds(125, 450, 60, 30);
        add(b3);

        setSize(480, 490);
    }
}

 /*   public void actionPerformed (ActionEvent ae){
        Object ob = ae.getSource();
       if (ob==b3){
            try{
                int id;
                id=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the mobile id you want to search","MobileShop",0));
                Rs=st.executeQuery("Select * from newmobile where mobile_ID="+id+" ");
                if(Rs.next()){
                    JOptionPane.showMessageDialog(null,"present","MobileShop",1);
                    t1.setText(Rs.getString("mobile_id"));
                    t2.setText(Rs.getString("mobilecompanyname"));
                    t3.setText(Rs.getString("modelno"));
                    t4.setText(Rs.getString("imei"));
                    t5.setText(Rs.getString("ammoumt"));
                    if(Rs.getstring("dcamera").equals("Yes"))
                    {
                      cb1.setSelected(true);

                    }
                else
                {
                   cb1.setSelected(false); 
                }

                
                 if(Rs.getstring("fingerprint").equals("Yes"))
                    {
                      cb2.setSelected(true);

                    }
                else
                {
                   cb2.setSelected(false); 
                }

                
                 if(Rs.getstring("threedscreen").equals("Yes"))
                    {
                      cb3.setSelected(true);

                    }
                else
                {
                   cb3.setSelected(false); 
                }
                 if(Rs.getstring("fg").equals("Yes"))
                    {
                      cb4.setSelected(true);

                    }
                else
                {
                   cb4.setSelcted (false);
                }

                }
                else{
                  JOptionPane.showMessageDialog(null,"record not found","MobileShop",0);
                }

                }

                
            catch (Exception e){
JOptionPane.showMessageDialog(null,e,"MobileShop",0);
            }

        }
                    
    }
}
