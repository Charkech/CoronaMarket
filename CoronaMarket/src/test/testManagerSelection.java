package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import database.DataBase;

class testManagerSelection {
	DataBase db=DataBase.getInstance();
	private String id ="1";
	private String pw ="1";
	@Test
	void testSelectManager() {
	assertTrue(db.selectManager(id, pw));
	}

}
