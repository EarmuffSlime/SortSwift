package controllerSystem.pricingStrategy;

import modelSystem.Model;
import utilities.structure.ModelProductRequest;

public abstract class PricingStrategy {

	public double totalPrize(ModelProductRequest request) {

		return (Model.getModel().getProductListing().get(request.getProductID()).getMaxQuantity()) *
				(Model.getModel().getProductListing().get(request.getProductID()).getPrice());
	}

	public double discount(ModelProductRequest request) {
		return generalStrategy(request)+ productStrategy(request);
	}

	public double generalStrategy(ModelProductRequest request) {
		if (totalPrize(request) > 1000) {
			return totalPrize(request) * 0.05  ;
		}
		return 0.0;
	}

	public abstract double productStrategy(ModelProductRequest request);

}
