// ShopEase.java
// Simple Java Console Program to simulate an E-Commerce Application

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class ShopEase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Authentication Page
        System.out.println("======================================");
        System.out.println("           SHOP EASE LOGIN            ");
        System.out.println("======================================");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (!username.equals("admin") || !password.equals("1234")) {
            System.out.println("Invalid Login Credentials!");
            return;
        }

        System.out.println("\nLogin Successful!");
        System.out.println("\n======================================");
        System.out.println("             DASHBOARD                ");
        System.out.println("======================================");
        System.out.println("Welcome to ShopEase");
        System.out.println("Big Summer Sale - Up to 70% Off!");

        // Category Section
        System.out.println("\nShop by Category:");
        System.out.println("1. Gadgets");
        System.out.println("2. Beauty");
        System.out.println("3. Fashion");

        System.out.print("\nSelect Category (1-3): ");
        int category = sc.nextInt();

        if (category != 1) {
            System.out.println("Only Gadgets category is available in this demo.");
        }

        // Product Catalog
        Product[] products = {
            new Product(1, "Wireless Gaming Mouse", 899),
            new Product(2, "Smartwatch Series 7", 2999),
            new Product(3, "4G Android Tablet", 7999)
        };

        System.out.println("\n======================================");
        System.out.println("            PRODUCT CATALOG           ");
        System.out.println("======================================");

        for (Product p : products) {
            System.out.println(p.id + ". " + p.name + " - Rs." + p.price);
        }

        // Cart Management
        ArrayList<Product> cart = new ArrayList<>();

        while (true) {
            System.out.print("\nEnter Product ID to Add to Cart (0 to Finish): ");
            int choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            boolean found = false;
            for (Product p : products) {
                if (p.id == choice) {
                    cart.add(p);
                    System.out.println(p.name + " added to cart.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Invalid Product ID!");
            }
        }

        // Display Cart
        System.out.println("\n======================================");
        System.out.println("          YOUR SHOPPING CART          ");
        System.out.println("======================================");

        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            double total = 0;

            for (Product p : cart) {
                System.out.println("- " + p.name + " - Rs." + p.price);
                total += p.price;
            }

            System.out.println("--------------------------------------");
            System.out.println("Total Amount: Rs." + total);
        }

        System.out.println("\nThank you for shopping with ShopEase!");
        sc.close();
    }
}