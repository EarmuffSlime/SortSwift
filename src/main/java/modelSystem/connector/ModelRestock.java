package modelSystem.connector;

import modelSystem.functions.ModelUpdateProduct;
import utilities.structure.ModelProductRequest;
import utilities.structure.Request;

public class ModelRestock implements IModelWrite{

	private void access(ModelProductRequest request) {
		ModelUpdateProduct.IncreaseStoredProducts(request.getProductID(), request.getProductAmount());
	}
	
	@Override
	public void accessModel(ModelProductRequest request) {
		access(request);
		
	}

}
