package utilities.structure;

public class ProductInformation {
	private int productID;
	private String name;
	private int price;
	private int quantity;
	//Pricing strategy coming soon
	
	private ProductInformation(int productID, String name, int price, int quantity) {
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public static ProductInformation createProduct(int productID, String name, int price, int quantity) {
		return new ProductInformation(productID, name, price, quantity);
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
