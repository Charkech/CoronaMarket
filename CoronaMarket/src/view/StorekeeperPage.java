package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class StorekeeperPage extends JFrame {

	private JPanel contentPane;
	private JButton btnSupplyview;
	private JButton btnRefunds;
	private JButton btnViewOrders;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StorekeeperPage frame = new StorekeeperPage();
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
	public StorekeeperPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 566, 332);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStorekeeperPage = new JLabel("Storekeeper Page");
		lblStorekeeperPage.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblStorekeeperPage.setBounds(135, 1, 268, 52);
		contentPane.add(lblStorekeeperPage);
		
		btnSupplyview = new JButton("Supply View");
		Image img37= new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		btnSupplyview.setIcon(new ImageIcon(img37));
		btnSupplyview.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSupplyview.setBackground(UIManager.getColor("Button.background"));
		btnSupplyview.setBounds(25, 170, 310, 40);
		contentPane.add(btnSupplyview);
		
		btnRefunds = new JButton("Refunds for damaged supply");
		Image img38= new ImageIcon(this.getClass().getResource("/request.png")).getImage();
		btnRefunds.setIcon(new ImageIcon(img38));
		btnRefunds.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefunds.setBackground(UIManager.getColor("Button.background"));
		btnRefunds.setBounds(25, 236, 310, 49);
		contentPane.add(btnRefunds);
		
		JLabel lblStorekeeprAction = new JLabel("Storekeeper Actions:");
		lblStorekeeprAction.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStorekeeprAction.setBounds(25, 70, 213, 23);
		contentPane.add(lblStorekeeprAction);
		
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
		btnExit.setBounds(413, 21, 108, 40);
		contentPane.add(btnExit);
		
		btnViewOrders = new JButton("View Orders");
		Image img36= new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		btnViewOrders.setIcon(new ImageIcon(img36));
		btnViewOrders.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewOrders.setBackground(UIManager.getColor("Button.background"));
		btnViewOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewOrders.setBounds(25, 103, 310, 40);
		contentPane.add(btnViewOrders);
		
		lblNewLabel = new JLabel("");
		Image img4= new ImageIcon(this.getClass().getResource("/storekeeper.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img4));
		lblNewLabel.setBounds(408, 125, 113, 101);
		contentPane.add(lblNewLabel);
	}
	public void setStorekeeperActionsListener(ActionListener actionlistener) {
		this.btnRefunds.addActionListener(actionlistener);
		this.btnSupplyview.addActionListener(actionlistener);
		this.btnViewOrders.addActionListener(actionlistener);
	}
	public JButton getBtnSupply() {
		return btnSupplyview;
	}
	public JButton getBtnRefunds() {
		return btnRefunds;
	}
	public JButton getBtnViewOrders() {
		return btnViewOrders;
	}
}
