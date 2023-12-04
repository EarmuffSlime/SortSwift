package modelSystem.connector;

import java.util.ArrayList;

import modelSystem.Model;
import modelSystem.functions.GetProductNames;
import utilities.structure.ProductInformation;

public class ReadProductClient implements IModelRead{

	@Override
	public ArrayList read() {
		return new GetProductNames().execute();
	}

	@Override
	public ProductInformation readSpecific(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
