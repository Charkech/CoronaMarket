package main;

import database.DataBase;
import model.FrameManager;

public class Driver {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameManager fm = FrameManager.getInstance();
		
		fm.MoveToLoginPage();
		
	}

}
