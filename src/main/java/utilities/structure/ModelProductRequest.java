package utilities.structure;

public class ModelProductRequest extends Request{
	private int productID;
	private int productAmount;
	
	public ModelProductRequest(int productID, int amount) {
		this.productID = productID;
		this.productAmount = amount;
	}
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	
}
