package modelSystem.connector;

import modelSystem.Model;
import modelSystem.functions.ModelUpdateProduct;
import utilities.structure.*;

public class ModelProductAccess implements IModelInterface{

	public static void accessModel(ModelProductRequest request) {
		ModelUpdateProduct.updateProducts(request.getProductID(), request.getProductAmount());
	}

	@Override
	public void accessModel(Request request) {
		// TODO Auto-generated method stub
		
	}

}