package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SalesProfitLossModel;
import net.proteanit.sql.DbUtils;
import view.SalesProfitLoss;
public class SalesProfitLossController {
	private SalesProfitLoss view;
	private SalesProfitLossModel model;
	
	
	public SalesProfitLossController(SalesProfitLoss view,SalesProfitLossModel model) {
		this.view=view;
		this.model=model;
		view.setListenerProfitLoss(new SalesActionHandler());
	}
	class SalesActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==view.getBtnBackToManager()) {
			model.BackToManagerPage();
			view.setVisible(false);
			view.dispose();
			}
			else if (e.getSource()==view.getBtnLoad()) {
				view.setRsToTable(model.getProfitAndLossList());
			}
		}
		
	}
}
