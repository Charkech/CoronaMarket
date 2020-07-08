package model;
import database.DataBase;
import model.FrameManager;
public class SupplyViewModelStorekeeper {
	private DataBase db;
	private FrameManager fm;
	
	public SupplyViewModelStorekeeper() {
		db=DataBase.getInstance();
		fm=FrameManager.getInstance();
	}
	public void backToStorekeeperPage() {
		fm.MoveToStoreKeeperPage();
	}
}
