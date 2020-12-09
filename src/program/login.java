package program;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class login {    
loginx g = new loginx();  
 
 
}
class loginx extends JFrame {  
 
 
final JTextField fnama = new JTextField(10);  
final JPasswordField fps = new JPasswordField(10);  
 
JLabel ljudul = new JLabel("== L O G I N ==");  
JLabel lnama = new JLabel("Username ");  
JLabel lPS = new JLabel("Password");  
JButton btnLogin = new JButton("Login");  
JButton btnCancel = new JButton("Cancel");  
public loginx() {  
 
setTitle ("Login");  
setDefaultCloseOperation(3);  
setSize(400,270);  
 this.getContentPane().setBackground(Color.pink);
setLayout(null);  
add(ljudul);  
add(lnama);  
add(fnama);  
add(lPS);  
add(fps);  
add(btnCancel);  
add(btnLogin);  
ljudul.setBounds(150,10,140,23); 
lnama.setBounds(10,60,140,23);  
fnama.setBounds(155,60,200,23);  
lPS.setBounds(10,105,140,23);  
fps.setBounds(155,105,200,23);  
btnLogin.setBounds(70,160,70,20);  
btnCancel.setBounds(180,160,100,20);
btnLogin.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent evt) {
        loginn(evt);
    }});
btnCancel.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent bb) {
        dispose();
    }});
setVisible(true);  
setAlwaysOnTop(true); 
}

public void loginn(ActionEvent evt){
    if(fnama.getText().equals("admin")&&fps.getText().equals("admin")){
        Menu m =new Menu ();
        m.setVisible(true);
        this.dispose();   
    }
    else{
        JOptionPane.showMessageDialog(null, "Salah, silahkan coba lagi yaa", "Warning", JOptionPane.WARNING_MESSAGE);
    }
} 
}
