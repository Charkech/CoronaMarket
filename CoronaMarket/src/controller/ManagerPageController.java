package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ManagerPageModel;
import view.ManagerPage;
public class ManagerPageController {
	private ManagerPage view;
	private ManagerPageModel model;
	
	public ManagerPageController(ManagerPage view,ManagerPageModel model) {
		this.model=model;
		this.view=view;
		view.setManagerActions(new ManagerActionListener());
	}
	
	class ManagerActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
	     if(view.getSupplyViewBtn()==e.getSource()) {
	    	 model.SupplyView();
	    	 view.setVisible(false);
	    	 view.dispose();
	    	 return;
	     }
	     if(view.getOrdersPageBtn()==e.getSource()) {
	    	 model.OrdersView();
	    	 view.setVisible(false);
	    	 view.dispose();
	    	 return;
	     }
	     if(view.getSalesProBtn()==e.getSource()) {
	    	 model.SalesProfitLoss();
	    	 view.setVisible(false);
	    	 view.dispose();
	    	 return;
	     }
	     if(view.getViewRequestBtn()==e.getSource()) {
	    	 model.ProductsRequest();
	    	 view.setVisible(false);
	    	 view.dispose();
	    	 return;
	     }
	     if(view.getUpdateBtn()==e.getSource()) {
	    	 model.PriceUpdateRequests();
	    	 view.setVisible(false);
	    	 view.dispose();
	    	 return;
	     }
		}
		
	}
}
