//package test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//import classes.Order;
//import database.DataBase;
//
//class Unitest {
//	
//	DataBase db = DataBase.getInstance();
//	String testVal = "testValue";
//
//	@Test
//	void addNewOrderTest() {
//		Order order = new Order(testVal,testVal,testVal,testVal,testVal,testVal,testVal);
//		db.delNewOrder(order);
//		
//		
//		Order orderToCompare = db.findOrderById(testVal);	
//		
//		assertTrue(order.getId().equals(orderToCompare.getId()));
//		
//	}
//	
//	
//
//}
