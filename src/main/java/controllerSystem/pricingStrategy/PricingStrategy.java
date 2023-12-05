package controllerSystem.pricingStrategy;

import modelSystem.Model;
import modelSystem.connector.ReadProductController;
import utilities.structure.ProductBasicInfo;

public abstract class PricingStrategy {

	public double totalPrize(ProductBasicInfo request) {
		ReadProductController modelConnection = new ReadProductController();
		
		return request.getProductAmount() * modelConnection.readSpecific(request.getProductID()).getPrice();
		
		//return (Model.getModel().getProductListing().get(request.getProductID()).getMaxQuantity()) *
				//(Model.getModel().getProductListing().get(request.getProductID()).getPrice());
	}

	public double discount(ProductBasicInfo request) {
		return generalStrategy(request)+ productStrategy(request);
	}

	public double generalStrategy(ProductBasicInfo request) {
		if (totalPrize(request) > 1000) {
			return totalPrize(request) * 0.05  ;
		}
		return 0.0;
	}

	public abstract double productStrategy(ProductBasicInfo request);

}
