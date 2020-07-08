package model;
import database.DataBase;
public class LogInModel {
	private DataBase db;
	private FrameManager fm;
	
	public LogInModel() {
		db=DataBase.getInstance();
		fm=FrameManager.getInstance();
	}
	public boolean logIn(String userId,String pword) {
		
		if(db.selectCashier(userId,pword)) {
			fm.setCashier(true);
			fm.MoveToCashierPage();
			return true;
		}
		if(db.selectStorekeeper(userId, pword)) {
			fm.setStorekeeper(true);
			fm.MoveToStoreKeeperPage();
			return true;
		}
		if(db.selectManager(userId, pword)) {
			fm.setManager(true);
			fm.MoveToManagerPage();
			return true;
		}else
			return false;
	
	}
}
