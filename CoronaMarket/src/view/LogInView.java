package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.UIManager;

public class LogInView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lbUserName;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnClear;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnNewButtonLogIn;
	private JButton btnLoginBTN;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInView frame = new LogInView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogIn = new JLabel("LogIn Page");
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 49));
		lblLogIn.setBounds(72, 9, 291, 75);
		contentPane.add(lblLogIn);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(172, 117, 86, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		lbUserName = new JLabel("Username:");
		lbUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbUserName.setBounds(53, 120, 109, 14);
		contentPane.add(lbUserName);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(53, 160, 109, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 160, 86, 17);
		contentPane.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(53, 82, 337, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(53, 189, 337, 2);
		contentPane.add(separator_1);
		
		btnClear = new JButton("Clear");
		Image img32= new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
		btnClear.setIcon(new ImageIcon(img32));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBackground(UIManager.getColor("Button.background"));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				passwordField.setText(null);
			}
		});
		btnClear.setBounds(272, 215, 135, 38);
		contentPane.add(btnClear);
		
		btnLoginBTN = new JButton("Login");
		btnLoginBTN.setBackground(UIManager.getColor("Button.background"));
		btnLoginBTN.setFont(new Font("Tahoma", Font.BOLD, 14));
		Image img1= new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLoginBTN.setIcon(new ImageIcon(img1));
		btnLoginBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoginBTN.setBounds(112, 215, 146, 38);
		contentPane.add(btnLoginBTN);
		
		btnExit = new JButton("Exit");
		Image img= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnExit.setIcon(new ImageIcon(img));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(373, 23, 103, 38);
		contentPane.add(btnExit);
		
		JLabel lblLogin = new JLabel("");
		Image img2= new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblLogin.setIcon(new ImageIcon(img2));
		lblLogin.setBounds(312, 94, 153, 111);
		contentPane.add(lblLogin);
	}
	public String getUserName() {
		return this.txtUsername.getText();
	}
	public String getPassword() {
		char [] pass=passwordField.getPassword();
		StringBuilder sb = new StringBuilder();
		for (Character ch: pass) {
			sb.append(ch);
		}
		String string=sb.toString();
		return string;
	}
	public void displayMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	public void setLogInAL(ActionListener actionListener) {
		this.btnLoginBTN.addActionListener(actionListener);
		this.btnClear.addActionListener(actionListener);
	
	}

	public JButton getBtnClear() {
		return btnClear;
	}

	public JButton getBtnLoginBTN() {
		return btnLoginBTN;
	}

	public JButton getBtnExit() {
		return btnExit;
	}
}
