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

public class SupplyViewCashier extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnSupplyView;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplyViewCashier frame = new SupplyViewCashier();
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
	public SupplyViewCashier() {
		connection=DataBase.connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 832, 442);
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
		Image img27= new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
		
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
		scrollPane.setBounds(321, 86, 490, 294);
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
		
		btnBack = new JButton("Back to cashier page");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Image imgt4= new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(imgt4));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(10, 342, 233, 53);
		contentPane.add(btnBack);
	}
	public void setlistener(ActionListener actionlistener) {
		this.btnBack.addActionListener(actionlistener);
	}
}
