package controllerSystem.restock;

import modelSystem.Model;
import modelSystem.connector.ModelRestock;
import utilities.structure.Request;
import utilities.structure.RestockRequest;

public class RestockingProcess implements IRestockInterface {

	public static void doRestock(int productID) {
		
		System.out.println("Restocking Operation for Product "+ productID + " initiated");
		
		int maxQuantity = Model.getModel().getProductListing().get(productID).getMaxQuantity();
		int currentQuantity = Model.getModel().getProductListing().get(productID).getQuantity();
		int restock = Model.getModel().getProductListing().get(productID).getRestockQuantity();
		
		int restockCounter = 0;
		
		while(maxQuantity < currentQuantity) {
			// Add a counter for the admin viewers
			if(maxQuantity - currentQuantity >= restock) {
				currentQuantity = currentQuantity + restock;
			}
			
			else {
				currentQuantity = currentQuantity +(maxQuantity-currentQuantity);
			}
			restockCounter += 1;
			
		}
		
		// Change from direct connection to interface connection
		
		RestockRequest request = new RestockRequest();
		
		ModelRestock restockConnection = new ModelRestock();
		restockConnection.accessRestock();
		
		
		Model.getModel().getProductListing().get(productID).setQuantity(currentQuantity);
		System.out.println("Restocking Operation for Product "+ productID + " completed");
	}
	
	
	
	
	
	@Override
	public void doRestock(Request request) {
		// TODO Auto-generated method stub
		
	}

	
}
