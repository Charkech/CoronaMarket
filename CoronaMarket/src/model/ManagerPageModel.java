package model;

import database.DataBase;

public class ManagerPageModel {
	private FrameManager fm;
	private DataBase db;
	
	public ManagerPageModel() {
		this.db=DataBase.getInstance();
		this.fm=FrameManager.getInstance();
	}
	
	public void SupplyView() {
		fm.MoveToSupplyView();
	}
	public void SalesProfitLoss() {
		fm.MoveToSalesProfitLoss();
	}
	public void OrdersView() {
		fm.MoveToOrdersPage();
	}
	public void ProductsRequest() {
		fm.MoveToNewProductsRequests();;
	}
	public void PriceUpdateRequests() {
		fm.MovePriceUpdateRequests();
	}
}
