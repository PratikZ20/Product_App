package Product_App;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static Service service = new Service();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("SELECT THE OPTION ");
        System.out.println("1. Product Manager");
        System.out.println("2. Customer");

        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                Product();
                break;
            case 2:
               Order();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("invalid input");
        }
        main(args);
    }

    public static void Product() {
        System.out.println("Admin have access to perform the following actions");
        System.out.println("1. ADD NEW PRODUCT :");
        System.out.println("2. REMOVE PRODUCT :");
        System.out.println("3. UPDATE PRODUCT :");
        System.out.println("4. PLACE ORDER :");
        System.out.println("5. DISPLAY ALL Orders :");
        int ch1 = sc.nextInt();
        switch (ch1) {
            case 1:
                addNewProduct();
                break;
            case 2:
                deletedProduct();
                break;
            case 3:
               updatedProduct();
                break;
            case 4:
                displayAllProduct();
                break;
            case 5:
                placeOrder();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("invalid input");
        }
    }
    public static void addNewProduct() {
        System.out.println("Enter the product id:");
        int productId = sc.nextInt();
        System.out.println("Enter the product Name:");
        String productName = sc.next();
        System.out.println("Enter the product price:");
        double productPrice = sc.nextDouble();
        System.out.println("Enter the product quantity:");
        int productQuantity = sc.nextInt();

        Product newProduct = new Product(productId, productName, productPrice, productQuantity);
        int n = service.addNewProduct(newProduct);
        System.out.println("Product added successfully");
    }

    private static void deletedProduct() {
        System.out.println("Enter the product name to delete:");
        String productName = sc.next();

        int rowsDeleted = service.deleteProductByName(productName);

        if (rowsDeleted > 0) {
            System.out.println("Product deleted successfully");
        } else {
            System.out.println("Failed to delete product. Product not found.");
        }
    }

    private static void updatedProduct() {
        System.out.println("Enter the product name to update:");
        String productName = sc.next();
        System.out.println("Enter the new price:");
        double newPrice = sc.nextDouble();

        int rowsUpdated = service.updateProductByName(productName, newPrice);

        if (rowsUpdated > 0) {
            System.out.println("Product updated successfully");
        } else {
            System.out.println("Failed to update product");
        }
    }

    private static void placeOrder() {
    }


    public static void displayAllProduct() {
        List<Product> products = service.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("All Products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public static void Order() {
        System.out.println("Customer can do the following task");
        System.out.println("1. PLACE THE ORDER :");
        System.out.println("2. CANCEL THE ORDER :");
        System.out.println("3. DISPLAY ALL ORDER :");


        int ch2 = sc.nextInt();
        switch (ch2) {
            case 1:
                placeOrder();
                break;
            case 2:
                // cancelOrder();
                break;
            case 3:
                // displayAllOrder();
                break;
            default:
                System.out.println("invalid input");
        }
    }

}
