package modelSystem.connector;

import modelSystem.functions.ModelUpdateProduct;
import utilities.structure.ModelProductRequest;

public class ModelRestock implements IModelWrite{

	private void restockModel(ModelProductRequest request) {
		ModelUpdateProduct.decreaseProducts(request.getProductID(), request.getProductAmount());
	}
	
	@Override
	public void accessModel(ModelProductRequest request) {
		restockModel(request);		
	}

}
