package modelSystem.connector;

import modelSystem.functions.ModelUpdateProduct;
import utilities.structure.ModelProductRequest;

public class ModelPurchase implements IModelWrite{

	private void purchaseModel(ModelProductRequest request) {
		ModelUpdateProduct.decreaseProducts(request.getProductID(), request.getProductAmount());
	}

	public void accessModel(ModelProductRequest request) {
		purchaseModel(request);
		
	}
}