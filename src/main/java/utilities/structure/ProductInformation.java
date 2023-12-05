package utilities.structure;

public class ProductInformation {
	private int productID;
	private String name;
	private double price;
	private int quantity;
	private int maxQuantity;
	private int minQuantity;
	private int restockQuantity;
	private int discountID;
	//Pricing strategy coming soon
	
	private ProductInformation(int productID, String name, double price, int quantity, int max, int min,int restock, int discount) {
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.maxQuantity = max;
		this.minQuantity = min;
		this.discountID = discount;
	}
	
	public static ProductInformation createProduct(int productID, String name, double price, int quantity, int max, int min,int restock, int discount) {
		return new ProductInformation(productID, name, price, quantity,  max, min, restock, discount);
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		System.out.println(name);
		return name;
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}
	
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public int getMinQuantity() {
		return minQuantity;
	}
	
	public void setMinQuantity(int minQuantity) {
		this.minQuantity = minQuantity;
	}
	
	

	public int getRestockQuantity() {
		return restockQuantity;
	}

	public void setRestockQuantity(int restockQuantity) {
		this.restockQuantity = restockQuantity;
	}

	public int getDiscountID() {
		return discountID;
	}


	public void setDiscountID(int discountID) {
		this.discountID = discountID;
	}
	
}
