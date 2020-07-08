package model;
import database.DataBase;
import model.FrameManager;
public class SupplyViewModelCashier {
	private DataBase db;
	private FrameManager fm;
	
	public SupplyViewModelCashier() {
		db=DataBase.getInstance();
		fm=FrameManager.getInstance();
	}
	public void backToCashier() {
		fm.MoveToCashierPage();;
	}
}
