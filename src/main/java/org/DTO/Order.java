package org.DTO;

public class Order {
    private int orderId;
    private String customerName;
    private int productQty;
    private int productId;
    private double totalBill;

    public Order() {
    }

    public Order(String customerName, int productQty, int productId) {
        this.customerName = customerName;
        this.productQty = productQty;
        this.productId = productId;
    }

    public Order(int orderId, String customerName, int productQty, int productId, double totalBill) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productQty = productQty;
        this.productId = productId;
        this.totalBill = totalBill;
    }

    public Order(String customerName, int productQty, int productId, double totalBill) {
        this.customerName = customerName;
        this.productQty = productQty;
        this.productId = productId;
        this.totalBill = totalBill;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}
