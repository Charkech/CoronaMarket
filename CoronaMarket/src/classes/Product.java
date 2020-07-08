package classes;

abstract class Product {
	static private int ProductID=1;
	public void getProductID() {System.out.println(ProductID);}
	private String ProductName;
	public void getProductName() {System.out.println(ProductName);}
	private double Price;
	public double getPrice() {return Price;}
	private int InStock;
	public int getInStock() {return InStock;}
	}
