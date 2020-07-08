package controller;
import view.RequestPriceUpdate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RequestPriceUpdateModel;
public class RequestPriceUpdateController {
	private RequestPriceUpdate view;
	private RequestPriceUpdateModel model;
	
	
	public RequestPriceUpdateController(RequestPriceUpdate view,RequestPriceUpdateModel model) {
		this.view=view;
		this.model=model;
		view.setActionListener(new UpdateActionListener());
	}
	
	class UpdateActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			model.BackToCashierPage();
			view.setVisible(false);
			view.dispose();
		}
		
	}
}
