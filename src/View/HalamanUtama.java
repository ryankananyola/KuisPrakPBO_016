package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HalamanUtama extends JFrame implements ActionListener {
    JLabel header = new JLabel();
    JLabel labelApel = new JLabel("Apel (Rp15.000/kg):");
    JLabel labelJeruk = new JLabel("Jeruk (Rp12.000/kg):");
    JLabel labelMangga = new JLabel("Mangga (Rp20.000/kg):");
    
    JTextField fieldApel = new JTextField("0");
    JTextField fieldJeruk = new JTextField("0");
    JTextField fieldMangga = new JTextField("0");
    
    JButton btnBeli = new JButton("Beli");
    JButton btnLogout = new JButton("Logout");
    
    String username;
    
    public HalamanUtama() {
        this.username = Session.getUsername();
        
        setTitle("Halaman Utama");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.PINK);
        
        header.setText("Selamat Datang, " + username);
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBounds(100, 20, 300, 25);
        add(header);
        
        labelApel.setBounds(50, 70, 150, 25);
        add(labelApel);
        
        fieldApel.setBounds(200, 70, 130, 25);
        add(fieldApel);
        
        labelJeruk.setBounds(50, 110, 150, 25);
        add(labelJeruk);
        
        fieldJeruk.setBounds(200, 110, 130, 25);
        add(fieldJeruk);
        
        labelMangga.setBounds(50, 150, 150, 25);
        add(labelMangga);
        
        fieldMangga.setBounds(200, 150, 130, 25);
        add(fieldMangga);
        
        btnBeli.setBounds(50, 200, 120, 35);
        btnBeli.addActionListener(this);
        add(btnBeli);
        
        btnLogout.setBounds(210, 200, 120, 35);
        btnLogout.addActionListener(this);
        add(btnLogout);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBeli) {
            int jumlahApel = Integer.parseInt(fieldApel.getText());
            int jumlahJeruk = Integer.parseInt(fieldJeruk.getText());
            int jumlahMangga = Integer.parseInt(fieldMangga.getText());
            
            new HalamanPembelian(jumlahApel, jumlahJeruk, jumlahMangga);
            dispose();
        } else if (e.getSource() == btnLogout) {
            dispose();
            new LoginPage();
        }
    }
    
    public static void main(String[] args) {
        new HalamanUtama();
    }
}
