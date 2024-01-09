package org.DAO;

import org.DTO.Order;
import org.DTO.Product;

import java.util.List;

public interface Service {
    List<Product> displayAllProduct();
    int removeProduct(int prodId);

    int updateProduct(int prodId,double prodPrice);
    boolean placeOrder(Order order);

    List<Order> displayAllOrder();
}
