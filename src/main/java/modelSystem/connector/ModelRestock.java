package modelSystem.connector;

import modelSystem.functions.ModelUpdateProduct;
import utilities.structure.ProductBasicInfo;
import utilities.structure.RestockRequest;

public class ModelRestock implements IModelWrite{

	public ModelRestock() {
		
	}
	
	public void access(RestockRequest request) {
		System.out.println("Restock1");
		ModelUpdateProduct.IncreaseStoredProducts(request);
	}
	
	@Override
	public void accessModel(ProductBasicInfo request) {
		//Do nothing
	}

	@Override
	public void accessRestock(RestockRequest request) {
		access(request);
		
	}

}
