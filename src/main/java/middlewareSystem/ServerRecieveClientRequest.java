package middlewareSystem;

import utilities.structure.Request;
import controllerSystem.connector.ControllerProductPurchase;
import utilities.structure.*;

public class ServerRecieveClientRequest implements IMiddleInterface{

	public String communicate(String productName, String productAmount) {
		
		int productID = new Middleware().matchNameToID(productName);
		
		ProductBasicInfo newRequest = new ProductBasicInfo(productID, Integer.parseInt(productAmount));
		
		ControllerProductPurchase connect = new ControllerProductPurchase();
		
		return connect.access(newRequest);
		
	}

}
