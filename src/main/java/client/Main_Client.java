package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelSystem.connector.ReadProductClient;

public class Main_Client extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static JComboBox<String> productList;
	private static JComboBox<String> quantityList;
	private static String theProduct;
	private static String theQuantity;
	private JTextArea orderDetails;
	private static String productReport = null;
	private static String quantityReport = null;
	private static String timeReport = null;

	private static Main_Client instance;

	public static Main_Client getInstance() {
		if (instance == null)
			instance = new Main_Client();

		return instance;
	}

	private Main_Client() {
		// Set window title
		super("Product Ordering Client");

		// Set top bar
		JLabel step1 = new JLabel("Step1 Choose Product");
		JLabel step2 = new JLabel("Step2 Choose Quantity");

		JLabel chooseProductLabel = new JLabel(": ");
		Vector<String> productNames = new Vector<String>();
		productList = new JComboBox<String>(productNames);
		
		ClientCaller clientCall = new ClientCaller();
		String productNameString = clientCall.doThehttpCall2("GiveProducts");
		
		String[] productNameList = productNameString.split(" ");
		
		for (int i = 0; i < productNameList.length; i++) {
			productNames.add(productNameList[i]);
		}
		
		productNames.sort(null);

		JButton addProduct = new JButton("Choose");
		addProduct.setActionCommand("addProduct");
		addProduct.addActionListener(this);

		JLabel qty = new JLabel(": ");
		// JLabel to = new JLabel("To");
		Vector<String> quantity = new Vector<String>();
		for (int i = 0; i <= 1000; i = i + 50) {
			quantity.add("" + i);
		}
		quantity.remove(0);
		quantity.add(0, "1");
		quantityList = new JComboBox<String>(quantity);
		JButton addQuantity = new JButton("Choose");
		addQuantity.setActionCommand("addQuantity");
		addQuantity.addActionListener(this);

		quantityList.setActionCommand("addQuantity");

		JPanel north = new JPanel();
		north.add(step1);
		north.add(chooseProductLabel);
		north.add(productList);
		north.add(addProduct);
		north.add(step2);
		north.add(qty);
		north.add(quantityList);
		north.add(addQuantity);

		JPanel east = new JPanel();

		// Set charts region
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(2, 0));
		// createCharts(west);

		JLabel orderDetailsLabel = new JLabel("Order Details: ");
		orderDetails = new JTextArea(30, 60);
		JScrollPane orderDetailsScrollPane = new JScrollPane(orderDetails);
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.add(orderDetailsLabel);
		east.add(orderDetailsScrollPane);

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(west, BorderLayout.WEST);
	}

	private void createCharts(JPanel west) {
		createReport(west);

	}

	private void createReport(JPanel west) {
		JTextArea report = new JTextArea();
		report.setEditable(false);
		report.setPreferredSize(new Dimension(400, 300));
		report.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		report.setBackground(Color.white);
		String reportMessage;

		reportMessage = "Product " + theProduct + "\n" + "Quantity " + theQuantity + "\n";

		report.setText(reportMessage);
		JScrollPane outputScrollPane = new JScrollPane(report);
		west.add(outputScrollPane);
	}

	public static void main(String[] args) {

		JFrame frame = Main_Client.getInstance();
		frame.setSize(900, 600);
		frame.pack();
		frame.setVisible(true);

	}



	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.print(command);

		if ("addProduct".equals(command)) {
			/*
			 * stats.removeAll(); DataVisualizationCreator creator = new
			 * DataVisualizationCreator(); creator.createCharts();
			 */
			theProduct = productList.getSelectedItem().toString();
			productReport = "Product : " + theProduct + "\n";

		} else if ("addQuantity".equals(command)) {
			// selectedList.add(cryptoList.getSelectedItem().toString());
			theQuantity = quantityList.getSelectedItem().toString();
			quantityReport = "Quantity : " + theQuantity + "\n";
			timeReport = "Client Time Stamp : " + java.time.LocalDateTime.now().toString() + "\n";

			orderDetails.setText(productReport + quantityReport + timeReport + "\n");
			ClientCaller clientCall = new ClientCaller();
			System.out.println(theProduct);
			System.out.println(theQuantity);
			String response = clientCall.doThehttpCall1(theProduct, theQuantity);
			System.out.println(response);
			orderDetails.setText(productReport + quantityReport + timeReport + "\n" + response);
		}
	}
	
	
	
	// TODO Auto-generated method stub

}
