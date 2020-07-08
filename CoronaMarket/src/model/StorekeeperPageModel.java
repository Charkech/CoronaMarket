package model;

import database.DataBase;

public class StorekeeperPageModel {
	private FrameManager fm;
	private DataBase db;
	
	public StorekeeperPageModel() {
		this.db=DataBase.getInstance();
		this.fm=FrameManager.getInstance();
	}
	
	public void SupplyView() {
		fm.MoveToSupplyViewStorekeeper();
	}
	public void Refunds() {
		fm.MoveToRefundsPage();
	}
	public void OrdersView() {
		fm.MoveToOrdersViewStorekeeper();;
	}
}
