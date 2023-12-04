package modelSystem.connector;

import java.util.ArrayList;

import modelSystem.Model;
import modelSystem.functions.GetProductNames;

public class ReadProductNames implements IModelRead{

	@Override
	public ArrayList read(int arg) {

		return GetProductNames.execute();
	}

}
