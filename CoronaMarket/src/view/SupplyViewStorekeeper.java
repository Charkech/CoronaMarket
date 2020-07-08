package view;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import database.DataBase;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.Panel;
import java.awt.Button;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class SupplyViewStorekeeper extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnSupplyView;
	private JButton btnUpdate;
	private JButton btnAddProduct;
	private JButton btnRemoveProduct;
	private JButton btnOrderProduct;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplyViewStorekeeper frame = new SupplyViewStorekeeper();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField idField;
	private JTextField nameField;
	private JTextField departField;
	private JTextField instockField;
	private JTextField subdepField;
	private JTextField priceField;
	private JButton btnBack;
	/**
	 * Create the frame.
	 */
	public SupplyViewStorekeeper() {
		connection=DataBase.connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 832, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSupplyView = new JLabel("Supply View");
		lblSupplyView.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblSupplyView.setBounds(318, 0, 251, 73);
		contentPane.add(lblSupplyView);
		
	    btnSupplyView = new JButton("Supply View");
	    Image img21= new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnSupplyView.setIcon(new ImageIcon(img21));
	    btnSupplyView.setBackground(UIManager.getColor("Button.background"));
		btnSupplyView.addActionListener(new ActionListener() {
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
		btnSupplyView.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSupplyView.setBounds(10, 84, 173, 42);
		contentPane.add(btnSupplyView);
		
		btnUpdate = new JButton("Update");
		Image img23= new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnUpdate.setIcon(new ImageIcon(img23));
		btnUpdate.setBackground(UIManager.getColor("Button.background"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String query="Update Products set ProductID='"+idField.getText()+"',ProductName='"+nameField.getText()+"',Department='"+departField.getText()+"',InStock='"+instockField.getText()+"',SubDepartment='"+subdepField.getText()+"',Price='"+priceField.getText()+"' where ProductID='"+idField.getText()+"'";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.execute();
				JOptionPane.showMessageDialog(null,"Product Updated Successfully!" );
				pst.close();
			}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(10, 136, 173, 33);
		contentPane.add(btnUpdate);
		
		btnAddProduct = new JButton("Add Product");
		Image img22= new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnAddProduct.setIcon(new ImageIcon(img22));
		btnAddProduct.setBackground(UIManager.getColor("Button.background"));
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into Products (ProductID,ProductName,Department,InStock,SubDepartment,Price) values (?,?,?,?,?,?)";
				//	Statement pst=connection.createStatement();
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, idField.getText());
					pst.setString(2, nameField.getText());
					pst.setString(3, departField.getText());
					pst.setString(4, instockField.getText());
					pst.setString(5, subdepField.getText());
					pst.setString(6, priceField.getText());
				//	ResultSet rs=pst.executeQuery();
					pst.execute();
					JOptionPane.showMessageDialog(null,"Product Added Successfully!");
					pst.close();
//					table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
			}
			});
			
		
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddProduct.setBounds(10, 179, 173, 38);
		contentPane.add(btnAddProduct);
		
		btnRemoveProduct = new JButton("Remove Product");
		Image img24= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnRemoveProduct.setIcon(new ImageIcon(img24));
		btnRemoveProduct.setBackground(UIManager.getColor("Button.background"));
		btnRemoveProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRemoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="delete from Products where ProductID='"+idField.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Product Deleted Successfully!");
					pst.close();
					
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRemoveProduct.setBounds(10, 227, 194, 38);
		contentPane.add(btnRemoveProduct);
		
		btnOrderProduct = new JButton("Order Product");
		Image img25= new ImageIcon(this.getClass().getResource("/order.png")).getImage();
		btnOrderProduct.setIcon(new ImageIcon(img25));
		btnOrderProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into Orders (Status,ProductID,ProductName,Department,Quantity,SubDepartment,Price) values (?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, "Open");
					pst.setString(2,idField.getText());
					pst.setString(3,nameField.getText());
					pst.setString(4, departField.getText());
					pst.setString(5, instockField.getText());
					pst.setString(6, subdepField.getText());
					pst.setString(7, priceField.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Order Sent Successfully!");
					pst.close();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOrderProduct.setBackground(UIManager.getColor("Button.background"));
		btnOrderProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOrderProduct.setBounds(10, 275, 186, 43);
		contentPane.add(btnOrderProduct);
		
		idField = new JTextField();
		idField.setBounds(193, 85, 96, 19);
		contentPane.add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(193, 136, 96, 19);
		contentPane.add(nameField);
		
		departField = new JTextField();
		departField.setColumns(10);
		departField.setBounds(193, 180, 96, 19);
		contentPane.add(departField);
		
		instockField = new JTextField();
		instockField.setColumns(10);
		instockField.setBounds(214, 227, 45, 19);
		contentPane.add(instockField);
		
		subdepField = new JTextField();
		subdepField.setColumns(10);
		subdepField.setBounds(203, 276, 86, 19);
		contentPane.add(subdepField);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(234, 70, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblName.setBounds(228, 113, 32, 13);
		contentPane.add(lblName);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDepartment.setBounds(215, 165, 74, 13);
		contentPane.add(lblDepartment);
		
		JLabel lblInstock = new JLabel("InStock");
		lblInstock.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblInstock.setBounds(214, 214, 45, 13);
		contentPane.add(lblInstock);
		
		JLabel lblSubdepartment = new JLabel("SubDepartment");
		lblSubdepartment.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSubdepartment.setBounds(203, 263, 86, 13);
		contentPane.add(lblSubdepartment);
		
		JButton btnNewButton = new JButton("Exit");
		Image img= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(693, 35, 115, 33);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		Image img27= new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
		btnReset.setIcon(new ImageIcon(img27));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBackground(UIManager.getColor("Button.background"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idField.setText("");
				nameField.setText("");
				departField.setText("");
				instockField.setText("");
				subdepField.setText("");
				priceField.setText("");
			}
		});
		btnReset.setBounds(174, 347, 115, 36);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img5= new ImageIcon(this.getClass().getResource("/products.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img5));
		lblNewLabel_1.setBounds(61, 0, 101, 73);
		contentPane.add(lblNewLabel_1);
		
		priceField = new JTextField();
		priceField.setBounds(203, 318, 86, 19);
		contentPane.add(priceField);
		priceField.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPrice.setBounds(215, 305, 51, 13);
		contentPane.add(lblPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(299, 86, 512, 359);
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
//					table.setModel(DbUtils.resultSetToTableModel(rs));
					while(rs.next()) {
						idField.setText(rs.getString("ProductID"));
						nameField.setText(rs.getString("ProductName"));
						departField.setText(rs.getString("Department"));
						instockField.setText(rs.getString("InStock"));
						subdepField.setText(rs.getString("SubDepartment"));
						priceField.setText(rs.getString("Price"));
					}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		scrollPane.setViewportView(table);
		
		btnBack = new JButton("Back to storekeeper page");
		Image img5t= new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img5t));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(10, 405, 279, 48);
		contentPane.add(btnBack);
	}
	public void setSupplyActionListener(ActionListener actionlistener) {
		this.btnBack.addActionListener(actionlistener);
	}
	
	}

