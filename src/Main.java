import model.Product;
import service.ProductManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> listProduct = new ArrayList<>();
        ProductManagement productManagement = new ProductManagement();
        listProduct = productManagement.findAll();
        System.out.println("List: ");


        productManagement.add(new Product(9L, "Note 7", "Samsung", 299L, "This is a smartphone!"));
        listProduct = productManagement.findAll();
        displayList(listProduct);

        listProduct = productManagement.findAll();

        System.out.println();
        System.out.println("Writing file...");
        System.out.println();

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("BinaryProductList.txt"));
            for (int i = 0; i < listProduct.size(); i++) {
                outputStream.writeObject(listProduct);
            }

            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Reading file: ");
        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("BinaryProductList.txt"));
            List<Product> productList = (ArrayList<Product>) readFile.readObject();
            for (int i = 0; i < productList.size(); i++) {
                System.out.println(productList.get(i).toString());
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void displayList(List<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
