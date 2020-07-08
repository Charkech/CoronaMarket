package model;
import java.sql.ResultSet;

import database.DataBase;
import model.FrameManager;
public class SalesProfitLossModel {
	private DataBase db;
	private FrameManager fm;
	
	
	public SalesProfitLossModel() {
		db=DataBase.getInstance();
		fm=FrameManager.getInstance();
	}
	public void BackToManagerPage() {
		fm.MoveToManagerPage();
	}
	public ResultSet getProfitAndLossList() {
		return db.getProfitAndLossList();
	}
}
