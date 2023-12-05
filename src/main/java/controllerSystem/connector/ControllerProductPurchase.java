package controllerSystem.connector;

import controllerSystem.ControllerPurchaseLogic;
import utilities.structure.ProductBasicInfo;
import utilities.structure.Request;

public class ControllerProductPurchase implements IController{

	
	public ControllerProductPurchase() {
		
	}
	
	public String access(ProductBasicInfo request) {
		//Call function controlerPuchaseLogic
		System.out.println("Controller1");
		
		return ControllerPurchaseLogic.purchase(request);
		
	}


}

