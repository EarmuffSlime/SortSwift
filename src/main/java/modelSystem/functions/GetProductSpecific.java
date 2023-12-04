package modelSystem.functions;

import java.util.ArrayList;

import modelSystem.Model;
import utilities.structure.ProductInformation;

public class GetProductSpecific {

	public GetProductSpecific() {
		
	}
	
	public ProductInformation execute(int id) {
		return Model.getModel().getProductListing().get(id);
	}

}
