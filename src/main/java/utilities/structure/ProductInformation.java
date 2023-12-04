package utilities.structure;

public class ProductInformation {
	private int productID;
	private String name;
	private int price;
	private int quantity;
	private int PrcStrategy;
	private int MaxQuantity;
	private int MinQuantity;
	private int RestQuantity;
	//Pricing strategy coming soon
	
	private ProductInformation(int productID, String name, int price, int quantity, int PrcStrategy, int MaxQuantity, int MinQuantity, int RestQuantity ) {
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
			this.PrcStrategy = PrcStrategy;
			this.MaxQuantity = MaxQuantity;
			this.MinQuantity = MinQuantity;
			this.RestQuantity = RestQuantity;
	}
	
	public static ProductInformation createProduct(int productID, String name, int price, int quantity, int PrcStrategy, int MaxQuantity, int MinQuantity, int RestQuantity ) {
		return new ProductInformation(productID, name, price, quantity, PrcStrategy, MaxQuantity, MinQuantity, RestQuantity);
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
	
	public int getPrcStrategy() {
		return PrcStrategy;
	}
	
	public void setPrcStrategy(int PrcStrategy ) {
		this.PrcStrategy = PrcStrategy;
		
	}

	public int getMaxQuantity() {
		return MaxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.MaxQuantity = maxQuantity;
	}

	public int getMinQuantity() {
		return MinQuantity;
	}

	public void setMinQuantity(int minQuantity) {
		this.MinQuantity = minQuantity;
	}

	public int getRestQuantity() {
		return RestQuantity;
	}

	public void setRestQuantity(int restQuantity) {
		this.RestQuantity = restQuantity;
	}
	
	
}
