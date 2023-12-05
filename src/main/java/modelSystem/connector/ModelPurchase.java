package modelSystem.connector;

import modelSystem.Model;
import modelSystem.functions.ModelUpdateProduct;
import utilities.structure.*;

public class ModelPurchase implements IModelWrite{

	public ModelPurchase() {
		
	}
	
	public void access(ProductBasicInfo request) {
		System.out.println("Purchase1");
		ModelUpdateProduct.DecreaseStoredProducts(request);
	}
	
	@Override
	public void accessModel(ProductBasicInfo request) {
		access(request);
	}

	@Override
	public void accessRestock(RestockRequest request) {
		//Do nothing
	}

}