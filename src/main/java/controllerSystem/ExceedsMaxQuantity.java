package controllerSystem;

import utilities.structure.ProductBasicInfo;

public class ExceedsMaxQuantity {

	public static void productExceedsMaxQuantity(ProductBasicInfo request) {
		
		System.out.println("Order for Product " + request.getProductID()+" Quantity "+ request.getProductAmount()+
							" exceeds the max quantity set for this product and cannot be processed");
		
	}
}
