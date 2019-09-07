import javax.swing.*;
import java.awt.*;
public class Mobilee {
    Frame f;
    JLabel l1,l2,l3,l4,l5;
    JProgressBar jpb;
    ImageIcon backgroundimage,imge ;
    Image img,temp_img;

    int i;
    Mobilee(){
        f=new Frame("MOBILE SHOP");
        Color c= new Color(255,255,255);
        f.setBackground(c);
        f.setLayout(null);


        
        ImageIcon backgroundimage=new ImageIcon("55.jpg");
        Image img= backgroundimage.getImage();
        Image temp_img=img.getScaledInstance(2000,1000,Image.SCALE_SMOOTH);
        JLabel l5=new JLabel("",backgroundimage,JLabel.CENTER);
        l5.setBounds(0,0,2000,1000);
  		f.add(l5);

imge = new ImageIcon("2.gif");
        l2= new JLabel(imge);
        l2.setBounds(450,70,600,450);
        
        l2.setIcon(imge);
        f.add(l2);


        l1=new JLabel("LOADING...");
        l1.setBounds(650,700,400,50);
        Font f1 = new Font("Times New Roman",Font.BOLD,40);
        l1.setFont(f1);
        f.add(l1);
        l3=new JLabel("SGNR BRANCH");
        l3.setBounds(40,600,100,300);
        f.add(l3);
        l4=new JLabel("www.mobileShop.com");
        l4.setBounds(1300,700,300,100);
        f.add(l4);
       f.setBounds(10,10,1920,1080);
        jpb=new JProgressBar(1,100);
        jpb.setBounds(550,600,400,20);
        f.add(jpb);
        f.setVisible(true);
for ( i=0;i<=100;i=i+4){
    try{
        Thread.sleep(200);
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e,"MOBILE SHOP",0);
    }
    jpb.setValue(i);
    }

    f.setVisible(false);
        signupin s=new signupin();
    }
    
    public static void main(String args []) {
        Mobilee m = new Mobilee();
    }
}