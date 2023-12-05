package adminUserInterface;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utilities.structure.ProductInformation;

public class AdminInternalViewer {
    private Stage primaryStage;

    public void adminStart(Stage primaryStage) {
        this.primaryStage = primaryStage;

        ProductInformation[] products = fetchData();

        // Code for making the chart
        // x Axis
        CategoryAxis x = new CategoryAxis();
        x.setLabel("Name");

        // y Axis
        NumberAxis y = new NumberAxis();
        y.setLabel("Qty");

        // bar chart creation
        BarChart<String, Number> chart = new BarChart<>(x, y);

        // add values
        XYChart.Series<String, Number> dataPoints = new XYChart.Series<>();
        dataPoints.setName("Products");

        for (int i = 0; i < products.length; i++) {
            dataPoints.getData().add(new XYChart.Data<>(products[i].getName(), products[i].getQuantity()));
        }

        chart.getData().add(dataPoints);

        // Code for listing data
        VBox vBox = new VBox();

        for (int i = 0; i < products.length; i++) {
            Label l = new Label(products[i].getName() + " \n\tQty ==> " + products[i].getQuantity());
            vBox.getChildren().add(l);
        }

        // vertical box
        HBox hBox = new HBox();
        hBox.getChildren().addAll(chart, vBox);
        Scene scene = new Scene(hBox, 600, 400); // Adjust the size as needed
        primaryStage.setScene(scene);
    }

    private ProductInformation[] fetchData() {
        // Implement your data fetching logic here, for example, from a database or file
        // For demonstration purposes, creating dummy data
        return new ProductInformation[]{
                ProductInformation.createProduct(1, "Product1", 10, 50, 100, 10, 20, 1),
                ProductInformation.createProduct(2, "Product2", 20, 30, 80, 5, 15, 2),
                // Add more products as needed
        };
    }
}
