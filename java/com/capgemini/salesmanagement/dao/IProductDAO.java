package com.capgemini.salesmanagement.dao;

import com.capgemini.salesmanagement.bean.Product;

public interface IProductDAO {
	Product getProductDetails(int product_code);
	boolean insertSalesDetails(Product product);

}
