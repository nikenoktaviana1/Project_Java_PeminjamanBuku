package program;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;
import logic.koneksi;


public class pinjam {
        
pinjambuku PB = new pinjambuku();  
    
}   
class pinjambuku extends JFrame {
    public String sql = "";
    String namam,nom,judulb,pengarangb,penerbitb,tglp,tglk;
     JLabel Ljudul = new JLabel (" Pinjam Buku ");   
     JLabel Lnamam = new JLabel (" Nama ");
     JLabel Lnom = new JLabel (" No ");
     JLabel Ljudulb = new JLabel (" Judul Buku ");
     JLabel Lpengarangb = new JLabel (" Pengarang ");
     JLabel Lpenerbitb = new JLabel (" Penerbit ");
     JLabel Ltglp = new JLabel (" Tanggal Pinjam ");
     JLabel Ltglk = new JLabel (" Tanggal Kembali ");
     final JTextField Fnamam = new JTextField ();
     final JTextField Fnom = new JTextField ();
     final JTextField Fjudulb = new JTextField ();
     final JTextField Fpengarangb = new JTextField ();
     final JTextField Fpenerbitb = new JTextField ();
     final JTextField Ftglp = new JTextField ();
     final JTextField Ftglk = new JTextField ();
     JButton Bsave = new JButton(" Save ");
     JButton Bedit = new JButton (" Edit ");
     JButton Bhome = new JButton();
     JButton Breset = new JButton (" Reset Inputan ");
     String sqlTampil="select * from pinjam";
     DefaultTableModel model;
     JTable tabel;
     JScrollPane scrollpane;
     koneksi knek=new koneksi();
    public pinjambuku (){
        knek.flaged("pinjam");
        model=knek.getModel();
        tabel = new JTable (model);
        knek.tampil(sqlTampil);
        scrollpane = new JScrollPane (tabel);
        this.getContentPane().setBackground(Color.pink);
        setTitle (" FORM PEMINJAMAN ");  
        setDefaultCloseOperation(3);  
        setSize(600,650);  
        setAlwaysOnTop(true);
        setResizable(false);
        setLayout(null);  
        add(Ljudul);
        add(Fnamam); add(Lnamam);
        add(Fnom); add(Lnom);
        add(Fjudulb); add(Ljudulb);
        add(Fpengarangb); add(Lpengarangb);
        add(Fpenerbitb); add(Lpenerbitb);
        add(Ftglp); add(Ltglp);
        add(Ftglk); add(Ltglk);
        add(Bsave); add(Bedit);add(Bhome);add(Breset);
        
        add(scrollpane);
        
        Lnamam.setBounds(10,50, 70, 30);
         Lnom.setBounds(10,10, 70, 30);
          Ljudulb.setBounds(10,90, 70, 30);
           Lpengarangb.setBounds(10,130, 120, 30);
            Lpenerbitb.setBounds(10,170, 70, 30);
             Ltglp.setBounds(10,210, 100, 30);   
             Ltglk.setBounds(10,250, 100, 30);   
        Fnamam.setBounds(150,50, 230, 30);  
         Fnom.setBounds (150,10, 230, 30); 
          Fjudulb.setBounds(150,90, 230, 30);
           Fpengarangb.setBounds(150,130, 230, 30); 
            Fpenerbitb.setBounds(150,170, 230, 30); 
             Ftglp.setBounds(150,210, 230, 30);  
              Ftglk.setBounds(150,250, 230, 30);   
        Bsave.setBounds(450,30,120,30);
         Bedit.setBounds(450,90,120,30);
          Breset.setBounds(450,150,120,30);
           Bhome.setBounds(480,210,50,40);
             Bhome.setIcon(new ImageIcon(getClass().getResource("/image/home.png")));
        Ljudul.setBounds(250, 250, 100, 30);
        scrollpane.setBounds(20,300,550,100);
        
           Bsave.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent bb) {
        sql="INSERT INTO pinjam (nomor,nama,judul,pengarang,penerbit,tglp, tglk) VALUES ('"+Fnom.getText()+"','"+Fnamam.getText()+"','"+Fjudulb.getText()+"','"+Fpengarangb.getText()+"','"+Fpenerbitb.getText()+"','"+Ftglp.getText()+"','"+Ftglk.getText()+"');";
     knek.inputData(sql);
     resetTabel();
     knek.tampil(sqlTampil);
        }});
        Breset.addActionListener (new ActionListener (){
            @Override
            public void actionPerformed (ActionEvent rst){
                btnreset(rst);
            }
        });
        Bhome.addActionListener (new ActionListener (){
            @Override
            public void actionPerformed (ActionEvent hm){
                btnhome(hm);
            }
        });
        Bedit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent bb) {
                sql = "UPDATE pinjam SET nama='"+Fnamam.getText()+"' ,judul='"+
                Fjudulb.getText()+"' ,pengarang='"+Fpengarangb.getText()+"',penerbit='"+Fpenerbitb.getText()+
                   "',tglp='"+Ftglp.getText()+"',tglk='"+Ftglk.getText()+"' WHERE nomor= '"+Fnom.getText()+"'";
                knek.edit(sql);
                resetTabel();
                knek.tampil(sqlTampil);
                
            }
         });
tabel.addMouseListener(new MouseAdapter() { 
         public void mousePressed(MouseEvent me) {
                klik(me);
         }
    
   });
       
    }
    
    public void btnreset (ActionEvent rst){
        Fnamam.setText("");
        Fnom.setText("");
        Fjudulb.setText("");
        Fpengarangb.setText("");
        Fpenerbitb.setText("");
        Ftglp.setText("");
        Ftglk.setText("");
    }
    public void btnhome (ActionEvent hm){
        Menu m = new Menu();  
        m.setVisible(true);
        this.dispose();
    }
        
public void klik(MouseEvent me){                                  
  int i = tabel.getSelectedRow();
  DefaultTableModel model = (DefaultTableModel)tabel.getModel();
  Fnamam.setText(model.getValueAt(i, 1).toString());
  Fnom.setText(model.getValueAt(i, 0).toString());
  Fjudulb.setText(model.getValueAt(i, 2).toString());
  Fpengarangb.setText(model.getValueAt(i, 3).toString());      
  Fpenerbitb.setText(model.getValueAt(i, 4).toString());    
  Ftglp.setText(model.getValueAt(i, 5).toString());    
  Ftglk.setText(model.getValueAt(i, 6).toString()); 
  
}   


private void resetTabel(){
    int row=tabel.getRowCount();
    for(int i=0;i<row;i++){
        model.removeRow(0);
    }
}

    
}
 


