package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.bean.Product;
import com.capgemini.salesmanagement.dao.IProductDAO;
import com.capgemini.salesmanagement.dao.ProductDAO;

public class ProductService implements IProductService {
	IProductDAO ProductService=new ProductDAO();
	
	public Product getProductDetails(int product_code) {
		
		
		Product product=ProductService.getProductDetails(product_code);
		return product;
	}

	public boolean insertSalesDetails(Product product) {
		// TODO Auto-generated method stub
		boolean b=ProductService.insertSalesDetails(product);
		return b;
	}

}
