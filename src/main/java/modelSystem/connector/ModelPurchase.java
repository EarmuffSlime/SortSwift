package modelSystem.connector;

import modelSystem.Model;
import modelSystem.functions.ModelUpdateProduct;
import utilities.structure.*;

public class ModelPurchase implements IModelWrite{

	public ModelPurchase() {
		
	}
	
	private void access(ProductBasicInfo request) {
		ModelUpdateProduct.DecreaseStoredProducts(request.getProductID(), request.getProductAmount());
	}
	
	@Override
	public void accessModel(ProductBasicInfo request) {
		access(request);
	}

}