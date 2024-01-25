package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.LoginController;

public class LoginView extends JFrame {
    private JFrame frame;
    private JPanel leftPanel, rightPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel titleLabel1, titleLabel2, usernameLabel, passwordLabel, loginLabel;
    private JButton loginButton;

    private final int WIDTH = 1440, HEIGHT = 1024;

    Color whiteColor = new Color(235, 235, 235);
    Color blackColor = new Color(0, 1, 1);
    Color orangeColor = new Color(245, 73, 1);
    Color grayColor = new Color(200, 200, 200);

    private Font fontBold40, fontBold32, fontRegular;

    public LoginView(LoginController loginController) {
        File fontPathBold = new File("src/font/Poppins-Bold.ttf");
        File fontPathRegular = new File("src/font/Poppins-Regular.ttf");
        try {
            fontBold40 = Font.createFont(Font.TRUETYPE_FONT, fontPathBold).deriveFont(40f);
            fontBold32 = Font.createFont(Font.TRUETYPE_FONT, fontPathBold).deriveFont(32f);
            fontRegular = Font.createFont(Font.TRUETYPE_FONT, fontPathRegular).deriveFont(20f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        frame = new JFrame("Management Gudang Sepatu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);

        leftPanel = new JPanel();
        leftPanel.setSize(500, HEIGHT);
        frame.add(leftPanel);
        leftComponents(leftPanel);

        rightPanel = new JPanel();
        rightPanel.setSize(500 - WIDTH, HEIGHT);
        frame.add(rightPanel);
        rightComponents(rightPanel, loginController);

        frame.setVisible(true);
    }

    private void leftComponents(JPanel leftPanel) {
        leftPanel.setLayout(null);
        leftPanel.setBackground(blackColor);

        titleLabel1 = new JLabel("Management");
        titleLabel1.setForeground(whiteColor);
        titleLabel1.setFont(fontBold40);
        titleLabel1.setBounds(100, 452, 300, 60);

        titleLabel2 = new JLabel("Gudang Sepatu");
        titleLabel2.setForeground(whiteColor);
        titleLabel2.setFont(fontBold40);
        titleLabel2.setBounds(80, 510, 340, 60);

        leftPanel.add(titleLabel1);
        leftPanel.add(titleLabel2);
    }

    private void rightComponents(JPanel rightPanel, LoginController loginController) {
        rightPanel.setLayout(null);
        rightPanel.setBackground(whiteColor);

        loginLabel = new JLabel("Login to your account");
        loginLabel.setForeground(blackColor);
        loginLabel.setFont(fontBold32);
        loginLabel.setBounds(675, 262, 360, 48);

        usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(blackColor);
        usernameLabel.setFont(fontRegular);
        usernameLabel.setBounds(676, 326, 110, 30);

        passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(blackColor);
        passwordLabel.setFont(fontRegular);
        passwordLabel.setBounds(676, 484, 100, 30);

        Border newBorder = BorderFactory.createEmptyBorder(5, 15, 5, 5);
        usernameField = new JTextField();
        usernameField.setBackground(grayColor);
        usernameField.setFont(fontRegular);
        usernameField.setBounds(676, 364, 552, 80);
        usernameField.setBorder(newBorder);

        passwordField = new JPasswordField();
        passwordField.setBackground(grayColor);
        passwordField.setBounds(676, 530, 552, 80);
        passwordField.setBorder(newBorder);

        loginButton = new JButton("LOGIN");
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setBackground(orangeColor);
        loginButton.setForeground(blackColor);
        loginButton.setFont(fontBold32);
        loginButton.setBounds(676, 690, 552, 80);

        loginButton.addActionListener((event -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String auth = loginController.authentication(username, password);

            if (auth != null) {
                if (auth.equals("admin")) {
                    new AdminView();
                    frame.dispose();
                } else if (auth.equals("user")) {
                    JOptionPane.showMessageDialog(frame, "Login As User");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Login Gagal!");
            }

        }));

        rightPanel.add(loginLabel);
        rightPanel.add(usernameLabel);
        rightPanel.add(passwordLabel);
        rightPanel.add(usernameField);
        rightPanel.add(passwordField);
        rightPanel.add(loginButton);
    }
}
