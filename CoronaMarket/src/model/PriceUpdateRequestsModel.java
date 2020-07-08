package model;
import database.DataBase;
import model.FrameManager;
public class PriceUpdateRequestsModel {
	private DataBase db;
	private FrameManager fm;
	
	public PriceUpdateRequestsModel() {
		this.db=DataBase.getInstance();
		this.fm=FrameManager.getInstance();
	}
	
	public void returnToManagerPage() {
		fm.MoveToManagerPage();
	}
}
