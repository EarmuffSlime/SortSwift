package pricingStrategy;

import utilities.structure.ModelProductRequest;

public class PricingStrategy003 extends PricingStrategy {

	@Override
	public double productStrategy(ModelProductRequest request) {
		// TODO Auto-generated method stub
		if (request.getProductAmount() >= 50) {
			return totalPrize(request) * 0.10  ;
		}
		return 0.0;
	}

}
