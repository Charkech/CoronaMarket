package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DataBase;
import model.SupplyViewModel;
import model.SupplyViewModelStorekeeper;
import net.proteanit.sql.DbUtils;
import view.SupplyView;
import view.SupplyViewStorekeeper;
public class SupplyViewControllerStorekeeper {
	private SupplyViewStorekeeper view;
	private SupplyViewModelStorekeeper model;
	Connection connection=null;
	public SupplyViewControllerStorekeeper(SupplyViewStorekeeper view,SupplyViewModelStorekeeper model) {
		this.model=model;
		this.view=view;
		view.setSupplyActionListener(new SupplyActionsListener());
	}
	class SupplyActionsListener implements ActionListener{

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

