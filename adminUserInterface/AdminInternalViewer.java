package adminUserInterface;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

// 1. update the size of the stage to fit all our data
// 2. set up a dynamic size for the chart
// 3. set up a dynamic size for data & add scrolling to it

public class AdminInternalViewer {
	public AdminInternalViewer() {}	
	private Stage primaryStage;
	
	public void adminStart(Stage primaryStage) {
		Product[] products = fetchData();
		
		// Code for making the chart
		// x Axis
		CategoryAxis x = new CategoryAxis();
		x.setLabel("Name");
		
		// y Axis
		NumberAxis y = new NumberAxis();
		y.setLabel("Qty");
		
		// bar chart creation
		BarChart chart = new BarChart(x, y);
		
		// add values
		XYChart.Series dataPoints = new XYChart.Series();
		dataPoints.setName("Products");
		
		for (int i = 0; i < products.length; i++) {
			dataPoints.getData().add(new XYChart.Data(products[i].getName(), products[i].getQty()));
		}
		
		chart.getData().add(dataPoints);
		
		// Code for listing data
		VBox vBox = new VBox();
		
		for(int i = 0; i < products.length; i++) {
			Label l = new Label(products[i].getName() + " \n\tQty ==> " + products[i].getQty());
			vBox.getChildren().add(l);
		}
		
		// vertical box
		HBox hBox = new HBox();
		hBox.getChildren().addAll(chart, vBox);
		Scene sceen = new Scene(hBox, 300, 200);
		primaryStage.setScene(sceen);
	}
	
	// Update this to query for database
	// I am just using mocked product data
	// Feel free to update the prodcut class
	// to fit your needs
	private Product[] fetchData() {
		//harded coded values, please change it so it quueys data from database please
		Product[] products = new Product[10];
		
		for (int i = 0; i < products.length; i++) {
			products[i] = new Product("Prod " + (i+1), (i+1) * 100);
		}
		
		return products;
	}
}
