package modelSystem.connector;

import java.util.ArrayList;

import modelSystem.functions.GetProductSpecific;
import modelSystem.functions.GetProductViewerInfo;

public class ReadProductFull implements IModelRead{

	@Override
	public ArrayList read(int arg) {
		if (arg == 1) { //Get Viewers Startup Information
			return GetProductViewerInfo.execute();
		}
		else if (arg == 2) { //Get Specific Product Information
			return GetProductSpecific.execute();
		}
		return null;
	}

}
