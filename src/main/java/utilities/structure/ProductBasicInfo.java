package utilities.structure;

public class ProductBasicInfo extends Request{
	private int productID;
	private String productName;
	private int productAmount;
	
	public ProductBasicInfo(int productID, int amount) {
		this.productID = productID;
		this.productAmount = amount;
	}
	
	public ProductBasicInfo(String productName, int amount) {
		this.productName = productName;
		this.productAmount = amount;
	}
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	
}
