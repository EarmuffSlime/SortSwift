package modelSystem.connector;

import java.util.ArrayList;

import modelSystem.functions.GetProductSpecific;
import modelSystem.functions.GetProductViewerInfo;
import utilities.structure.ProductInformation;

public class ReadProductViewers implements IModelRead{

	public ReadProductViewers() {
		
	}
	
	@Override
	public ArrayList read() {
		return new GetProductViewerInfo().execute();
	}

	@Override
	public ProductInformation readSpecific(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
