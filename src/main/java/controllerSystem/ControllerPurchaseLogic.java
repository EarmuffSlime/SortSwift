package controllerSystem;

import modelSystem.connector.ReadProductController;
import utilities.factory.repo.PricingStrategyFactoryRepo;
import utilities.structure.ProductBasicInfo;
import controllerSystem.pricingStrategy.PricingStrategy;
import controllerSystem.restock.RestockingProcess;
import modelSystem.*;

public class ControllerPurchaseLogic {
	public static void purchase(ProductBasicInfo request) {
		//Compare with model product list
		
		// Exceeds max stock quantity
		if (request.getProductAmount() >
							Model.getModel().getProductListing().get(request.getProductID()).getMaxQuantity()) {
			
			ExceedsMaxQuantity.productExceedsMaxQuantity(request);
		}
		
		//IF you have time, Refactor this for direct call
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
