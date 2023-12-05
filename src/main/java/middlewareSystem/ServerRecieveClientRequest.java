package middlewareSystem;

import utilities.structure.Request;
import controllerSystem.connector.ControllerProductPurchase;
import utilities.structure.*;

public class ServerRecieveClientRequest implements IMiddleInterface{

	public String communicate(String productName, String productAmount) {
		
		System.out.println("Middleware1");
		
		int productID = new Middleware().matchNameToID(productName);
		
		System.out.println("Middleware2");
		
		ProductBasicInfo newRequest = new ProductBasicInfo(productID, Integer.parseInt(productAmount));
		
		System.out.println("Middleware3");
		
		ControllerProductPurchase connect = new ControllerProductPurchase();
		
		System.out.println("Middleware4");
		
		return connect.access(newRequest);
		
	}

}
