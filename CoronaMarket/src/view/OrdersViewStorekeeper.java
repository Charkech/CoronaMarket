package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import database.DataBase;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class OrdersViewStorekeeper extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnFinishOrder;
	private JButton btnNewButton;
	private JButton btnBack;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdersViewStorekeeper frame = new OrdersViewStorekeeper();
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
	Connection connection=null;
	private JTextField orderidField;
	private JTextField statusField;
	private JLabel lblNewLabel_2;
	private JTextField quantityField;
	public OrdersViewStorekeeper() {
		connection=DataBase.connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 903, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Orders Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel.setBounds(338, 2, 241, 59);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 71, 615, 237);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row=table.getSelectedRow();
					String OrderID=(table.getModel().getValueAt(row, 0)).toString();
					String query="select * from Orders where OrderID='"+OrderID+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
//					table.setModel(DbUtils.resultSetToTableModel(rs));
					while(rs.next()) {
						orderidField.setText(rs.getString("OrderID"));
						statusField.setText(rs.getString("Status"));
						quantityField.setText(rs.getString("Quantity"));
					}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Load Orders");
		Image img14= new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img14));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from Orders";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(11, 44, 162, 21);
		contentPane.add(btnNewButton);
		
		orderidField = new JTextField();
		orderidField.setBounds(66, 102, 107, 19);
		contentPane.add(orderidField);
		orderidField.setColumns(10);
		
		statusField = new JTextField();
		statusField.setColumns(10);
		statusField.setBounds(66, 131, 107, 19);
		contentPane.add(statusField);
		
		JLabel lblNewLabel_1 = new JLabel("OrderID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(11, 105, 64, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Status");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(11, 134, 64, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnExit = new JButton("Exit");
		Image img= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnExit.setIcon(new ImageIcon(img));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(748, 26, 107, 35);
		contentPane.add(btnExit);
		
		btnFinishOrder = new JButton("Finish Order");
		Image img17= new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnFinishOrder.setIcon(new ImageIcon(img17));
		btnFinishOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFinishOrder.setBackground(UIManager.getColor("Button.background"));
		btnFinishOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row=table.getSelectedRow();
					String OrderID=(table.getModel().getValueAt(row, 0)).toString();
					String Quantity=(table.getModel().getValueAt(row, 5 )).toString();
					String ProductID=(table.getModel().getValueAt(row, 2)).toString();
					String query2="Update Products set InStock=InStock+'"+Quantity+"' where ProductID='"+ProductID+"'";
					String query="Update Orders SET Status='Finished' where OrderID='"+OrderID+"'";
					PreparedStatement pst2=connection.prepareStatement(query2);
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					pst2.execute();
					JOptionPane.showMessageDialog(null, "Order Finished Successfully!");
					pst.close();
					pst2.close();
					
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnFinishOrder.setBounds(11, 159, 162, 21);
		contentPane.add(btnFinishOrder);
		
		lblNewLabel_2 = new JLabel("");
		Image img18= new ImageIcon(this.getClass().getResource("/order2.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img18));
		lblNewLabel_2.setBounds(48, 185, 107, 123);
		contentPane.add(lblNewLabel_2);
		
		quantityField = new JTextField();
		quantityField.setColumns(10);
		quantityField.setBounds(66, 75, 107, 19);
		contentPane.add(quantityField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantity");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(11, 79, 64, 13);
		contentPane.add(lblNewLabel_1_2);
		
		btnBack = new JButton("Back to storekeeper page");
		Image img1t8= new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img1t8));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(11, 315, 264, 57);
		contentPane.add(btnBack);
	}
	public void setOrderAction(ActionListener actionlistener) {
		this.btnBack.addActionListener(actionlistener);
	}
}
