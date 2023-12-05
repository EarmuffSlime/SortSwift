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
		
		AdminServer anHttpServer = new AdminServer();
		
		try {
			anHttpServer.startServer();
			System.out.println("Server Initiated");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
}
