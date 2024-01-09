package org.DAO;

import org.DTO.Order;
import org.DTO.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImple implements Service{

    private static Connection connection;
    static {
        String url="jdbc:mysql://localhost:3306/jdbcTest2";
        try {
            connection= DriverManager.getConnection(url,"root","Redminote5@");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public List<Product> displayAllProduct() {
        String query="select * from product_info";
        List<Product> productList=new ArrayList<>();

        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()){
                Product product=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productList;
    }

    @Override
    public int removeProduct(int prodId) {
        String query="delete from product_info where prodId=?";
        try {
            PreparedStatement pstmt= connection.prepareStatement(query);
            pstmt.setInt(1,prodId);
           return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int updateProduct(int prodId, double prodPrice) {
        String query="Update product_info set prodPrice=? where prodId=?";
        try {
            PreparedStatement pstmt= connection.prepareStatement(query);
            pstmt.setDouble(1,prodPrice);
            pstmt.setInt(2,prodId);
           return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public boolean placeOrder(Order order) {
        String query="{call placeOrder(?,?,?)}";
        try {
            CallableStatement cstmt=connection.prepareCall(query);
            cstmt.setString(1,order.getCustomerName());
            cstmt.setInt(2,order.getProductId());
            cstmt.setInt(3,order.getProductQty());
            cstmt.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

    @Override
    public List<Order> displayAllOrder() {
        String query="Select * from Order_info";
        List<Order> orderList=new ArrayList<>();

        try {
            Statement statement= connection.createStatement();

            ResultSet rs=statement.executeQuery(query);
            while (rs.next()){
                Order order=new Order(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5));
                orderList.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderList;
    }
}
