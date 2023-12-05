package controllerSystem.restock;

import modelSystem.Model;
import modelSystem.connector.ModelRestock;
import modelSystem.connector.ReadProductController;
import utilities.structure.Request;
import utilities.structure.RestockRequest;

public class RestockingProcess implements IRestockInterface {

	public static void doRestock(int productID) {
		
		System.out.println("Restocking Operation for Product "+ productID + " initiated");
		ReadProductController modelConnection = new ReadProductController();
		
		int maxQuantity = modelConnection.readSpecific(productID).getMaxQuantity();
		int currentQuantity = modelConnection.readSpecific(productID).getQuantity();
		int restock = modelConnection.readSpecific(productID).getRestockQuantity();
		
		//int maxQuantity = Model.getModel().getProductListing().get(productID).getMaxQuantity();
		//int currentQuantity = Model.getModel().getProductListing().get(productID).getQuantity();
		//int restock = Model.getModel().getProductListing().get(productID).getRestockQuantity();
		
		int restockCounter = 0;
		
		while(maxQuantity > currentQuantity) {
			if(maxQuantity - currentQuantity >= restock) {
				currentQuantity = currentQuantity + restock;
			}
			
			else {
				currentQuantity = currentQuantity +(maxQuantity-currentQuantity);
			}
			restockCounter += 1;
			
		}
		
		// Change from direct connection to interface connection
		
		RestockRequest request = new RestockRequest(productID, modelConnection.readSpecific(productID).getName(), maxQuantity, restockCounter);
		
		ModelRestock restockConnection = new ModelRestock();
		restockConnection.access(request);
		
		
		Model.getModel().getProductListing().get(productID).setQuantity(currentQuantity);
		System.out.println("Restocking Operation for Product "+ productID + " completed " + restockCounter + " restocks were preformed");
	}
	
	
	
	
	
	@Override
	public void doRestock(Request request) {
		// TODO Auto-generated method stub
		
	}

	
}
