package entities;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	protected String name;
	protected Double price;
	
	List<Product> products = new ArrayList<>();
	
	public Product() {
	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public void removeProduct(Product p) {
		products.remove(p);
	}
	
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("PRICE TAGS:%n", ""));
		for(Product p : products) {
			sb.append(String.format("%s", p.getName()));
			sb.append(String.format(" $ %.2f", p.getPrice()));
		}
		
		return sb.toString();
	}
	
}
