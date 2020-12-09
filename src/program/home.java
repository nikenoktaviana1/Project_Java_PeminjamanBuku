package program;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 


public class home {  
public static void main(String[] args) {  
    homm g = new homm();  
    g.setVisible(true);  
}  
}

class homm extends JFrame {  
JButton ljudul2 = new JButton();
JLabel ljudul3 = new JLabel("Perpustakaan Punya Kita ");

static String a, b, c;

public homm() {  
     
    ActionListener abc=new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
              a=ljudul3.getText();
              b=a.substring(0,1);
              c=a.substring(1,a.length());
              ljudul3.setText(c+b);
              
                      
           }
       };new javax.swing.Timer(300, abc).start();
setTitle ("Home");  
setDefaultCloseOperation(3);  
setSize(480,370);  
this.getContentPane().setBackground(Color.pink);
setLayout(null);  
add(ljudul2); 

add(ljudul3);

ljudul2.setBounds(150,30,180,150);  ljudul2.setIcon(new ImageIcon(getClass().getResource("/image/kita.jpg")));
ljudul3.setBounds(60,220,400,50);  ljudul3.setFont(new Font("Serif", Font.BOLD, 30));

setVisible(true);  
setAlwaysOnTop(true); 

ljudul2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent bb) {
                dispose();
                loginx zz = new loginx ();
                zz.setVisible(true);
                
                
            }
         });

} 

}

    
