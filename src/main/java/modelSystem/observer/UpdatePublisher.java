package modelSystem.observer;

import java.util.ArrayList;
import viewerSystem.listener.*;
import utilities.structure.*;

public class UpdatePublisher {
	private ArrayList<ProductListener> productSubscriber;
	private static UpdatePublisher instance;
	
	private UpdatePublisher() {
		this.productSubscriber = new ArrayList<ProductListener>();
	}
	
	//Singleton
	public static UpdatePublisher getPublisher() {
		if (instance == null) {
			instance = new UpdatePublisher();
		}
		return instance;
	}
	
	public void subscribe(ProductListener subscriber) {
		this.productSubscriber.add(subscriber);
	}
	
	public void unsubscribe(ProductListener subscriber) {
		this.productSubscriber.remove(subscriber);
	}
	
	
	public void notify(String name, int amount) {
		Update productUpdate = ProductUpdate.createUpdate(name, amount);
		for (int i = 0; i < productSubscriber.size(); i++) {
			productSubscriber.get(i).update(productUpdate);
		}
	}
}

