package utilities.structure;

public class RestockUpdate extends Update{

	private String productName;
	private int productAmount;
	private int restockAmount;
	
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

	public int getRestockAmount() {
		return restockAmount;
	}

	public void setRestockAmount(int restockAmount) {
		this.restockAmount = restockAmount;
	}

	@Override
	public String printFullUpdate() {
		// TODO Auto-generated method stub
		return null;
	}	
}
