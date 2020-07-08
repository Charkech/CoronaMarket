package controller;
import view.RefundsForDamagedSupply;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RefundsForDamagedSupplyModel;
public class RefundsForDamangedSupplyController {
	private RefundsForDamagedSupply view;
	private RefundsForDamagedSupplyModel model;
	
	
	public RefundsForDamangedSupplyController(RefundsForDamagedSupply view,RefundsForDamagedSupplyModel model) {
		this.view=view;
		this.model=model;
		view.refundsListener(new RefundsListener());
	}
	
	class RefundsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			model.backToStorekeeperPage();
			view.setVisible(false);
			view.dispose();
			return;
		}
		
	}
}
