package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DataBase;
import model.SupplyViewModel;
import net.proteanit.sql.DbUtils;
import view.SupplyView;
public class SupplyViewController {
	private SupplyView view;
	private SupplyViewModel model;
	Connection connection=null;
	public SupplyViewController(SupplyView view,SupplyViewModel model) {
		this.model=model;
		this.view=view;
		view.setSupplyActionListener(new SupplyActionsListener());
	}
	class SupplyActionsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == view.getBtnBack()) {
				model.backToManagerPage();
				view.setVisible(false);
				view.dispose();
				return;
			}
			else if(e.getSource() == view.getBtnSupplyView()) {
				view.setRsToTable(model.getSupllyList());
			}
			
			else if(e.getSource() == view.getBtnOrderProduct()) {
				String status = "Open";
				String id = view.getIdField().getText();
				String name = view.getNameField().getText();
				String department = view.getDepartField().getText();
				String quantity = view.getInstockField().getText();
				String subDepartment = view.getSubdepField().getText();
				String price = view.getPriceField().getText();
				
				if(model.addNewOrder(status, id, name, department, quantity, subDepartment, price)) {
					view.showMsg("Order has been made!");
				}else {
					view.showMsg("Order failed!");
				}
			}

	}
}
}

