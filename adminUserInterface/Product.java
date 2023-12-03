package adminUserInterface;

public class Product {
	private String name;
	private int qty;
	
	public Product() {
		name = "";
		qty = 0;
	}
	
	public Product(String name, int qty) {
		this.name = name ;
		this.qty = qty;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQty() {
		return qty;
	}
}
