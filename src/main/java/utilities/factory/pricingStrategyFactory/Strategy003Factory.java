package utilities.factory.pricingStrategyFactory;

import controllerSystem.pricingStrategy.PricingStrategy;
import controllerSystem.pricingStrategy.PricingStrategy003;

public class Strategy003Factory implements IPricingStrategyFactory {

	@Override
	public PricingStrategy create() {
		// TODO Auto-generated method stub
		return new PricingStrategy003();
	}

}
