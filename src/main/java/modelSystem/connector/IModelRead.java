package modelSystem.connector;

import java.util.ArrayList;

import utilities.structure.ProductInformation;

public interface IModelRead {
	public ArrayList read();
	public ProductInformation readSpecific(int id);
	
}
