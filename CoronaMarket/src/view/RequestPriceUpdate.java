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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
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
public class RequestPriceUpdate extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestPriceUpdate frame = new RequestPriceUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField idField;
	private JTextField requestField;
	private JTextField currentField;
	private JTextField nameField;
	private JTextField departField;
	private JTextField subdepartField;
	private JButton btnBack;
	/**
	 * Create the frame.
	 */
	public RequestPriceUpdate() {
		connection=DataBase.connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 882, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Request Price Update");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(294, 10, 386, 54);
		contentPane.add(lblNewLabel);
		
		JButton btnLoad = new JButton("Load Products");
		Image img= new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnLoad.setIcon(new ImageIcon(img));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from Products";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoad.setBackground(UIManager.getColor("Button.background"));
		btnLoad.setBounds(39, 35, 187, 29);
		contentPane.add(btnLoad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 74, 523, 175);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				int row=table.getSelectedRow();
				String ProductID=(table.getModel().getValueAt(row, 0)).toString();
				String query="select * from Products where ProductID='"+ProductID+"'";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
//				table.setModel(DbUtils.resultSetToTableModel(rs));
				while(rs.next()) {
					idField.setText(rs.getString("ProductID"));
					currentField.setText(rs.getString("Price"));
					nameField.setText(rs.getString("ProductName"));
					departField.setText(rs.getString("Department"));
					subdepartField.setText(rs.getString("SubDepartment"));
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		idField = new JTextField();
		idField.setBounds(39, 98, 65, 19);
		contentPane.add(idField);
		idField.setColumns(10);
		
		requestField = new JTextField();
		requestField.setBounds(39, 191, 65, 19);
		contentPane.add(requestField);
		requestField.setColumns(10);
		
		JLabel lblID = new JLabel("ProductID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblID.setBounds(39, 85, 72, 13);
		contentPane.add(lblID);
		
		JLabel lblRequest = new JLabel("Requested Price");
		lblRequest.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRequest.setBounds(19, 171, 105, 13);
		contentPane.add(lblRequest);
		
		JButton btnSubmit = new JButton("Submit");
		Image img13= new ImageIcon(this.getClass().getResource("/send.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(img13));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into PriceUpdateRequests (ProductID,ProductName,Department,SubDepartment,CurrentPrice,RequestedPrice,Status) values (?,?,?,?,?,?,?)";
				//	Statement pst=connection.createStatement();
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,idField.getText());
					pst.setString(2, nameField.getText());
					pst.setString(3, departField.getText());
					pst.setString(4, subdepartField.getText());
					pst.setString(5, currentField.getText());
					pst.setString(6, requestField.getText());
					pst.setString(7,"Open");
				
				//	ResultSet rs=pst.executeQuery();
					pst.execute();
					JOptionPane.showMessageDialog(null,"Price update requested successfully!");
					pst.close();
//					table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBackground(UIManager.getColor("Button.background"));
		btnSubmit.setBounds(39, 220, 187, 29);
		contentPane.add(btnSubmit);
		
		currentField = new JTextField();
		currentField.setColumns(10);
		currentField.setBounds(39, 142, 65, 19);
		contentPane.add(currentField);
		
		JLabel lblCurrentPrice = new JLabel("Current Price");
		lblCurrentPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCurrentPrice.setBounds(19, 128, 105, 13);
		contentPane.add(lblCurrentPrice);
		
		JLabel lblProductname = new JLabel("ProductName");
		lblProductname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductname.setBounds(131, 85, 105, 13);
		contentPane.add(lblProductname);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(131, 98, 95, 19);
		contentPane.add(nameField);
		
		departField = new JTextField();
		departField.setColumns(10);
		departField.setBounds(131, 142, 95, 19);
		contentPane.add(departField);
		
		subdepartField = new JTextField();
		subdepartField.setColumns(10);
		subdepartField.setBounds(131, 191, 95, 19);
		contentPane.add(subdepartField);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartment.setBounds(138, 128, 105, 13);
		contentPane.add(lblDepartment);
		
		JLabel lblSubdepartment = new JLabel("SubDepartment");
		lblSubdepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubdepartment.setBounds(134, 171, 105, 13);
		contentPane.add(lblSubdepartment);
		
		JButton btnExit = new JButton("Exit");
		Image img20= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnExit.setIcon(new ImageIcon(img20));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setBounds(745, 21, 95, 35);
		contentPane.add(btnExit);
		
		btnBack = new JButton("Back to cashier page");
		Image img90= new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img90));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(19, 259, 217, 43);
		contentPane.add(btnBack);
	}
	public void setActionListener(ActionListener actionlistener) {
		this.btnBack.addActionListener(actionlistener);
	}
}
