package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.OrdersViewModel;
import model.OrdersViewModelStorekeeper;
import view.OrdersView;
import view.OrdersViewStorekeeper;
public class OrdersViewControllerStorekeeper {
	private OrdersViewStorekeeper view;
	private OrdersViewModelStorekeeper model;
	
	public OrdersViewControllerStorekeeper(OrdersViewStorekeeper view,OrdersViewModelStorekeeper model) {
		this.view=view;
		this.model=model;
		view.setOrderAction(new OrderViewActionListener());
	}
	class OrderViewActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			model.BackToStorekeeperPage();
			view.setVisible(false);
			view.dispose();
			return;
		}
		
	}
}
