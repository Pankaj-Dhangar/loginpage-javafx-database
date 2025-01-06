package org.dnyanyog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LoginScreenController {
	
	@FXML
	TextField password;
	
	@FXML
	TextField loginName;
	
	@FXML
	Label errorMessage;
	
	public void loginButtonClick() throws SQLException {
		String url ="jdbc:mysql://127.0.0.1:3306/e_com";
		String username ="root";
		String pass = "Pankaj@420";
		
		Connection connection = DriverManager.getConnection(url,username,pass);
		
		Statement statement = connection.createStatement();
		
		String query = "Select * from e_com.login where LoginName = '" + loginName.getText() + "'and Loginpassword = '"
				+ password.getText() + "';";	
		ResultSet result = statement.executeQuery(query);
		
		if(result.next()) {
			this.errorMessage.setText("Login Successful");
			
		}else {
			this.errorMessage.setText("Login Failed");
		}
		
	}
		
}
