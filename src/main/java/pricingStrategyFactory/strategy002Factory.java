package pricingStrategyFactory;

import pricingStrategy.PricingStrategy;
import pricingStrategy.PricingStrategy002;

public class Strategy002Factory implements IPricingStrategyFactory {

	@Override
	public PricingStrategy create() {
		// TODO Auto-generated method stub
		return new PricingStrategy002();
	}

}
