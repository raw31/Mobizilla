import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu implements ActionListener  {
    Frame f;
    JLabel t1,t2,t3,t4,t5,t6;
    ImageIcon i1;
    MenuBar mb;
    Menu m1,m2,m3,m4,m5;
    JDesktopPane dp;

MenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14;
menu(){
    f= new Frame();
    f.setLayout(null);
    f.setBackground(Color.gray);
       
    t1=new JLabel("SGNR BRANCH");
    Font f1=new Font("New Times Roman",Font.BOLD,20);
    t1.setFont(f1);
    t1.setBounds(20,650,300,50);
    f.add(t1);
    t2=new JLabel("www.mobileShop.com");
    Font f2=new Font("New Times Roman",Font.BOLD,20);
    t2.setFont(f2);
    t2.setBounds(670,650,300,50);
    f.add(t2);
        t3=new JLabel();
       i1 = new ImageIcon("let.jpg");
        t3.setIcon(i1);
        t3.setBounds(10,50,350,580);
        f.add(t3);

    // t4=new JLabel();
     //i1 = new ImageIcon("let.jpg");
      //  t4.setIcon(i1);
       // t4.setBounds(5,60,200,200);
        //f.add(t4);

     //t5=new JLabel();
    // i1 = new ImageIcon("37.png");
      //  t5.setIcon(i1);
       // t5.setBounds(745,60,200,200);
       // f.add(t5);
        //t6=new JLabel();
     //i1 = new ImageIcon("37.png");
       // t6.setIcon(i1);
        //t6.setBounds(745,400,200,200);
        //f.add(t6);
    mb=new MenuBar();
     m1=new Menu("New Mobile");
     m2=new Menu("Customer");
     m3=new Menu("View");
     m4=new Menu("Extra");
     m5=new Menu("Login");
     mb.add(m1);
     mb.add(m2);
     mb.add(m3);
     mb.add(m4);
     mb.add(m5);
mi1=new MenuItem("New Mobile");
m1.add(mi1);
mi2=new MenuItem("Update Mobile");
m1.add(mi2);
mi3=new MenuItem("New Customer");
m2.add(mi3);
mi4=new MenuItem("Update Customer");
m2.add(mi4);
mi5=new MenuItem("Delete Customer");
m2.add(mi5);
mi6=new MenuItem("Mobile Sets");
m3.add(mi6);
mi7=new MenuItem("Customer Details");
m3.add(mi7);
mi8=new MenuItem("Sale(monthwise)");
m3.add(mi8);
mi9=new MenuItem("Sale(item wise)");
m3.add(mi9);
mi10=new MenuItem("Calculator");
m4.add(mi10);
mi11=new MenuItem("Background Colour");
m4.add(mi11);
mi12=new MenuItem("Logout");
m5.add(mi12);
mi13=new MenuItem("Change Password");
m5.add(mi13);
mi14=new MenuItem("Exit");
m5.add(mi14);
  f.setMenuBar(mb);
dp=new JDesktopPane();
dp.setLayout(null);
dp.setBounds(330,50,580,580);
f.add(dp);
mi1.addActionListener(this);
mi2.addActionListener(this);
mi3.addActionListener(this);
mi4.addActionListener(this);
mi5.addActionListener(this);
mi6.addActionListener(this);
mi7.addActionListener(this);
mi8.addActionListener(this);
mi9.addActionListener(this);
mi10.addActionListener(this);
mi11.addActionListener(this);
mi12.addActionListener(this);
mi13.addActionListener(this);
mi14.addActionListener(this);
f.setSize(900,700);
    f.setVisible(true);
}

public void actionPerformed ( ActionEvent ae){
	Object ob = ae.getSource();
	if(ob==mi1){
		JInternalFrame jif =new JInternalFrame("new mobile",true,true,true,true);
		jif.setLayout(null);
		jif.setBounds(5,5,560,560);
		newmobile nm = new newmobile();
		jif.add(nm);
		jif.setVisible(true);
		dp.add(jif);
	}
    if(ob==mi2){
        JInternalFrame jif1 =new JInternalFrame("update mobile",true,true,true,true);
        jif1.setLayout(null);
        jif1.setBounds(5,5,560,560);
        Updatemobile um = new Updatemobile();
        jif1.add(um);
        jif1.setVisible(true);
        dp.add(jif1);
 
   }
     if(ob==mi3){
        JInternalFrame jif2 =new JInternalFrame("new Customer",true,true,true,true);
        jif2.setLayout(null);
        jif2.setBounds(5,5,560,560);
        Newcutomer nc = new Newcutomer();
        jif2.add(nc);
        jif2.setVisible(true);
        dp.add(jif2);
    }
    if(ob==mi4){
        JInternalFrame jif3 =new JInternalFrame("update Customer",true,true,true,true);
        jif3.setLayout(null);
        jif3.setBounds(5,5,560,560);
        Updatecustomer nc = new Updatecustomer();
        jif3.add(nc);
        jif3.setVisible(true);
        dp.add(jif3);
    }

     if(ob==mi5){
        JInternalFrame jif4 =new JInternalFrame("update Customer",true,true,true,true);
        jif4.setLayout(null);
        jif4.setBounds(5,5,560,560);
        deletecustomer dc = new deletecustomer();
        jif4.add(dc);
        jif4.setVisible(true);
        dp.add(jif4);
    }
    if (ob==mi14){
    	JOptionPane.showConfirmDialog(null,"DO YOU WANT TO EXIT ?","KIIT",1);
    	System.exit(0);
    }
    if (ob==mi12){
        signupin s=new signupin();
        f.setVisible(false);
    }
}
public static void main(String args []){
	menu m=new menu();
}
}

