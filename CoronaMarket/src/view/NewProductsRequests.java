package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DataBase;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewProductsRequests extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField nameField;
	private JTextField departField;
	private JTextField instockField;
	private JTextField subdepartField;
	private JTextField priceField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewProductsRequests frame = new NewProductsRequests();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JButton btnLoad;
	private JButton btnSend;
	private JButton btnBack;
	private JButton btnExit;
	private JLabel lblNewLabel_2;
	/**
	 * Create the frame.
	 */
	public NewProductsRequests() {
		connection=DataBase.connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 997, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List of requested products to add ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(264, 10, 595, 61);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(258, 101, 525, 258);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				int row=table.getSelectedRow();
				String ProductName=(table.getModel().getValueAt(row, 0)).toString();
				String query="select * from RequestNewItem where ProductName='"+ProductName+"'";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					nameField.setText(rs.getString("ProductName"));
					departField.setText(rs.getString("Department"));
					subdepartField.setText(rs.getString("SubDepartment"));
				}} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		nameField = new JTextField();
		nameField.setBounds(68, 106, 141, 30);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		departField = new JTextField();
		departField.setColumns(10);
		departField.setBounds(68, 158, 141, 30);
		contentPane.add(departField);
		
		instockField = new JTextField();
		instockField.setColumns(10);
		instockField.setBounds(68, 213, 141, 30);
		contentPane.add(instockField);
		
		subdepartField = new JTextField();
		subdepartField.setColumns(10);
		subdepartField.setBounds(68, 269, 141, 30);
		contentPane.add(subdepartField);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(68, 324, 141, 30);
		contentPane.add(priceField);
		
		JLabel lblNewLabel_1 = new JLabel("ProductName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(92, 93, 92, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Department");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(92, 146, 92, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("InStock");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(107, 198, 58, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("SubDepartment");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(92, 256, 117, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Price");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(107, 309, 92, 13);
		contentPane.add(lblNewLabel_1_4);
		
		btnLoad = new JButton("Load requests");
		Image img60= new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnLoad.setIcon(new ImageIcon(img60));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from RequestNewItem";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					while(rs.next()) {
						nameField.setText(rs.getString("ProductName"));
						departField.setText(rs.getString("Department"));
						subdepartField.setText(rs.getString("SubDepartment"));
					}} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnLoad.setBackground(UIManager.getColor("Button.background"));
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoad.setBounds(37, 10, 200, 61);
		contentPane.add(btnLoad);
		
		btnSend = new JButton("Submit");
		Image img61= new ImageIcon(this.getClass().getResource("/send.png")).getImage();
		btnSend.setIcon(new ImageIcon(img61));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row=table.getSelectedRow();
					String ProductName=(table.getModel().getValueAt(row, 0)).toString();
					String query="insert into Products (ProductName,Department,InStock,SubDepartment,Price) values (?,?,?,?,?)";
					String query2="delete from RequestNewItem where ProductName='"+ProductName+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					PreparedStatement pst2=connection.prepareStatement(query2);
					pst.setString(1, nameField.getText());
					pst.setString(2, departField.getText());
					pst.setString(3, instockField.getText());
					pst.setString(4, subdepartField.getText());
					pst.setString(5, priceField.getText());
					pst.execute();
					pst2.execute();
					JOptionPane.showMessageDialog(null,"Product added successfully and deleted from the list!");
					pst.close();
					pst2.close();
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnSend.setBackground(UIManager.getColor("Button.background"));
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSend.setBounds(20, 364, 237, 51);
		contentPane.add(btnSend);
		
		btnBack = new JButton("Back to manager page");
		Image img62= new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img62));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(20, 425, 279, 61);
		contentPane.add(btnBack);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Image img64= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnExit.setIcon(new ImageIcon(img64));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(856, 66, 117, 40);
		contentPane.add(btnExit);
		
		lblNewLabel_2 = new JLabel("");
		Image img66= new ImageIcon(this.getClass().getResource("/bigreq.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img66));
		lblNewLabel_2.setBounds(814, 346, 159, 162);
		contentPane.add(lblNewLabel_2);
	}
	public void setlistener(ActionListener actionlistener) {
		this.btnBack.addActionListener(actionlistener);
	}
}
