package modelSystem.functions;

import java.util.ArrayList;

import modelSystem.Model;

public class GetProductNames {
	public static ArrayList<String> execute() {
		ArrayList<String> productNameList = new ArrayList<String>();
		ArrayList<Integer> idList = Model.getModel().getidList();
		for (int i = 0; i < idList.size(); i++) {
			productNameList.add(Model.getModel().getProductListing().get(idList.get(i)).getName());
		}
		return productNameList;
	}
}
