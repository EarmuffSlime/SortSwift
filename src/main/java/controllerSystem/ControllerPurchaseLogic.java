package controllerSystem;

import modelSystem.connector.ModelRestock;
import modelSystem.connector.ReadProductController;
import utilities.factory.repo.PricingStrategyFactoryRepo;
import utilities.structure.ProductBasicInfo;
import controllerSystem.pricingStrategy.PricingStrategy;
import controllerSystem.restock.RestockingProcess;
import modelSystem.*;

public class ControllerPurchaseLogic {
	public static String purchase(ProductBasicInfo request) {
		//Compare with model product list
		
		// Exceeds max stock quantity
		if (request.getProductAmount() >
							Model.getModel().getProductListing().get(request.getProductID()).getMaxQuantity()) {
			
			ExceedsMaxQuantity.productExceedsMaxQuantity(request);
			return "Order exceeds the max quantity set for this product";
		}
		// Request does not exceed max stock quantity
		else {
			
			// If restock required
			if(request.getProductAmount() > Model.getModel().getProductListing().get(request.getProductID()).getQuantity()) {
				
				// Submit restock request to model
				RestockingProcess.doRestock(request.getProductID());
			}
			
			//Calculates Price Based on Strategy
			PricingStrategyFactoryRepo repo = PricingStrategyFactoryRepo.getInstance();
			PricingStrategy ps = repo.getTheFactoryRepo().get(Model.getModel().getProductListing().get(request.getProductID()).getDiscountID()).create();
			
			double finalPrice = (ps.totalPrize(request)) - (ps.discount(request));
			
			// Submit the purchase request to model
			new ModelRestock().accessModel(request);
			return ("“Order is finalized for Product " + request.getProductID() +  
									"and Quantity "+ request.getProductAmount()+ " with total price " + finalPrice);
			
			
		}
		
		
	}
}
