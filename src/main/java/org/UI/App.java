package org.UI;

import org.DAO.Service;
import org.DAO.ServiceImple;
import org.DTO.Order;
import org.DTO.Product;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner scanner=new Scanner(System.in);
    static Service service=new ServiceImple();
    public static void main( String[] args )
    {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Select mode of Operation");
        System.out.println("1.Display All Product");
        System.out.println("2.Update product Price");
        System.out.println("3.Remove Product");
        System.out.println("4. Place Order");
        System.out.println("5. Display All Orders");
        System.out.println("6.exit");
        int choise=scanner.nextInt();

        switch (choise){
            case 1:
                displayProd();
                break;
            case 2:
                updateProd();
                break;
            case 3:
                removeProd();
                break;
            case 4:
                placeOrd();
                break;
            case 5:
                displayAllOrd();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input");

        }
        main(args);
    }

    private static void displayAllOrd() {
        System.out.println("orderId \t CustomerName \t productId \t prodQty \t totalBill");
        System.out.println("===============================================================");
        for (Order o:service.displayAllOrder()) {
            System.out.println(o.getOrderId()+"\t"+o.getCustomerName()+"\t"+o.getProductId()+"\t"+o.getProductQty()+"\t"+o.getTotalBill());
        }
        System.out.println("===============================================================");

    }

    private static void placeOrd() {
        System.out.println("Enter Customer Name");
        String name=scanner.next();
        System.out.println("Enter Product Id");
        int id=scanner.nextInt();
        System.out.println("Enter Product Qty");
        int qty=scanner.nextInt();

        Order order=new Order(name,qty,id);
        boolean status=false;
        status=service.placeOrder(order);
        if (status){
            System.out.println("Order placed Successfully !! ");
        }else {
            System.out.println("Order Not placed " +
                    "Something went worng");
        }
    }

    private static void removeProd() {
        System.out.println("Enter Prod Id to delete product");
        int prodId=scanner.nextInt();
        int n= service.removeProduct(prodId);
        if (n!=0){
            System.out.println("Product Deleted Successfully");
        }else {
            System.out.println("Product not Deleted" +
                    "Something went Wrong !!");
        }
    }

    private static void updateProd() {
        System.out.println("Enter Prod Id");
        int prodId=scanner.nextInt();
        System.out.println("Enter updated Product Price");
        double upPrice=scanner.nextDouble();

        int n= service.updateProduct(prodId,upPrice);
        if (n!=0){
            System.out.println("Product Price Update Successfully");
        }else {
            System.out.println("Product not Updated" +
                    "Something went Wrong !!");
        }

    }


    private static void displayProd() {
        System.out.println("ProductID   ProductName    Price     Qty");
        System.out.println("===========================================");
        for (Product p: service.displayAllProduct()) {
            System.out.println(p.getProdId()+"\t\t"+p.getProdName()+"\t\t"+p.getProdPrice()+"\t\t"+p.getProdQty());
        }
        System.out.println("===========================================");
    }
}
