import model.Product;
import service.ProductManagement;
import service.TextFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> listProduct = new ArrayList<>();
        ProductManagement productManagement = new ProductManagement();
        listProduct = productManagement.findAll();
        System.out.println("- List: ");

        productManagement.add(new Product(6L, "Note 7", "Samsung", 299L, "Samsung Note 7 was created by Samsung!"));
        productManagement.add(new Product(7L, "Iphone 8", "Apple", 255L, "This is a smartphone!"));
        productManagement.add(new Product(8L, "Iphone 5", "Apple", 199L, "This is a smartphone!"));
        productManagement.add(new Product(9L, "Iphone 4s", "Apple", 120L, "This is a smartphone!"));
        listProduct = productManagement.findAll();
        displayList(listProduct);

        listProduct = productManagement.findAll();

        listProduct = productManagement.findByCompanyName("Apple");

        TextFile writingFile = new TextFile();
        writingFile.writeFile("BinaryProductList.txt", listProduct);

        TextFile readingFile = new TextFile();
        readingFile.readFile("BinaryProductList.txt");
    }

    public static void displayList(List<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
