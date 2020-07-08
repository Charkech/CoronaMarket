package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.OrdersViewModel;
import view.OrdersView;
public class OrdersViewController {
	private OrdersView view;
	private OrdersViewModel model;
	
	public OrdersViewController(OrdersView view,OrdersViewModel model) {
		this.view=view;
		this.model=model;
		view.setOrderAction(new OrderViewActionListener());
	}
	class OrderViewActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			model.BackToManagerPage();
			view.setVisible(false);
			view.dispose();
			return;
		}
		
	}
}
