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

        header.setText("Selamat Datang, " + username);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBounds(50, 20, 300, 25);
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

        btnBeli.setBounds(50, 200, 280, 30);
        btnBeli.addActionListener(this);
        add(btnBeli);

        btnLogout.setBounds(50, 240, 280, 30);
        btnLogout.addActionListener(this);
        add(btnLogout);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBeli) {
            try {
                int jumlahApel = validasiInput(fieldApel.getText());
                int jumlahJeruk = validasiInput(fieldJeruk.getText());
                int jumlahMangga = validasiInput(fieldMangga.getText());

                new HalamanPembelian(jumlahApel, jumlahJeruk, jumlahMangga);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Harap masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnLogout) {
            dispose();
            new LoginPage();
        }
    }

    private int validasiInput(String input) throws NumberFormatException, IllegalArgumentException {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input tidak boleh kosong!");
        }

        int nilai = Integer.parseInt(input);

        if (nilai < 0) {
            throw new IllegalArgumentException("Input tidak boleh negatif!");
        }

        return nilai;
    }

    public static void main(String[] args) {
        new HalamanUtama();
    }
}
