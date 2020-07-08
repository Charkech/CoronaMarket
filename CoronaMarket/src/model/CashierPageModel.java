package model;
import database.DataBase;
public class CashierPageModel {
	private FrameManager fm;
	private DataBase db;
	
	public CashierPageModel() {
		fm=FrameManager.getInstance();
		db=DataBase.getInstance();
	}
	public void SupplyView() {
		fm.MoveToSupplyViewCashier();;
	}
	public void AddItem() {
		fm.MoveRequestToAddNewItem();
	}
	public void RequestUpdate() {
		fm.MoveToRequestPriceUpdate();
	}
}
