package model;
import model.FrameManager;
import database.DataBase;
public class RequestToAddNewProductModel {
	private DataBase db;
	private FrameManager fm;
	
	
	public RequestToAddNewProductModel() {
		this.db=DataBase.getInstance();
		this.fm=FrameManager.getInstance();
	}
	
	public void BackToCashierPage() {
		fm.MoveToCashierPage();
	}
}
