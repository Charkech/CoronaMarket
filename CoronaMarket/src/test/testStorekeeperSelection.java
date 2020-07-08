package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import database.DataBase;

class testStorekeeperSelection {
	DataBase db=DataBase.getInstance();
	private String id="3";
	private String pw="3";
	@Test
	void testSelectStorekeeper() {
		assertTrue(db.selectStorekeeper(id, pw));
	}

}
