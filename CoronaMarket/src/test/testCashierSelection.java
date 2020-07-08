package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import database.DataBase;

class testCashierSelection {
	DataBase db=DataBase.getInstance();
	private String id="2";
	private String pw="2";
	@Test
	void testSelectCashier() {
		assertTrue(db.selectCashier(id, pw));
	}

}
