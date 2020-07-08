package model;
import model.FrameManager;
import database.DataBase;
public class RefundsForDamagedSupplyModel {
	private FrameManager fm;
	private DataBase db;
	
	public RefundsForDamagedSupplyModel() {
		this.fm=FrameManager.getInstance();
		this.db=DataBase.getInstance();
	}
	
	public void backToStorekeeperPage() {
		fm.MoveToStoreKeeperPage();
	}
}
