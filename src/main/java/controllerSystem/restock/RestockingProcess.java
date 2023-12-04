package controllerSystem.restock;

import modelSystem.Model;

import utilities.structure.Request;

public class RestockingProcess implements IRestockInterface {

	public static void doRestock(int productID) {
		
		System.out.println("Restocking Operation for Product "+ productID + " initiated");
		
		int maxQuantity = Model.getModel().getProductListing().get(productID).getMaxQuantity();
		int currentQuantity = Model.getModel().getProductListing().get(productID).getQuantity();
		int restock = Model.getModel().getProductListing().get(productID).getRestockQuantity();
		
		while(maxQuantity != currentQuantity) {
			
			if(maxQuantity - currentQuantity >= restock) {
				currentQuantity = currentQuantity + restock;
			}
			
			else {
				currentQuantity = currentQuantity +(maxQuantity-currentQuantity);
			}
		
			
		}
		
		Model.getModel().getProductListing().get(productID).setQuantity(currentQuantity);
		System.out.println("Restocking Operation for Product "+ productID + " completed");
	}
	
	
	
	
	
	@Override
	public void doRestock(Request request) {
		// TODO Auto-generated method stub
		
	}

	
}
