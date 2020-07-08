package controller;
import view.CashierPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CashierPageModel;;
public class CashierPageController {
	private CashierPage view;
	private CashierPageModel model;
	
	public CashierPageController(CashierPage view,CashierPageModel model) {
		this.view=view;
		this.model=model;
		view.setCashierActions(new CashierActionBtnListener());
	}
	class CashierActionBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (view.getBtnSupplyView()==e.getSource()) {
				model.SupplyView();
				view.setVisible(false);
				view.dispose();
				return;
			}
			if (view.getBtnAddItem()==e.getSource()) {
				model.AddItem();
				view.setVisible(false);
				view.dispose();
				return;
			}
			if (view.getBtnRequestUpdate()==e.getSource()) {
				model.RequestUpdate();
				view.setVisible(false);
				view.dispose();
				return;
			}
		}
	}
}
