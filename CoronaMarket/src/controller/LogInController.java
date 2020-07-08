package controller;
import java.awt.event.*;

import model.LogInModel;
import view.LogInView;
public class LogInController {
	private LogInView view;
	private LogInModel model;
	
	public LogInController(LogInView view,LogInModel model) {
		this.view=view;
		this.model=model;
		view.setLogInAL(new LogInBtnActionListener());
	}
	class LogInBtnActionListener implements ActionListener{
		//overide
		public void actionPerformed(ActionEvent e) {
			
			String userName=view.getUserName();
			String passWord=view.getPassword();
			if(model.logIn(userName, passWord)==false) {
				view.displayMessage("User name or password is incorrect");
			}
			else {
				view.setVisible(false);
				view.dispose();
			}
		}
	}
}
