package exercise1610;

public class Store {
	private int productId;  
	private String productName;  
	private int price;
	private int quantity;
	
    public Store(int personId, String productName, int price, int quantity) {
        super();
        this.productId = personId;
        this.productName = productName;
        this.price =  price;
        this.quantity = quantity;
    }
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
