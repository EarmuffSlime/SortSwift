package modelSystem.connector;

import java.util.ArrayList;

import modelSystem.functions.GetProductID;
import utilities.structure.ProductInformation;

public class ReadProductMiddle implements IModelRead{

	@Override
	public ArrayList read() {
		return new GetProductID().execute();
	}

	@Override
	public ProductInformation readSpecific(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
