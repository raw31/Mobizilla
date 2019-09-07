import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Updatecustomer extends Panel{
Button b1,b2,b3;
Frame f;
TextField t1,t2,t3,t4,t5,t6;
Label l1,l2,l3,l4,l5,l6,l7;
Checkbox cb5,cb6;
Updatecustomer() {
	setLayout(null);
	//label
l1= new Label("Name :");
        //l1.setBackground(Color.CYAN);
        l1.setBounds(30, 40, 100, 20);
        add(l1);
l2= new Label("Address :");
        //l2.setBackground(Color.CYAN);
        l2.setBounds(30, 80, 100, 20);
        add(l2);

l3= new Label("E-mail :");
        //l3.setBackground(Color.CYAN);
        l3.setBounds(30, 120, 100, 20);
        add(l3);

l4= new Label("Phone no. :");
        //l4.setBackground(Color.CYAN);
        l4.setBounds(30, 160, 100, 20);
        add(l4);

l5= new Label("Purchase date :");
       // l5.setBackground(Color.CYAN);
        l5.setBounds(30, 200, 100, 20);
        add(l5);
l6= new Label("Model no. :");
       // l6.setBackground(Color.CYAN);
        l6.setBounds(30,240, 100, 20);
        add(l6);
 l7= new Label("Gender :");
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
        t6=new TextField("");
        t6.setBounds(170,240,100,20);
        add(t6);
//checkbox
   CheckboxGroup cbg = new CheckboxGroup();
cb5=new Checkbox("Male",cbg,true);  
        cb5.setBounds(80,340,100,30);
add(cb5);

cb6=new Checkbox("Female",cbg,true);  
        cb6.setBounds(180,340,100,30);
add(cb6);

b1=new Button("Update");
        Font f3=new Font("New Times Roman",Font.BOLD,8);
        b1.setFont(f3);
        b1.setBounds(220,450,60,30);
        add(b1);

  b2=new Button("Cancel");
        Font f4=new Font("New Times Roman",Font.BOLD,8);
        b2.setFont(f4);
        b2.setBounds(350,450,60,30);
        add(b2);
b3=new Button("Search");
        Font f5=new Font("New Times Roman",Font.BOLD,8);
        b3.setFont(f5);
        b3.setBounds(125,450,60,30);
        add(b3);




setSize(480,490);
}

} 