package View;

import java.awt.Color;
import javax.swing.*;

public class HalamanPembelian extends JFrame {
    
    public HalamanPembelian(int jumlahApel, int jumlahJeruk, int jumlahMangga) {
        setTitle("Halaman Pembelian");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Color.PINK);
        
        int hargaApel = 15000 * jumlahApel;
        int hargaJeruk = 12000 * jumlahJeruk;
        int hargaMangga = 20000 * jumlahMangga;
        int subtotal = hargaApel + hargaJeruk + hargaMangga;
        int pajak = (int) (subtotal * 0.1);
        int total = subtotal + pajak;
        
        JLabel labelApel = new JLabel("Apel: " + jumlahApel + " kg x Rp15.000 = Rp" + hargaApel);
        labelApel.setBounds(20, 20, 300, 20);
        add(labelApel);
        
        JLabel labelJeruk = new JLabel("Jeruk: " + jumlahJeruk + " kg x Rp12.000 = Rp" + hargaJeruk);
        labelJeruk.setBounds(20, 50, 300, 20);
        add(labelJeruk);
        
        JLabel labelMangga = new JLabel("Mangga: " + jumlahMangga + " kg x Rp20.000 = Rp" + hargaMangga);
        labelMangga.setBounds(20, 80, 300, 20);
        add(labelMangga);
        
        JLabel labelSubtotal = new JLabel("Subtotal: Rp" + subtotal);
        labelSubtotal.setBounds(20, 130, 300, 20);
        add(labelSubtotal);
        
        JLabel labelPajak = new JLabel("Pajak (10%): Rp" + pajak);
        labelPajak.setBounds(20, 160, 300, 20);
        add(labelPajak);
        
        JLabel labelTotal = new JLabel("Total Harga: Rp" + total);
        labelTotal.setBounds(20, 190, 300, 20);
        add(labelTotal);
        
        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBounds(100, 240, 200, 30);
        btnKembali.addActionListener(e -> {
            new HalamanUtama();
            dispose();
        });
        add(btnKembali);
        
        setVisible(true);
    }
}
