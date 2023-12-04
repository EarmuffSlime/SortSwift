package adminUserInterface;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


// we need username
// password
// login btn

public class AdminUserInterface extends Application{
	
	private Stage primaryStage;
	
	final String USER_CREDS = "J";
	final String PASS_CREDS = "1";
	
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Login Screen");
		
		VBox vbox = new VBox(10);
		
		// Username
		Label usernameLabel = new Label("Username:");
		TextField usernameInput = new TextField();
		
		// Password
		Label passwordLabel = new Label("Password:");
		PasswordField passwordInput = new PasswordField();
	
		// Login
		Button loginBtn = new Button("Login!");
		loginBtn.setOnAction(e -> handleLogin(usernameInput.getText(), passwordInput.getText()));
		
		
		vbox.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginBtn);
		
		Scene scene = new Scene(vbox, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void handleLogin(String username, String password) {
		// Query the database for the Username and Password
		// HERE
		System.out.println("Username entered: " + username);
		System.out.println("Password entered: " + password);
		if (USER_CREDS.equals(username) && PASS_CREDS.equals(password)) {
			System.out.println("LOGGED IN");
			showScreen2();
		} else {
			System.out.println("WRONG CREDS!");
		}
	}
	
	private void showScreen2() {
		// Query the database for your warehouse data to display in the graphs
		// HERE
		StackPane s2Pane = new StackPane();
		s2Pane.getChildren().add(new Label("IN SCREEN 2"));
		
		Scene scene2 = new Scene(s2Pane, 450, 450);
		primaryStage.setScene(scene2); // Switch to new screen
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
