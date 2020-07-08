package model;
import database.DataBase;
import model.FrameManager;
public class OrdersViewModelStorekeeper {
	private FrameManager fm;
	private DataBase db;
	
	
	
	public OrdersViewModelStorekeeper() {
		this.fm=FrameManager.getInstance();
		this.db=DataBase.getInstance();
	}
	
	public void BackToStorekeeperPage() {
		fm.MoveToStoreKeeperPage();
	}
}
