package model;
import java.sql.ResultSet;

import classes.Order;
import database.DataBase;
import model.FrameManager;
public class SupplyViewModel {
	private DataBase db;
	private FrameManager fm;
	
	public SupplyViewModel() {
		db=DataBase.getInstance();
		fm=FrameManager.getInstance();
	}
	public void backToManagerPage() {
		fm.MoveToManagerPage();
	}
	
	public ResultSet getSupllyList() {
		return db.getSupllyList();
	}
	
	public boolean addNewOrder(String status, String id, String name, String department, String quantity,String subDep, String price) {
		Order order = new Order(status, id, name, department, quantity, subDep, price);
		
		return db.addNewOrder(order);
	}
}
