package adminSystem;

import modelSystem.Model;
import modelSystem.functions.ModelStart;
import modelSystem.observer.UpdatePublisher;
import utilities.factory.repo.PricingStrategyFactoryRepo;
import viewerSystem.listener.ProductListener;

public class AdminInitializer {
	private Model model;
	private PricingStrategyFactoryRepo repo;
	private ProductListener listen;
	private UpdatePublisher publisher;
	
	
	
	public AdminInitializer() {
		
	}
	
	public void startSystems() {
		this.model = Model.getModel();
		this.repo = PricingStrategyFactoryRepo.getInstance();
		this.repo.populator(repo);
		
		
		this.listen = new ProductListener();
		this.publisher = UpdatePublisher.getPublisher();
		this.publisher.subscribe(listen);
		
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
