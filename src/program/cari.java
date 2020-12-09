package program;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class cari {
    public static void main(String[] args) {
        
    
       
pencarian cab = new pencarian();
cab.setVisible(true);
    
    }
}

class pencarian extends JFrame {
public String sql = ""; 
String carib;

final JTextField Fcarib = new JTextField ();
JLabel car = new JLabel (" CARI BUKU ");
JButton search = new JButton(); 
JButton home = new JButton();
JButton reset = new JButton("Reset");
 DefaultTableModel model;
     JTable tabel;
     JScrollPane scrollpane;
     
public pencarian (){
    Object kolom[] = {"Tanggal", " Kode ", " Genre ", " Judul ", " Penerbit ", " Pengarang ",
            " Stok ", " Rak "};
    model = new DefaultTableModel(kolom,0);
    tabel = new JTable (model);
    tampil();
    scrollpane = new JScrollPane (tabel);
        
        this.getContentPane().setBackground(Color.pink);
        setTitle (" PENCARIAN ");  
        setDefaultCloseOperation(3);  
        setSize(600,650);  
        setAlwaysOnTop(true);
        setResizable(false);
        setLayout(null);  
        add(Fcarib);
        add(search);
        add(scrollpane);
        add(home); 
        add(car);
        add(reset);
        car.setBounds(20,20, 160, 30); car.setFont(new Font("Serif", Font.BOLD, 25));
         reset.setBounds(480,70, 100, 20);
         Fcarib.setBounds(200,20, 250, 30);
          search.setBounds(480, 20, 40, 35); search.setIcon(new ImageIcon(getClass().getResource("/image/search.png")));
           home.setBounds(530, 20, 50, 40); home.setIcon(new ImageIcon(getClass().getResource("/image/home.png")));
             scrollpane.setBounds(20,100,550,500);
           
        home.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent bb) {
         dispose();
        }});
         reset.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent bb) {
          reset();
                tampil();
        }});
        search.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent bb) {
            cari();
      
            
            
        }});
}
private void tampil(){
    try {
        int row = tabel.getRowCount();
        for(int a=0; a<row; a++){ // untuk menampilkan semua isi data base
            model.removeRow(0);
        }
        Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/project_member","root","");
        ResultSet rs = cn.createStatement().executeQuery("select * from input_buku");
        while(rs.next()){
        String data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)};
        model.addRow(data);
        }
        } catch (SQLException ex) {
            //Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
}

private void cari(){
    int i=1;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/project_member","root","");

       sql = "select * from input_buku where kode  like '%" + Fcarib.getText() + "%' or judul like '%"+Fcarib.getText()
               + "%' or pengarang like '%"+Fcarib.getText() + "%' or penerbit like '%"+Fcarib.getText()+ "%' or genre like '%"+Fcarib.getText() +"%'";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        DefaultTableModel model = (DefaultTableModel)tabel.getModel();
            model.setRowCount(0);
            while (rs.next()) {
            
            String data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)};
            model.addRow(data);
        i++;
        }
        javax.swing.JOptionPane.showMessageDialog(null, "Data Ditemukan");
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Gagal Proses Cari Data "+e);
    }
    catch(ClassNotFoundException e){
        javax.swing.JOptionPane.showMessageDialog(null, "Gagal  ");
        
    }
}

private void reset(){
    Fcarib.setText("");


}
}