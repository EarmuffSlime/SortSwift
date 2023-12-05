package modelSystem.functions;

import java.util.ArrayList;

import modelSystem.Model;
import utilities.structure.ProductBasicInfo;

public class GetProductID {
	public GetProductID() {
		
	}
	
	public ArrayList<ProductBasicInfo> execute(){
		ArrayList<ProductBasicInfo> productBasicList = new ArrayList<ProductBasicInfo>();
		ArrayList<Integer> idList = Model.getModel().getidList();
		for (int i = 0; i < idList.size(); i++) {
			ProductBasicInfo product = new ProductBasicInfo(
					Model.getModel().getProductListing().get(idList.get(i)).getProductID(),
					Model.getModel().getProductListing().get(idList.get(i)).getName()
					);
			productBasicList.add(product);
		}
		return productBasicList;
	}
}
