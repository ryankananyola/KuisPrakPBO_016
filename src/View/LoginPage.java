package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {
    
    JLabel Header = new JLabel("LOGIN");
    JLabel LabelUsername = new JLabel("Username : ");
    JLabel LabelPassword = new JLabel("Password : ");
    
    JTextField inputUsername = new JTextField();
    JPasswordField inputPassword = new JPasswordField();
    
    JButton tombolLogin = new JButton("Login");
    JButton tombolReset = new JButton("Reset");

    private static final String USERNAME_VALID = "Ayudya Prameswari";
    private static final String PASSWORD_VALID = "123230016";
    
    public LoginPage() {
        setVisible(true);
        setSize(400, 350);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(Header);
        Header.setBounds(160, 30, 440, 24);
        Header.setFont(Header.getFont().deriveFont(20.0f));
        add(LabelUsername);
        LabelUsername.setBounds(40, 80, 440, 24);
        add(LabelPassword);
        LabelPassword.setBounds(40, 120, 440, 24);
        
        add(inputUsername);
        inputUsername.setBounds(120, 80, 220, 24);
        add(inputPassword);
        inputPassword.setBounds(120, 120, 220, 24);
        
        add(tombolLogin);
        tombolLogin.setBounds(40, 180, 300, 30);
        tombolLogin.addActionListener(this);

        add(tombolReset);
        tombolReset.setBounds(40, 220, 300, 30);
        tombolReset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolReset) {
            inputUsername.setText("");
            inputPassword.setText("");
        } else if (e.getSource() == tombolLogin) {
            try {
                String username = inputUsername.getText();
                String password = new String(inputPassword.getPassword());

                if (username.isEmpty() && password.isEmpty()) {
                    throw new Exception("Username dan Password Belum Diisi");
                } else if (username.isEmpty()) {
                    throw new Exception("Username belum diisi");
                } else if (password.isEmpty()) {
                    throw new Exception("Password belum diisi");
                }

                if (username.equals(USERNAME_VALID) && password.equals(PASSWORD_VALID)) {
                    Session.setUsername(username);
                    new HalamanUtama();
                    this.dispose();
                } else {
                    throw new Exception("Username atau Password salah");
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        }
    }
}
