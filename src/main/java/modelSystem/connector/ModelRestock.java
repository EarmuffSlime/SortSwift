package modelSystem.connector;

import modelSystem.functions.ModelUpdateProduct;
import utilities.structure.ProductBasicInfo;

public class ModelRestock implements IModelWrite{

	public ModelRestock() {
		
	}
	
	private void access(ProductBasicInfo request) {
		ModelUpdateProduct.IncreaseStoredProducts(request.getProductID(), request.getProductAmount());
	}
	
	@Override
	public void accessModel(ProductBasicInfo request) {
		access(request);
		
	}

}
