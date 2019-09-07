
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class employedata implements ActionListener {
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

    employedata()
    {
        f = new Frame("Employ data portal");
        f.setLayout(null);
        Color c = new Color(100, 150, 200);
        f.setBackground(c);
        l1 = new Label(" ENTER EMPLOYEE NAME: ");
        l1.setBackground(Color.CYAN);

        l1.setBounds(10, 310, 150, 20);
        f.add(l1);
        l2 = new Label(" ENTER DESIGNATION");
        l2.setBackground(Color.CYAN);
        l2.setForeground(Color.gray);
        l2.setBounds(10, 370, 150, 20);
        f.add(l2);
        l3 = new Label(" ENTER DEPARTMENT ");
        l3.setBackground(Color.CYAN);
        l3.setForeground(Color.gray);
        l3.setBounds(10, 430, 150, 20);
        f.add(l3);
        l4 = new Label("ENTER SALARY ");
        l4.setBackground(Color.CYAN);
        l4.setForeground(Color.gray);
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
       // b7.addActionListener(this);

        f.setSize(800, 600);
        f.setVisible(true);
    }

    public void actionPerformed (ActionEvent ae)
    {
         
    Object ob= ae.getSource();
        if (ob==b1)
        {
            try
            {
                if (b1.getLabel().equals("ADD"))
                {
                    t1.setEnabled(true);
                    t2.setEnabled(true);
                    t3.setEnabled(true);
                    t4.setEnabled(true);
                    b1.setLabel("SAVE");
                }
                else
                {
                    String a=t1.getText();
                    String b=t2.getText();
                    String c=t3.getText();
                    int x =Integer.parseInt(t4.getText());
                    st.execute("insert into employee (e_name,e_design,e_depart,e_sal) values('"+a+"','"+b+"','"+c+"',"+x+")");
                    JOptionPane.showMessageDialog(null,"record inserted","COMPANY",1);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t1.setEnabled(false);
                    t2.setEnabled(false);
                    t3.setEnabled(false);
                    t4.setEnabled(false);
                    b1.setLabel("ADD");
                }

            }
            catch (Exception h)
            {
                JOptionPane.showMessageDialog(null,h,"COMPANY",0);

            }
        }
        if (ob==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }
        if(ob==b3)
        {
            JOptionPane.showConfirmDialog(null,"do you want to exit","KIIT",1);
            System.exit(0);
        }
        if(ob==b4)
        {
            try
            {
                Rs=st.executeQuery("Select * from employee");
                String d[][]=new String[20][5];
                int r=0;
                while(Rs.next())
                {
                    d[r][0]=Rs.getString("e_id");
                    d[r][1]=Rs.getString("e_name");
                    d[r][2]=Rs.getString("e_design");
                    d[r][3]=Rs.getString("e_depart");
                    d[r][4]=Rs.getString("e_sal");
                    r++;

                }
                String h[]={"employe id","employe name","employe designation","employe department","employe salary"};
                JTable tb=new JTable(d,h);
                JScrollPane sp= new JScrollPane(tb);
                sp.setBounds(500,300,300,300);
                f.add(sp);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e,"COPMPANY",0);
            }
        }

        if(ob==b5)
        {
            try
            {
                int id = Integer.parseInt(JOptionPane.showInputDialog(null,"ENTER EMPLOYEE ID YOU WANT TO SEARCH","COMPANY",1));
                Rs= st.executeQuery("Select * from employee where  e_id="+id+" ");
                if (Rs.next())
                {
                    String z= "record found \n";
                    z=z+"\nNAME IS ="+Rs.getString("e_name");
                    z=z+"\nDESINGNATION IS ="+Rs.getString("e_design");
                    z=z+"\nSALARY="+Rs.getString("e_sal");
                    z=z+"\nDEPARTMENT ="+Rs.getString("e_depart");
                    JOptionPane.showMessageDialog(null,z,"COMPANY",1);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"NOT found","COMPANY",1);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e,"COPMPANY",0);
            }

        }
        if (ob==b6)
        {
            if (b6.getLabel().equals("FIND"))
            {
                try{
                    id=Integer.parseInt(JOptionPane.showInputDialog(null,"enter id you want to find and update","COMPANY",1));
                    Rs=st.executeQuery("Select * from employee");
                   
                    while(Rs.next())
                    {
                        if(Rs.getString("e_id").equals("=id"))
                        {
                            t1.setText(Rs.getString("e_name"));
                            t2.setText(Rs.getString("e_design"));
                            t3.setText(Rs.getString("e_depart"));
                            t4.setText(Rs.getString("e_sal"));
                            t1.setEnabled(true);
                            t2.setEnabled(true);
                            t3.setEnabled(true);
                            t4.setEnabled(true);
                            t1.requestFocus();
                            b6.setLabel("UPDATE");
                            JOptionPane.showMessageDialog(null,"record found,if you want to update,then made changes in textfeids and click on update","COMPANY",1);
                            p = true;
                            break;
                        }
                                 

                    }
              if (p==false){
                    JOptionPane.showMessageDialog(null,"not found","COMPANY",0);
                }
                }
                catch (Exception h)
                {
                    JOptionPane.showMessageDialog(null,h,"COMPANY",0);
                }

             }
                else
                {
                    try{
                        st.executeUpdate("Update employee set e_name='"+t1.getText()+"', e_design='"+t2.getText()+"', e_depart='"+t3.getText()+"',e_sal="+Integer.parseInt(t4.getText())+" where e_id="+id+" ");
                        JOptionPane.showMessageDialog(null,"record updated","COMPANY",1);
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t1.setEnabled(false);
                        t2.setEnabled(false);
                        t3.setEnabled(false);
                        t4.setEnabled(false);
                        b6.setLabel("FIND");

                    }
                    catch (Exception h)
                    {
                        JOptionPane.showMessageDialog(null,h,"COMPANY",0);

                    }
                }

            

        }
    }

    public static void main(String args[]) {
        employedata e = new employedata();

    }
}
