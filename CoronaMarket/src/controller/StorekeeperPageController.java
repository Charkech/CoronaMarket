package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StorekeeperPageModel;
import view.StorekeeperPage;
public class StorekeeperPageController {
	private StorekeeperPage view;
	private StorekeeperPageModel model;
	
	public StorekeeperPageController(StorekeeperPage view,StorekeeperPageModel model) {
		this.view=view;
		this.model=model;
		view.setStorekeeperActionsListener(new StorekeeperActionsListener());
	}
	class StorekeeperActionsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(view.getBtnSupply()==e.getSource()) {
				model.SupplyView();
				view.setVisible(false);
				view.dispose();
				return;
			}
			if(view.getBtnRefunds()==e.getSource()) {
				model.Refunds();
				view.setVisible(false);
				view.dispose();
				return;
			}
			if(view.getBtnViewOrders()==e.getSource()) {
				model.OrdersView();
				view.setVisible(false);
				view.dispose();
				return;
			}
		}
		
	}
}
