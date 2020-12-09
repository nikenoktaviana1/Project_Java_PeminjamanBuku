package program;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

class Menu extends JFrame {
    String [] pilihan = {" - Pilih - "," Input Member ", " Input Buku ", " Form Peminjaman ",
    " Pencarian ", " Exit "};
    JComboBox pil = new JComboBox(pilihan);
    JButton yes = new JButton(" OK ");
    JLabel judul = new JLabel (" PILIHAN ");
   public Menu (){
       setTitle(" Menu ");
       setVisible(true);
       setDefaultCloseOperation(3);  
       setSize(300,150);  
       
       this.getContentPane().setBackground(Color.pink);
       setAlwaysOnTop(true);
       setResizable(false);
       setLayout(null);
       add(pil);
       add(yes);
       add(judul);
       judul.setBounds(120, 10, 85, 50);
       pil.setBounds(80,50, 130,20);
       pil.setBackground(Color.LIGHT_GRAY);
       yes.setBounds(100, 80, 80, 20);
       yes.setBackground(Color.GRAY);
       yes.addActionListener(new ActionListener(){
           public void actionPerformed (ActionEvent ya){
               btnYes (ya);
           }
       });
  }
   public void btnYes (ActionEvent ya){
       if (pil.getSelectedItem().equals(" Input Member ")){
           new InputMember().setVisible(true);
           this.dispose();
       } else if (pil.getSelectedItem().equals(" Input Buku ")){
           new buku().setVisible(true);
           this.dispose();
       } else if (pil.getSelectedItem().equals(" Form Peminjaman ")){
           new pinjambuku().setVisible(true);
           this.dispose();
       }else if (pil.getSelectedItem().equals(" Pencarian ")){
           pencarian cab = new pencarian();
           cab.setVisible(true);
           this.dispose();
       }else if (pil.getSelectedItem().equals(" Exit ")){
           new homm().setVisible(true);
           dispose();
       
   }
}
}