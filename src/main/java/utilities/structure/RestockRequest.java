package utilities.structure;

public class RestockRequest extends Request{
	private int productID;
	private int productAmount;
	private int restockCount;
	
	public RestockRequest(int id, String name, int amount, int count) {
		this.productName = name;
		this.productID = id;
		this.productAmount = amount;
		this.restockCount = count;
	}
	
	

	public int getRestockCount() {
		return restockCount;
	}

	public void setRestockCount(int restockCount) {
		this.restockCount = restockCount;
	}
	
}
