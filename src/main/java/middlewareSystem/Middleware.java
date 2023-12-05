package middlewareSystem;

import java.util.ArrayList;

import modelSystem.connector.ReadProductMiddle;
import utilities.structure.ProductBasicInfo;

public class Middleware {
	public Middleware() {
		
	}
	
	public int matchNameToID(String productName) {
		ReadProductMiddle connect = new ReadProductMiddle();
		ArrayList<ProductBasicInfo> productList = connect.read();
		for (int i = 0; i < productList.size(); i++) {
			if (productName.equals(productList.get(i).getProductName())) {
				return productList.get(i).getProductID();
			}
		}
		return -1;
	}
}
