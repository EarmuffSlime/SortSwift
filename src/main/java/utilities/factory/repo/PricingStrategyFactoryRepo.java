package utilities.factory.repo;

import java.util.HashMap;

import utilities.factory.pricingStrategyFactory.IPricingStrategyFactory;
import utilities.factory.pricingStrategyFactory.Strategy001Factory;
import utilities.factory.pricingStrategyFactory.Strategy002Factory;
import utilities.factory.pricingStrategyFactory.Strategy003Factory;


public class PricingStrategyFactoryRepo {

	private static PricingStrategyFactoryRepo instance = null;


	private HashMap< Integer , IPricingStrategyFactory> theFactoryRepo;
		
		private PricingStrategyFactoryRepo pricingStrategyFactoryRepo() {
			return new PricingStrategyFactoryRepo();
		}
		
		public static PricingStrategyFactoryRepo getInstance() {
			if(instance == null) {
				instance = new PricingStrategyFactoryRepo();
			}
			return instance;
		}

		public HashMap<Integer, IPricingStrategyFactory> getTheFactoryRepo() {
			return theFactoryRepo;
		}

		public void setTheFactoryRepo(HashMap<Integer, IPricingStrategyFactory> theFactoryRepo) {
			this.theFactoryRepo = theFactoryRepo;
		}

		public void addFactoryToRepo(int strategyID, IPricingStrategyFactory strategyFactory) {
			this.theFactoryRepo.put(strategyID, strategyFactory);
		}
		
		public PricingStrategyFactoryRepo populator(PricingStrategyFactoryRepo repo) {
			repo.addFactoryToRepo(001, new Strategy001Factory());
			repo.addFactoryToRepo(002, new Strategy002Factory());
			repo.addFactoryToRepo(003, new Strategy003Factory());
			return repo;
		}
}
