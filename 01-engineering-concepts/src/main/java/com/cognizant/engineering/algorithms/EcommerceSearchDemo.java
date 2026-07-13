package com.cognizant.engineering.algorithms;

import java.util.Arrays;
import java.util.Comparator;

record Product(int productId, String productName, String category) {
}

public class EcommerceSearchDemo {
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, String name) {
        int low = 0;
        int high = sortedProducts.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int comparison = sortedProducts[mid].productName().compareToIgnoreCase(name);
            if (comparison == 0) return sortedProducts[mid];
            if (comparison < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(103, "Keyboard", "Electronics"),
            new Product(101, "Laptop", "Electronics"),
            new Product(104, "Notebook", "Stationery"),
            new Product(102, "Mouse", "Electronics")
        };
        Product[] sorted = products.clone();
        Arrays.sort(sorted, Comparator.comparing(Product::productName, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Linear search: " + linearSearch(products, "Mouse"));
        System.out.println("Binary search: " + binarySearch(sorted, "Mouse"));
        System.out.println("Linear: O(n). Binary on sorted data: O(log n), so binary is better for large searchable catalogs.");
    }
}
