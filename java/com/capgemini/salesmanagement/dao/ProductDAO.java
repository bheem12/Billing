package com.capgemini.salesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.Scanner;

import com.capgemini.salesmanagement.bean.Product;
import com.capgemini.salesmanagement.database.DataBase;

public class ProductDAO implements IProductDAO{
	Scanner sc=new Scanner(System.in);
	
	
	public Product getProductDetails(int product_code) {
		DataBase db = new DataBase();
		Connection connection = db.myConnection();
	
		Product product=new Product(); 
		 try {
				PreparedStatement ps =connection.prepareStatement("select * from product where product_code = ?");
				ps.setInt(1, product_code);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					product.setProduct_code(product_code);
					product.setProduct_name(rs.getString(2));
					product.setProduct_category(rs.getString(3));
					product.setProduct_description(rs.getString(4));
					product.setProduct_price(rs.getInt(5));
				}
		 }
				
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

		return product ;
	}

	public boolean insertSalesDetails(Product product) {
		DataBase db = new DataBase();
		Connection connection = db.myConnection();
	
		boolean isInsert = false;
		int line_total = product.getProduct_price() * product.getQuantity();  
		try {
			
			
			PreparedStatement ps = connection.prepareStatement("insert into sales values(?,?,?,?,?)");
			ps.setInt(1, 10000 + new Random().nextInt(90000));
			ps.setInt(2, product.getProduct_code());
			ps.setInt(3, product.getQuantity());
			ps.setDate(4,Date.valueOf(LocalDate.now()));
			ps.setInt(5, line_total);
			int i = ps.executeUpdate();
			if(i == 1)
				isInsert = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isInsert;
	}
}
