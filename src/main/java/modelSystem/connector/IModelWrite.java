package modelSystem.connector;

import utilities.structure.*;

public interface IModelWrite {
	public abstract void accessModel(ProductBasicInfo request);
	public abstract void accessRestock(RestockRequest request);

}
