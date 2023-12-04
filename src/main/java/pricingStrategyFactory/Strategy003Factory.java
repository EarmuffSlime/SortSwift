package pricingStrategyFactory;

import pricingStrategy.PricingStrategy;
import pricingStrategy.PricingStrategy003;

public class Strategy003Factory implements IPricingStrategyFactory {

	@Override
	public PricingStrategy create() {
		// TODO Auto-generated method stub
		return new PricingStrategy003();
	}

}
