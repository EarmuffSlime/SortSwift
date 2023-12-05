package viewerSystem.listener;

import adminSystem.userInterface.AdminInternalViewer;
import utilities.structure.*;

public class ProductListener implements EventListener{
	public static EventListener createListener() {
		return new ProductListener();
	}

	public void update(Update update) {
		//Temporary Method
		System.out.println(update.printFullUpdate());
		AdminInternalViewer access = AdminInternalViewer.getInstance();
		access.clearBarGraph();
		access.updateBarGraph();
	}

}