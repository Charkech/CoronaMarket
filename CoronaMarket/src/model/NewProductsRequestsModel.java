package model;
import database.DataBase;
import model.FrameManager;
public class NewProductsRequestsModel {
	private FrameManager fm;
	private DataBase db;
	
	
	public NewProductsRequestsModel() {
		this.fm=FrameManager.getInstance();
		this.db=DataBase.getInstance();
	}
	
	
	public void MoveToManagerPage() {
		fm.MoveToManagerPage();
	}
}
