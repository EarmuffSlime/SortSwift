package adminSystem.userInterface;

import javafx.application.Application;
import javafx.stage.Stage;

public class UIMain extends Application {
	AdminUserInterfaceLogin loginScreen = new AdminUserInterfaceLogin();
	public void start(Stage primaryStage) {
		loginScreen.loginStart(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
