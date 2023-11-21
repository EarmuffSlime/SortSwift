package utilities.structure;

public class ProductUpdate extends Update{
	private String productName;
	private int productAmount;
	
	private ProductUpdate(String name, int amount) {
		this.productName = name;
		this.productAmount = amount;
	}
	
	public static ProductUpdate createUpdate(String name, int amount) {
		return new ProductUpdate(name, amount);
	}

	public String getProductName() {
		return productName;
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
	
	public String printFullUpdate() {
		return ("Product " + this.productName + " has decreased by " + this.productAmount);
	}
}

