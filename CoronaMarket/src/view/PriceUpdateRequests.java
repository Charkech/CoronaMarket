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

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PriceUpdateRequests extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idField;
	private JTextField nameField;
	private JTextField departField;
	private JTextField subdepartField;
	private JTextField currentField;
	private JTextField requestedField;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PriceUpdateRequests frame = new PriceUpdateRequests();
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
	public PriceUpdateRequests() {
		connection=DataBase.connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 934, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Price Update Requests");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(340, 0, 393, 65);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(305, 91, 486, 288);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row=table.getSelectedRow();
					String ProductID=(table.getModel().getValueAt(row, 0)).toString();
					String query="Select * from PriceUpdateRequests where ProductID='"+ProductID+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						idField.setText(rs.getString("ProductID"));
						nameField.setText(rs.getString("ProductName"));
						departField.setText(rs.getString("Department"));
						requestedField.setText(rs.getString("RequestedPrice"));
						subdepartField.setText(rs.getString("SubDepartment"));
						currentField.setText(rs.getString("CurrentPrice"));
					}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
			
		});
		scrollPane.setViewportView(table);
		
		idField = new JTextField();
		idField.setBounds(114, 101, 161, 29);
		contentPane.add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(114, 152, 161, 29);
		contentPane.add(nameField);
		
		departField = new JTextField();
		departField.setColumns(10);
		departField.setBounds(114, 198, 161, 29);
		contentPane.add(departField);
		
		subdepartField = new JTextField();
		subdepartField.setColumns(10);
		subdepartField.setBounds(114, 241, 161, 29);
		contentPane.add(subdepartField);
		
		currentField = new JTextField();
		currentField.setColumns(10);
		currentField.setBounds(114, 290, 161, 29);
		contentPane.add(currentField);
		
		requestedField = new JTextField();
		requestedField.setColumns(10);
		requestedField.setBounds(114, 334, 161, 29);
		contentPane.add(requestedField);
		
		JButton btnAccept = new JButton("Accept");
		Image img94= new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnAccept.setIcon(new ImageIcon(img94));
		btnAccept.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAccept.setBackground(UIManager.getColor("Button.background"));
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row=table.getSelectedRow();
					String ProductID=(table.getModel().getValueAt(row, 0)).toString();
					String Price=(table.getModel().getValueAt(row, 5)).toString();
					String query="update PriceUpdateRequests set Status=? where ProductID='"+ProductID+"'";
					String query2="update Products set Price='"+Price+"' where ProductID='"+ProductID+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					PreparedStatement pst2=connection.prepareStatement(query2);
					pst.setString(1, "Accepted");
					pst.execute();
					pst2.execute();
					JOptionPane.showMessageDialog(null,"Product price update was accepted and changed!");
					pst.close();
					pst2.close();
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnAccept.setBounds(10, 62, 119, 35);
		contentPane.add(btnAccept);
		
		JButton btnReject = new JButton("Reject");
		Image img92= new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
		btnReject.setIcon(new ImageIcon(img92));
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row=table.getSelectedRow();
					String ProductID=(table.getModel().getValueAt(row, 0)).toString();
					String Price=(table.getModel().getValueAt(row, 5)).toString();
					String query="update PriceUpdateRequests set Status=? where ProductID='"+ProductID+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, "Rejected");
					pst.execute();
					JOptionPane.showMessageDialog(null,"Product price update was rejected!");
					pst.close();
					
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnReject.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReject.setBackground(UIManager.getColor("Button.background"));
		btnReject.setBounds(156, 62, 119, 35);
		contentPane.add(btnReject);
		
		JButton btnLoad = new JButton("Load Requests");
		Image img91= new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnLoad.setIcon(new ImageIcon(img91));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from PriceUpdateRequests";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			
		});
		btnLoad.setBackground(UIManager.getColor("Button.background"));
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoad.setBounds(10, 10, 265, 42);
		contentPane.add(btnLoad);
		
		JLabel lblNewLabel_1 = new JLabel("ProductID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 108, 65, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ProductName");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 159, 90, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Department");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 206, 84, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("SubDepartment");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(10, 249, 99, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("CurrentPrice");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(10, 298, 94, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("RequestedPrice");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5.setBounds(10, 342, 102, 13);
		contentPane.add(lblNewLabel_1_5);
		
		JButton btnExit = new JButton("Exit");
		Image img93= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnExit.setIcon(new ImageIcon(img93));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setBounds(769, 23, 141, 42);
		contentPane.add(btnExit);
		
		btnBack = new JButton("Back to manager page");
		Image img95= new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img95));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(16, 373, 279, 50);
		contentPane.add(btnBack);
	}
	public void setListeners(ActionListener actionlistener) {
		this.btnBack.addActionListener(actionlistener);
	}
}
