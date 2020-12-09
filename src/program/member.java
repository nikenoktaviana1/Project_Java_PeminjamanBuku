package program;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;
import logic.koneksi;

    public class member {  
       
        InputMember IM = new InputMember();  
       
}
class InputMember extends JFrame {
    public String sql = "";
    String nama,ttl,alamat,instansi,pekerjaan,nomer;
    String [] isi = new String[6];
    JLabel Ljudul = new JLabel (" Daftar Member ");   
    JLabel Lnama = new JLabel (" Nama ");
    JLabel Lttl = new JLabel (" TTL ");
    JLabel Lalamat = new JLabel (" ALamat ");
    JLabel Linstansi = new JLabel (" Instansi/Sekolah/PT ");
    JLabel Lpekerjaan = new JLabel (" Pekerjaan ");
    JLabel Lno = new JLabel (" No. Member ");
    final JTextField Fnama = new JTextField ();
    final JTextField Fttl = new JTextField ();
    final JTextField Falamat = new JTextField ();
    final JTextField Finstansi = new JTextField ();
    final JTextField Fpekerjaan = new JTextField ();
    final JTextField Fno = new JTextField ();
     JButton Bsave = new JButton(" Save ");
     JButton Bedit = new JButton (" Edit ");
     JButton Bhome = new JButton();
     JButton Breset = new JButton (" Reset ");
  
     DefaultTableModel model;
     JTable tabel;
     JScrollPane scrollpane;
     String sqlTampil="select * from MEMBER";
        koneksi knek=new koneksi();
    public InputMember (){
        knek.flaged("member");
        model=knek.getModel();
        knek.tampil(sqlTampil);
        tabel = new JTable (model);
        scrollpane = new JScrollPane (tabel);
        this.getContentPane().setBackground(Color.pink);
        setTitle (" Input Member ");  
        setDefaultCloseOperation(3);  
        setSize(600,650);  
        setAlwaysOnTop(true);
        setResizable(false);
        setLayout(null);  
        add(Ljudul);
        add(Fnama); add(Lnama);
        add(Fttl); add(Lttl);
        add(Falamat); add(Lalamat);
        add(Finstansi); add(Linstansi);
        add(Fpekerjaan); add(Lpekerjaan);
        add(Fno); add(Lno);
        add(Bsave); add(Bedit);add(Bhome);add(Breset);
        
        add(scrollpane);
        
        Lnama.setBounds(10,10, 70, 30);
         Lttl.setBounds(10,50, 70, 30);
          Lalamat.setBounds(10,90, 70, 30);
           Linstansi.setBounds(10,130, 120, 30);
            Lpekerjaan.setBounds(10,170, 70, 30);
             Lno.setBounds(10,210, 80, 30);   
        Fnama.setBounds(150,10, 230, 30);    
         Fttl.setBounds(150,50, 230, 30);  
          Falamat.setBounds(150,90, 230, 30);   
           Finstansi.setBounds(150,130, 230, 30);   
            Fpekerjaan.setBounds(150,170, 230, 30);   
             Fno.setBounds(150,210, 230, 30);   
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
        sql="INSERT INTO member (nama,ttl,alamat,instansi,pekerjaan,nomor) VALUES ('"+Fnama.getText()+"','"+Fttl.getText()+"','"+Falamat.getText()+"','"+Finstansi.getText()+"','"+Fpekerjaan.getText()+"','"+Fno.getText()+"');";
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
                sql = "UPDATE member SET nama='"+Fnama.getText()+"' ,ttl='"+
                Fttl.getText()+"' ,alamat='"+Falamat.getText()+"',instansi='"+Finstansi.getText()+
                   "',pekerjaan='"+Fpekerjaan.getText()+"' WHERE nomor= '"+Fno.getText()+"'";     
                knek.edit(sql);
                resetTabel();
                knek.tampil(sqlTampil);
            }
         });
tabel.addMouseListener(new MouseAdapter() { 
         public void mousePressed(MouseEvent me) {
             //pressed => event ini terjadi ketika user menekan salah satu tombol mouse diatas komponen swing.
                klik(me);
         }
    
   });
    }
    public void btnreset (ActionEvent rst){
        Fnama.setText("");
        Fttl.setText("");
        Falamat.setText("");
        Finstansi.setText("");
        Fpekerjaan.setText("");
        Fno.setText("");
    }
    private void resetTabel(){
        int row=tabel.getRowCount();
        for(int i=0;i<row;i++){
            model.removeRow(0);
        }
    }
    public void btnhome (ActionEvent hm){
        Menu m = new Menu();  
        m.setVisible(true);
        this.dispose();
    }
    
    
public void klik(MouseEvent me){                                  
  int i = tabel.getSelectedRow();
  DefaultTableModel model = (DefaultTableModel)tabel.getModel();
  Fnama.setText(model.getValueAt(i, 0).toString());
  Fttl.setText(model.getValueAt(i, 1).toString());
  Falamat.setText(model.getValueAt(i, 2).toString());
  Finstansi.setText(model.getValueAt(i, 3).toString());      
  Fpekerjaan.setText(model.getValueAt(i, 4).toString());    
  Fno.setText(model.getValueAt(i, 5).toString());    
}   
}
