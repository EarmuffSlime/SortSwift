package modelSystem.connector;

import java.util.ArrayList;

import modelSystem.Model;
import modelSystem.functions.GetProductSpecific;
import utilities.structure.ProductInformation;

public class ReadProductController implements IModelRead{

	public ReadProductController() {
		
	}
	
	@Override
	public ArrayList read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductInformation readSpecific(int id) {
		return new GetProductSpecific().execute(id);
	}

}
