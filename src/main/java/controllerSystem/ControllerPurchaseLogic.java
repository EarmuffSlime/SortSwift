package controllerSystem;

import modelSystem.connector.ModelProductAccess;
import pricingStrategy.PricingStrategy;
import utilities.structure.ModelProductRequest;
import controller.restock.RestockingProcess;
import factoryRepo.PricingStrategyFactoryRepo;
import modelSystem.*;

public class ControllerPurchaseLogic {
	public static void purchase(ModelProductRequest request) {
		//Compare with model product list
		
		// Exceeds max stock quantity
		if (request.getProductAmount() >
							Model.getModel().getProductListing().get(request.getProductID()).getMaxQuantity()) {
			
			ExceedsMaxQuantity.productExceedsMaxQuantity(request);
		}
		
		int currentQuantity = Model.getModel().getProductListing().get(request.getProductID()).getQuantity();
		
		// need to restock product 
		if(request.getProductAmount() > currentQuantity) {
			
			RestockingProcess.doRestock(request.getProductID());
		}
		
		PricingStrategyFactoryRepo repo = PricingStrategyFactoryRepo.getInstance();
		PricingStrategy ps = repo.getTheFactoryRepo().get(Model.getModel().getProductListing().get(request.getProductID()).getDiscountID()).create();
		
		double finalPrice = (ps.totalPrize(request)) - (ps.discount(request));
		
		ModelProductAccess.accessModel(request);
		System.out.println("“Order is finalized for Product " + request.getProductID() +  
								"and Quantity "+ request.getProductAmount()+ " with total price " + finalPrice);
		
		
	}
}
