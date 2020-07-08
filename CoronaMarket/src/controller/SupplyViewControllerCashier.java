package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DataBase;
import model.SupplyViewModel;
import model.SupplyViewModelCashier;
import net.proteanit.sql.DbUtils;
import view.SupplyView;
import view.SupplyViewCashier;
public class SupplyViewControllerCashier {
	private SupplyViewCashier view;
	private SupplyViewModelCashier model;
	Connection connection=null;
	public SupplyViewControllerCashier(SupplyViewCashier view,SupplyViewModelCashier model) {
		this.model=model;
		this.view=view;
		view.setlistener(new SupplyActionsListener());
	}
	class SupplyActionsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			model.backToCashier();
			view.setVisible(false);
			view.dispose();
			return;
	}
}
}

