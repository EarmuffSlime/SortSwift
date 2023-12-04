package controllerSystem.pricingStrategy;

import modelSystem.Model;
import utilities.structure.ModelProductRequest;

public class PricingStrategy001 extends PricingStrategy {

	@Override
	public double productStrategy(ModelProductRequest request) {
		// TODO Auto-generated method stub
		if (request.getProductAmount() >= 50) {
			
			
			return totalPrize(request) * 0.15  ;
		}
		
		return 0.0;
	}

}
