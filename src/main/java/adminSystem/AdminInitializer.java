package adminSystem;

import modelSystem.Model;
import modelSystem.functions.ModelStart;
import utilities.factory.repo.PricingStrategyFactoryRepo;

public class AdminInitializer {
	private Model model;
	private PricingStrategyFactoryRepo repo;
	
	public AdminInitializer() {
		
	}
	
	public void startSystems() {
		this.model = Model.getModel();
		this.repo = PricingStrategyFactoryRepo.getInstance();
		
		ModelStart modelLoader = new ModelStart();
		modelLoader.modelLoad();
	}
	
	
}
