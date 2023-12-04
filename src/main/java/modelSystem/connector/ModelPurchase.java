package modelSystem.connector;

import modelSystem.Model;
import modelSystem.functions.ModelUpdateProduct;
import utilities.structure.*;

public class ModelPurchase implements IModelWrite{

	private void access(ModelProductRequest request) {
		ModelUpdateProduct.DecreaseStoredProducts(request.getProductID(), request.getProductAmount());
	}
	
	@Override
	public void accessModel(ModelProductRequest request) {
		access(request);
	}

}