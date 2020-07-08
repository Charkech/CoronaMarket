package controller;
import view.RequestToAddNewProduct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RequestToAddNewProductModel;
public class RequestToAddNewProductController {
	private RequestToAddNewProduct view;
	private RequestToAddNewProductModel model;
	
	public RequestToAddNewProductController(RequestToAddNewProduct view,RequestToAddNewProductModel model) {
		this.view=view;
		this.model=model;
		view.setActionListener(new reqActionListener());
	}
	
	class reqActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			model.BackToCashierPage();
			view.setVisible(false);
			view.dispose();
			return;
		}
		
	}
}
