package controllerSystem;

import modelSystem.connector.ModelPurchase;
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
		System.out.println("Controller2");
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
			System.out.println("Controller3");
			//Calculates Price Based on Strategy
			PricingStrategyFactoryRepo repo = PricingStrategyFactoryRepo.getInstance();
			System.out.println("Controller3.5");
			PricingStrategy ps = repo.getTheFactoryRepo().get(Model.getModel().getProductListing().get(request.getProductID()).getDiscountID()).create();
			
			System.out.println("Controller4");
			
			double finalPrice = (ps.totalPrize(request)) - (ps.discount(request));
			
			// Submit the purchase request to model
			System.out.println("Controller5");
			ModelPurchase modelConnection = new ModelPurchase();
			modelConnection.accessModel(request);
			System.out.println("Controller6");
			ReadProductController connect = new ReadProductController();
			return ("Order is finalized for Product " + connect.readSpecific(request.getProductID()).getName() +  
									" and Quantity "+ request.getProductAmount()+ " with total price " + finalPrice);
			
			
		}
		
		
	}
}
