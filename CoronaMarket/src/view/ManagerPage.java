package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class ManagerPage extends JFrame {

	private JPanel contentPane;
	private JButton btnSupplyView;
	private JButton btnSalesPro;
	private JButton btnOrdersPage;
	private JButton btnViewRequests;
	private JButton btnUpdate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPage frame = new ManagerPage();
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
	public ManagerPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 543, 392);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManagerPage = new JLabel("Manager Page");
		lblManagerPage.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblManagerPage.setBounds(155, 2, 208, 49);
		contentPane.add(lblManagerPage);
		
		btnSupplyView = new JButton("Supply View");
		Image img19= new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		btnSupplyView.setIcon(new ImageIcon(img19));
		btnSupplyView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupplyView.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSupplyView.setBackground(UIManager.getColor("Button.background"));
		btnSupplyView.setBounds(10, 81, 208, 39);
		contentPane.add(btnSupplyView);
		
		btnSalesPro = new JButton("Sales profit and loss");
		Image img30= new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		btnSalesPro.setIcon(new ImageIcon(img30));
		btnSalesPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalesPro.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalesPro.setBackground(UIManager.getColor("Button.background"));
		btnSalesPro.setBounds(10, 133, 246, 45);
		contentPane.add(btnSalesPro);
		
		JLabel lblmanageractions = new JLabel("Manager Actions:");
		lblmanageractions.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmanageractions.setBounds(20, 48, 151, 23);
		contentPane.add(lblmanageractions);
		
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
		btnExit.setBounds(387, 16, 118, 39);
		contentPane.add(btnExit);
		
		btnOrdersPage = new JButton("View Orders");
		Image img31= new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		btnOrdersPage.setIcon(new ImageIcon(img31));
		btnOrdersPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOrdersPage.setBackground(UIManager.getColor("Button.background"));
		btnOrdersPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrdersPage.setBounds(10, 188, 218, 39);
		contentPane.add(btnOrdersPage);
		
		JLabel lblNewLabel = new JLabel("");
		Image img3= new ImageIcon(this.getClass().getResource("/manager.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img3));
		lblNewLabel.setBounds(361, 83, 106, 160);
		contentPane.add(lblNewLabel);
		
		btnViewRequests = new JButton("View new products requests");
		Image imgt3= new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		btnViewRequests.setIcon(new ImageIcon(imgt3));
		btnViewRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewRequests.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewRequests.setBackground(UIManager.getColor("Button.background"));
		btnViewRequests.setBounds(10, 237, 286, 49);
		contentPane.add(btnViewRequests);
		
		btnUpdate = new JButton("View price update requests");
		Image img98= new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		btnUpdate.setIcon(new ImageIcon(img98));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBackground(UIManager.getColor("Button.background"));
		btnUpdate.setBounds(10, 296, 286, 49);
		contentPane.add(btnUpdate);
	}
	public void setManagerActions(ActionListener actionlistener) {
		this.btnSalesPro.addActionListener(actionlistener);
		this.btnSupplyView.addActionListener(actionlistener);
		this.btnOrdersPage.addActionListener(actionlistener);
		this.btnViewRequests.addActionListener(actionlistener);
		this.btnUpdate.addActionListener(actionlistener);
	}
	public JButton getUpdateBtn() {
		return btnUpdate;
	}
	public JButton getSupplyViewBtn() {
		return btnSupplyView;
	}
	public JButton getSalesProBtn() {
		return btnSalesPro;
	}
	public JButton getOrdersPageBtn() {
		return btnOrdersPage;
	}
	public JButton getViewRequestBtn() {
		return btnViewRequests;
	}
}
