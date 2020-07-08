package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class CashierPage extends JFrame {

	private JPanel contentPane;
	private JButton btnSupplyView;
	private JButton btnRequestUpdate;
	private JButton btnAddItem;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierPage frame = new CashierPage();
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
	public CashierPage() {
		setBackground(Color.WHITE);
		setForeground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCashierPage = new JLabel("Cashier Page");
		lblCashierPage.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCashierPage.setBounds(180, 12, 198, 44);
		contentPane.add(lblCashierPage);
		
		 btnRequestUpdate = new JButton("Request Price Update");
		 Image img33= new ImageIcon(this.getClass().getResource("/request.png")).getImage();
			btnRequestUpdate.setIcon(new ImageIcon(img33));
		 btnRequestUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRequestUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRequestUpdate.setBackground(UIManager.getColor("Button.background"));
		btnRequestUpdate.setBounds(20, 103, 280, 44);
		contentPane.add(btnRequestUpdate);
		
		 btnSupplyView = new JButton("Supply view");
		 Image img34= new ImageIcon(this.getClass().getResource("/list.png")).getImage();
			btnSupplyView.setIcon(new ImageIcon(img34));
		 btnSupplyView.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSupplyView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupplyView.setBackground(UIManager.getColor("Button.background"));
		btnSupplyView.setBounds(21, 157, 279, 36);
		contentPane.add(btnSupplyView);
		
		btnAddItem = new JButton("Request to add new product");
		Image img35= new ImageIcon(this.getClass().getResource("/request.png")).getImage();
		btnAddItem.setIcon(new ImageIcon(img35));
		btnAddItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddItem.setBackground(UIManager.getColor("Button.background"));
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddItem.setBounds(20, 203, 280, 50);
		contentPane.add(btnAddItem);
		
		JLabel lblactions = new JLabel("Cashier Actions :");
		lblactions.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblactions.setBounds(20, 70, 151, 23);
		contentPane.add(lblactions);
		
		JButton btnExit = new JButton("Exit");
		Image img6= new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnExit.setIcon(new ImageIcon(img6));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(424, 22, 106, 36);
		contentPane.add(btnExit);
		
		lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/cashier.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(394, 90, 106, 103);
		contentPane.add(lblNewLabel);
	}
	public void setCashierActions(ActionListener actionListener) {
		this.btnSupplyView.addActionListener(actionListener);
		this.btnAddItem.addActionListener(actionListener);
		this.btnRequestUpdate.addActionListener(actionListener);
	}
	public JButton getBtnSupplyView() {
		return btnSupplyView;
	}
	public JButton getBtnAddItem() {
		return btnAddItem;
	}
	public JButton getBtnRequestUpdate() {
		return btnRequestUpdate;
	}
}
