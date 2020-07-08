package controller;
import view.PriceUpdateRequests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.PriceUpdateRequestsModel;
public class PriceUpdateRequestsController {
	private PriceUpdateRequests view;
	private PriceUpdateRequestsModel model;
	
	
	public PriceUpdateRequestsController(PriceUpdateRequests view,PriceUpdateRequestsModel model) {
		this.view=view;
		this.model=model;
		view.setListeners(new UpdateListener());
	}
	
	class UpdateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			model.returnToManagerPage();
			view.setVisible(false);
			view.dispose();
			return;
		}
		
	}
}
