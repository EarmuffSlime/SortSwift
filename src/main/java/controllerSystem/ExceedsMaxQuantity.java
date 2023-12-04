package controllerSystem;

import utilities.structure.ModelProductRequest;

public class ExceedsMaxQuantity {

	public static void productExceedsMaxQuantity(ModelProductRequest request) {
		
		System.out.println("Order for Product " + request.getProductID()+" Quantity "+ request.getProductAmount()+
							" exceeds the max quantity set for this product and cannot be processed");
		
	}
}
