package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DataBase;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
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

public class RefundsForDamagedSupply extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RefundsForDamagedSupply frame = new RefundsForDamagedSupply();
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
	public RefundsForDamagedSupply() {
		connection=DataBase.connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 767, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Refunds for damaged/bad supply");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(60, 3, 585, 62);
		contentPane.add(lblNewLabel);
		
		JButton btnLoad = new JButton("Load refunds");
		Image img72= new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnLoad.setIcon(new ImageIcon(img72));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from Refunds";
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
		btnLoad.setBounds(10, 82, 247, 46);
		contentPane.add(btnLoad);
		
		btnBack = new JButton("Back to storekeeper page");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Image img71= new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img71));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(10, 152, 298, 55);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(324, 82, 419, 293);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnExit = new JButton("Exit");
		Image img70= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnExit.setIcon(new ImageIcon(img70));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(641, 21, 102, 40);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img73= new ImageIcon(this.getClass().getResource("/order2.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img73));
		lblNewLabel_1.setBounds(106, 230, 109, 125);
		contentPane.add(lblNewLabel_1);
	}
	public void refundsListener(ActionListener actionlistener) {
		this.btnBack.addActionListener(actionlistener);
	}
}
