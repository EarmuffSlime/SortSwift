package utilities.factory.pricingStrategyFactory;

import controllerSystem.pricingStrategy.PricingStrategy;
import controllerSystem.pricingStrategy.PricingStrategy002;

public class Strategy002Factory implements IPricingStrategyFactory {

	@Override
	public PricingStrategy create() {
		// TODO Auto-generated method stub
		return new PricingStrategy002();
	}

}
