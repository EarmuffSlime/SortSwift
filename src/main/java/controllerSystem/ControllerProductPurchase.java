package controllerSystem;

import utilities.structure.ProductBasicInfo;
import utilities.structure.Request;

public class ControllerProductPurchase implements IController{

	public void access(ProductBasicInfo request) {
		//Call function controlerPuchaseLogic
		ControllerPurchaseLogic.purchase(request);
		
	}

	@Override
	public void access(Request request) {
		// TODO Auto-generated method stub
		
	}

}

