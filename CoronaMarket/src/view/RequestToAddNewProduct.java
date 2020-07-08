package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DataBase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class RequestToAddNewProduct extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField departField;
	private JTextField subdepartField;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestToAddNewProduct frame = new RequestToAddNewProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	/**
	 * Create the frame.
	 */
	public RequestToAddNewProduct() {
		connection=DataBase.connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 625, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Request to add new product");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(50, 0, 465, 67);
		contentPane.add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(282, 100, 160, 29);
		contentPane.add(nameField);
		
		departField = new JTextField();
		departField.setColumns(10);
		departField.setBounds(282, 156, 160, 30);
		contentPane.add(departField);
		
		subdepartField = new JTextField();
		subdepartField.setColumns(10);
		subdepartField.setBounds(282, 219, 160, 26);
		contentPane.add(subdepartField);
		
		JLabel lblNewLabel_1 = new JLabel("ProductName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(297, 77, 102, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Department");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(292, 139, 83, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("SubDepartment");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(292, 196, 102, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnSend = new JButton("Submit");
		Image img40= new ImageIcon(this.getClass().getResource("/send.png")).getImage();
		btnSend.setIcon(new ImageIcon(img40));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into RequestNewItem (ProductName,Department,SubDepartment) values (?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,nameField.getText());
					pst.setString(2, departField.getText());
					pst.setString(3, subdepartField.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null,"A request to add the product was sent successfully!");
					pst.close();
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSend.setBounds(282, 255, 168, 43);
		contentPane.add(btnSend);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img41= new ImageIcon(this.getClass().getResource("/bigreq.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img41));
		lblNewLabel_2.setBounds(452, 77, 149, 187);
		contentPane.add(lblNewLabel_2);
		
		JButton btnExit = new JButton("Exit");
		Image img42= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnExit.setIcon(new ImageIcon(img42));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(512, 15, 89, 43);
		contentPane.add(btnExit);
		
		btnBack = new JButton("Back to cashier page");
		Image img43= new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img43));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(10, 98, 262, 54);
		contentPane.add(btnBack);
	}
	public void setActionListener(ActionListener actionlistener) {
		this.btnBack.addActionListener(actionlistener);
	}
}
