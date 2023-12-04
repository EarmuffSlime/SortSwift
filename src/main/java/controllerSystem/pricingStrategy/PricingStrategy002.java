package controllerSystem.pricingStrategy;

import utilities.structure.ModelProductRequest;

public class PricingStrategy002 extends PricingStrategy {

	@Override
	public double productStrategy(ModelProductRequest request) {
		// TODO Auto-generated method stub
		if (request.getProductAmount() >= 30) {
			return totalPrize(request) * 0.20  ;
		}
		return 0.0;
	}
}
