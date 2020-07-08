package model;
import database.DataBase;
import model.FrameManager;
public class OrdersViewModel {
	private DataBase db;
	private FrameManager fm;
	
	
	public OrdersViewModel() {
		this.db=DataBase.getInstance();
		this.fm=FrameManager.getInstance();
	}
	
	public void BackToManagerPage() {
		fm.MoveToManagerPage();
	}
}
