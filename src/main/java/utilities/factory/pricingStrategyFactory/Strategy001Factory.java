package utilities.factory.pricingStrategyFactory;

import controllerSystem.pricingStrategy.PricingStrategy;
import controllerSystem.pricingStrategy.PricingStrategy001;

public class Strategy001Factory implements IPricingStrategyFactory {

	@Override
	public PricingStrategy create() {
		// TODO Auto-generated method stub
		return new PricingStrategy001();
	}

}
