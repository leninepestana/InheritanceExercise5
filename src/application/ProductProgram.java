package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class ProductProgram {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Product products = new Product();
				
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
						
			if(Character.toLowerCase(ch) == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				Product prod = new UsedProduct(name, price, manufactureDate);
				products.addProduct(prod);
			}
			else if(Character.toLowerCase(ch) == 'i'){
				System.out.print("Custom fee: ");
				double customFee = sc.nextDouble();
				Product prod = new ImportedProduct(name, price, customFee);
				products.addProduct(prod);
			}
			else {
				Product prod = new Product(name, price);
				products.addProduct(prod);
			}
		
		}
		
		System.out.println();
		
		System.out.println(products.priceTag());

	
		sc.close();
	}

}
