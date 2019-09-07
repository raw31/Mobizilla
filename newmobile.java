import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class newmobile extends Panel implements ActionListener{
    Button b1,b2;
    Frame f;
    TextField t1,t2,t3,t4,t5,t6;
    Label l1,l2,l3,l4,l5,l6,l7;
    Checkbox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9;
    CheckboxGroup cbg;
    Connection con;
    Statement st;
    ResultSet Rs;
{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newmobile","root","");
            st=con.createStatement();
            JOptionPane.showMessageDialog(null,"CONNECTED","newmobile",1);
        }
        catch(Exception h){
            JOptionPane.showMessageDialog(null,h,"COMPANY",0);
        }
    }

    newmobile() {
        setLayout(null);
        //label
        l1= new Label("mobile_ID ");
        //l1.setBackground(Color.CYAN);
        l1.setBounds(30, 40, 100, 20);
        add(l1);
        l2= new Label("Mobile Company Name ");
        //l2.setBackground(Color.CYAN);
        l2.setBounds(30, 80, 100, 20);
        add(l2);

        l3= new Label("Model No ");
        //l3.setBackground(Color.CYAN);
        l3.setBounds(30, 120, 100, 20);
        add(l3);

        l4= new Label("IMEI ");
        //l4.setBackground(Color.CYAN);
        l4.setBounds(30, 160, 100, 20);
        add(l4);

        l5= new Label("Ammount ");
        // l5.setBackground(Color.CYAN);
        l5.setBounds(30, 200, 100, 20);
        add(l5);
        l6= new Label("Colour ");
        // l6.setBackground(Color.CYAN);
        l6.setBounds(30,240, 100, 20);
        add(l6);
        l7= new Label("Features ");
        //  l7.setBackground(Color.CYAN);
        l7.setBounds(30, 320, 100, 20);
        add(l7);
        //textfield
        t1=new TextField("");
        t1.setBounds(170,40,100,20);
        add(t1);
        t2=new TextField("");
        t2.setBounds(170,80,100,20);
        add(t2);
        t3=new TextField("");
        t3.setBounds(170,120,100,20);
        add(t3);
        t4=new TextField("");
        t4.setBounds(170,160,100,20);
        add(t4);
        t5=new TextField("");
        t5.setBounds(170,200,100,20);
        add(t5);
//checkbox
        cbg=new CheckboxGroup();
        cb1=new Checkbox("ROSE GOLD",cbg,true);
        cb1.setBounds(80,260,100,30);
        add(cb1);
        cb2=new Checkbox("White",cbg,true);
        cb2.setBounds(200,260,100,30);
        add(cb2);
        cb3=new Checkbox("black",cbg,true);
        cb3.setBounds(320,260,100,30);
        add(cb3);
        cb4=new Checkbox("Golden",cbg,true);
        cb4.setBounds(80,280,100,30);
        add(cb4);
        cb5=new Checkbox("Dual Camera");
        cb5.setBounds(80,340,100,30);
        add(cb5);

        cb6=new Checkbox("fg");
        cb6.setBounds(180,340,100,30);
        add(cb6);

        cb7=new Checkbox("Fingerprint");
        cb7.setBounds(280,340,100,30);
        add(cb7);

        cb8=new Checkbox("threedscreen");
        cb8.setBounds(80,370,100,30);
        add(cb8);


        b1=new Button("OKAY");
        Font f3=new Font("New Times Roman",Font.BOLD,8);
        b1.setFont(f3);
        b1.setBounds(180,450,60,30);
        add(b1);

        b2=new Button("Cancel");
        Font f4=new Font("New Times Roman",Font.BOLD,8);
        b2.setFont(f4);
        b2.setBounds(350,450,60,30);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(480,490);
    }
    public void actionPerformed (ActionEvent ae){
        Object ob = ae.getSource();
        if (ob==b1){
            try{
                String b= t2.getText();
                int a,c,d,e;
                a=Integer.parseInt(t1.getText());
                c=Integer.parseInt(t3.getText());
                d=Integer.parseInt(t4.getText());
                e=Integer.parseInt(t5.getText());
                String colour=null;
                if(cb1.getState()){
                    colour="black";
                }
                else{
                    if ( cb2.getState ()){
                        colour="White";

                    }
                    else{
                        if(cb3.getState()){
                            colour="ROSE GOLD";
                        }else{
                                colour="Golden";


                        }
                    }
                }


                String dcamera,fingerprint,threedscreen,fg;

                if (cb5.getState()){
                    dcamera="YES";
                }
                else{
                    dcamera="NO";
                }
                if (cb6.getState()){
                    fingerprint="YES";
                }
                else{
                    fingerprint="NO";
                }
                if (cb7.getState()){
                    threedscreen="YES";
                }
                else{
                    threedscreen="NO";
                }
                if (cb8.getState()){
                    fg="YES";
                }
                else{
                    fg="NO";
                }
                st.execute("insert into newmobilee (mobile_ID,mobilecompanyname,modelno,imei,ammount,colour,dcamera,fingerprint,threedscreen,fg) values("+a+",'"+b+"',"+c+","+d+","+e+",'"+colour+"','"+dcamera+"','"+fingerprint+"','"+threedscreen+"','"+fg+"')");
                JOptionPane.showMessageDialog(null,"record inserted","COMPANY",1);

            }
            catch (Exception h)
            {
                JOptionPane.showMessageDialog(null,h,"COMPANY",0);

            }
        }
    }

}

