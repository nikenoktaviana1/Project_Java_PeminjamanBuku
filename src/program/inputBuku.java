package program;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import logic.koneksi;
public class inputBuku {
    public static void main(String[] args) {
        
    
        
        buku x = new buku();
    x.setVisible(true);
    }
}
class buku extends JFrame{

    public String sql = "";    
    
JLabel atas = new JLabel("Data Input Buku");
JLabel tanggal = new JLabel("Tanggal Masuk");
final JTextField ftanggal = new JTextField(10);
JLabel kode = new JLabel("Kode Buku");
final JTextField fkode = new JTextField(10);
JLabel jenis = new JLabel("Genre Buku");
String[] jenisB = {"-Pilih-", "Bocah", "Horor", "Pelajaran", "Jurnal", "Dewasa"};
JComboBox cmbJenis = new JComboBox(jenisB);
JLabel bjudul = new JLabel("Judul Buku");
final JTextField fjudul = new JTextField(10);
JLabel penerbit = new JLabel("Penerbit Buku");
final JTextField fpenerbit = new JTextField(10);
JLabel pengarang = new JLabel("Pengarang Buku");
final JTextField fpengarang = new JTextField(10);
JLabel stok = new JLabel("Stok Buku");
final JTextField fstok = new JTextField(10);
JLabel rak = new JLabel("Rak Buku");
String[] rakB = {"-Pilih-", "1", "2", "3", "4"};
JComboBox cmbRak = new JComboBox(rakB);
JButton save = new JButton("Save");
JButton edit = new JButton("Edit");
JButton delete = new JButton("Delete");
JButton reset = new JButton("Reset");
JButton home = new JButton();
DefaultTableModel model;
     JTable tabel;
     JScrollPane scrollpane;
  koneksi knek=new koneksi();
  String sqlTampil;
public buku(){
    knek.flaged("buku");
    model=knek.getModel();
    tabel = new JTable (model);
    sqlTampil="select * from input_buku";
   knek.tampil(sqlTampil);
    scrollpane = new JScrollPane (tabel);
this.getContentPane().setBackground(Color.blue);
setTitle ("Input Data");
setDefaultCloseOperation(3);
setSize(600,650);
this.getContentPane().setBackground(Color.pink);
    
setLayout(null);
add(atas);
add(tanggal);
add(ftanggal);
add(kode);
add(fkode);
add(jenis);
add(cmbJenis);
add(bjudul);
add(fjudul);
add(penerbit);
add(fpenerbit);
add(pengarang);
add(fpengarang);
add(stok);
add(fstok);
add(rak);
add(cmbRak);
add(save);
add(edit);
add(delete);
add(reset);
add(home);
add(scrollpane);
atas.setBounds(20,10,200,50); atas.setFont(new Font("Serif", Font.BOLD, 25));
tanggal.setBounds(180,60,100,20); tanggal.setFont(new Font("Serif", Font.ITALIC, 14));
ftanggal.setBounds(280,60,70,20); 
kode.setBounds(20,100,100,20); 
fkode.setBounds(130,100,140,20);
jenis.setBounds(20,130,100,20); 
cmbJenis.setBounds(130,130,140,20);
bjudul.setBounds(20,160,100,20); 
fjudul.setBounds(130,160,140,20); 
penerbit.setBounds(20,190,100,20); 
fpenerbit.setBounds(130,190,140,20);
pengarang.setBounds(20,220,100,20);
fpengarang.setBounds(130,220,140,20);
stok.setBounds(20,250,100,20);
fstok.setBounds(130,250,140,20);
rak.setBounds(20,280,100,20);
cmbRak.setBounds(130,280,100,20);
save.setBounds(280,130,70,20);
edit.setBounds(280,160,70,20);
delete.setBounds(280,190,70,20);
reset.setBounds(280,220,70,20);
home.setBounds(290,260,50,40); home.setIcon(new ImageIcon(getClass().getResource("/image/home.png")));
scrollpane.setBounds(10,350,550,100);   
setVisible(true);
setAlwaysOnTop(true);
setResizable(false);     
home.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent bb) {
         Menu zz = new Menu ();
         zz.setVisible(true);
         dispose();
        }});
save.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent bb) {
    if(ftanggal.getText().equals("") || fkode.getText().equals("") || cmbJenis.getSelectedItem().equals("-Pilih-")|| fjudul.getText().equals("")|| fpenerbit.getText().equals("")
            || fpengarang.getText().equals("")|| fstok.getText().equals("")||cmbRak.getSelectedItem().equals("-Pilih-")){
    JOptionPane.showMessageDialog(null, "Data Gagal disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
    
    }
    else{
        String sql="INSERT INTO input_buku (tanggal,kode,genre,judul,penerbit,pengarang,stok,rak) VALUES ('"+ftanggal.getText()+"','"+fkode.getText()+"','"+
            cmbJenis.getSelectedItem()+"','"+fjudul.getText()+"','"+fpenerbit.getText()+"','"+fpengarang.getText()+"','"+fstok.getText()+"','"+cmbRak.getSelectedItem()+"');";
        knek.inputData(sql);
        resetTabel();
        knek.tampil(sqlTampil);
    }
        
        
        }});

reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent bb) {
                reset();
            }
            
        });
delete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent bb) {
                sql = "DELETE FROM input_buku where kode='" + fkode.getText() + "'";
                knek.hapus(sql);
                resetTabel();
                knek.tampil(sqlTampil);
            }
            
        });
edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent bb) {
                
           sql = "UPDATE input_buku SET tanggal='"+ftanggal.getText()+"' ,genre='"+
                cmbJenis.getSelectedItem()+"' ,judul='"+fjudul.getText()+"',penerbit='"+fpenerbit.getText()+
                   "',pengarang='"+fpengarang.getText()+"',stok='"+fstok.getText()+"',rak='"+cmbRak.getSelectedItem()+"' WHERE kode= '"+fkode.getText()+"'";
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

public void klik(MouseEvent me){                                  
  int i = tabel.getSelectedRow();
  DefaultTableModel model = (DefaultTableModel)tabel.getModel();
  ftanggal.setText(model.getValueAt(i, 0).toString());
  fkode.setText(model.getValueAt(i, 1).toString());
  cmbJenis.setSelectedItem(model.getValueAt(i, 2).toString());
  fjudul.setText(model.getValueAt(i, 3).toString());      
  fpenerbit.setText(model.getValueAt(i, 4).toString());    
  fpengarang.setText(model.getValueAt(i, 5).toString());    
  fstok.setText(model.getValueAt(i, 6).toString());     
  cmbRak.setSelectedItem(model.getValueAt(i, 7).toString());
}   
private void reset(){
    ftanggal.setText("");
    fkode.setText("");
    cmbJenis.setSelectedItem("-Pilih-");
    fjudul.setText("");
    fpenerbit.setText("");
    fpengarang.setText("");
    fstok.setText("");
    cmbRak.setSelectedItem("-Pilih-");
}
private void resetTabel(){
    int row=tabel.getRowCount();
    for(int i=0;i<row;i++){
        model.removeRow(0);
    }   
}
}

