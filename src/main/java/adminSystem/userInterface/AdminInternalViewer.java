package adminSystem.userInterface;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelSystem.connector.ReadProductViewers;
import utilities.structure.ProductBasicInfo;
import utilities.structure.ProductInformation;

public class AdminInternalViewer {
    private Stage primaryStage;
    private BarChart<String, Number> chart;
    private XYChart.Series<String, Number> dataPoints;
    private static AdminInternalViewer instance;
    private CategoryAxis x;
    private NumberAxis y;
    private VBox vBox;
    private Label l;
    
    
    private AdminInternalViewer() {
        // Code for making the chart
        // x Axis
        this.x = new CategoryAxis();
        this.x.setLabel("Name");

        // y Axis
        this.y = new NumberAxis();
        this.y.setLabel("Qty");
        
        // Bar Chart Creation
        this.chart = new BarChart<>(x, y);
        
    	this.dataPoints = new XYChart.Series<>();
    	this.dataPoints.setName("Products");
    	
    	// VBOX Creation
    	this.vBox = new VBox();
    }
    
    public static AdminInternalViewer getInstance() {
    	if (instance == null) {
    		instance = new AdminInternalViewer();
    	}
    	return instance;
    }

    public void adminStart(Stage primaryStage) {
        this.primaryStage = primaryStage;

        ArrayList<ProductBasicInfo> products = fetchData();

        // Data Points Creation
        
        updateBarGraph();
        updateVBox();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(chart, vBox);
        Scene scene = new Scene(hBox, 800, 400); // Adjust the size as needed
        primaryStage.setScene(scene);
    }

    private ArrayList<ProductBasicInfo> fetchData() {
    	ReadProductViewers modelConnect = new ReadProductViewers();
        return modelConnect.read();
    }
    
    public void updateBarGraph() {
    	System.out.println("Bar");
    	ArrayList<ProductBasicInfo> products = fetchData();
        for (int i = 0; i < products.size(); i++) {
            this.dataPoints.getData().add(new XYChart.Data<>(products.get(i).getProductName(), products.get(i).getProductAmount()));
        }
        this.chart.getData().add(this.dataPoints);
    }
    
    public void clearBarGraph() {
    	this.chart.getData().remove(this.dataPoints); 
    }
    
    public void updateVBox() {
    	ArrayList<ProductBasicInfo> products = fetchData();
    	for (int i = 0; i < products.size(); i++) {
            this.l = new Label(products.get(i).getProductName() + " \n\tQty ==> " + products.get(i).getProductAmount());
            vBox.getChildren().add(l);
        }
    }
    
    public void clearVBox() {
    	this.vBox.getChildren().remove(l);
    }
    
}