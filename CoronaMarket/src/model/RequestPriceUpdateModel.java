package model;
import database.DataBase;
import model.FrameManager;
public class RequestPriceUpdateModel {
	private DataBase db;
	private FrameManager fm;
	
	public RequestPriceUpdateModel() {
		this.db=DataBase.getInstance();
		this.fm=FrameManager.getInstance();
	}
	
	public void BackToCashierPage() {
		fm.MoveToCashierPage();
	}
}
