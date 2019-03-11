package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.bean.Product;

public interface IProductService {
	Product getProductDetails(int product_code);
	 boolean insertSalesDetails(Product product);
	

}
