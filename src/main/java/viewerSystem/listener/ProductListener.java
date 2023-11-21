package viewerSystem.listener;

import utilities.structure.*;

public class ProductListener implements EventListener{
	public static EventListener createListener() {
		return new ProductListener();
	}

	public void update(Update update) {
		//Temporary Method
		System.out.println(update.printFullUpdate());
	}

}