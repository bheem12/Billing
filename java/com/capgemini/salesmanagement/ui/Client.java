package com.capgemini.salesmanagement.ui;

import java.util.Scanner;

import com.capgemini.salesmanagement.bean.Product;
import com.capgemini.salesmanagement.service.IProductService;
import com.capgemini.salesmanagement.service.ProductService;

public class Client {
	public static void main(String args[]) {
		IProductService ProductService=new ProductService();
		Product product=new Product();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter product code");
		int product_code=sc.nextInt();
		product.setProduct_code(product_code);
		if(product_code > 1000 && product_code < 1005)
		{
		System.out.println("enter quantity");
		int quantity=sc.nextInt();
		if(quantity>0) {
		//IProductService ProductService=new ProductService();
			product = ProductService.getProductDetails(product_code);
			product.setQuantity(quantity);
			if(ProductService.insertSalesDetails(product))
			{
				System.out.println("Product Details");
				System.out.println("Product Name:"+product.getProduct_name());
				System.out.println("Product Category:"+product.getProduct_category());
				System.out.println("Product Description:"+product.getProduct_description());
				System.out.println("Product Price:"+product.getProduct_price());
				System.out.println("Quantity:"+quantity);
				System.out.println("Line Total(Rs):"+(product.getProduct_price()*quantity));
			}
			
				
			
		}
		}
	}
}
		
	


