package view;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import database.DataBase;
import javax.swing.UIManager;
public class SalesProfitLoss extends JFrame {
	
	private JPanel contentPane;
	private JButton btnBackToManager;
	private JTable table1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesProfitLoss frame = new SalesProfitLoss();
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
	public SalesProfitLoss() {
		connection=DataBase.connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSales = new JLabel("Sales Profit and Loss");
		lblSales.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSales.setBounds(158, 0, 361, 64);
		contentPane.add(lblSales);
		
		JButton btnLoad = new JButton("Load Details");
		Image img11= new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnLoad.setIcon(new ImageIcon(img11));
		btnLoad.setBackground(UIManager.getColor("Button.background"));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from ProfitLoss";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table1.setModel(DbUtils.resultSetToTableModel(rs));
					
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			
		});
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoad.setBounds(10, 73, 233, 44);
		contentPane.add(btnLoad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 78, 361, 176);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		
		JButton btnExit = new JButton("Exit");
		Image img= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnExit.setIcon(new ImageIcon(img));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setBounds(507, 30, 107, 34);
		contentPane.add(btnExit);
		
		btnBackToManager = new JButton("Back to manager page");
		Image img12= new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBackToManager.setIcon(new ImageIcon(img12));
		btnBackToManager.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBackToManager.setBackground(UIManager.getColor("Button.background"));
		btnBackToManager.setBounds(10, 127, 233, 44);
		contentPane.add(btnBackToManager);
		
		}
		public void setListenerProfitLoss(ActionListener actionlistener) {
			this.btnBackToManager.addActionListener(actionlistener);
	}
}
