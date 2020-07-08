package controller;
import view.NewProductsRequests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.NewProductsRequestsModel;
public class NewProductsRequestsController {
	private NewProductsRequests view;
	private NewProductsRequestsModel model;
	
	
	public NewProductsRequestsController(NewProductsRequests view,NewProductsRequestsModel model) {
		this.view=view;
		this.model=model;
		view.setlistener(new NewProductsListener());
	}
	
	class NewProductsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			model.MoveToManagerPage();
			view.setVisible(false);
			view.dispose();
			return;
		}
		
	}
}
