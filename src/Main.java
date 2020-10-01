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
        System.out.println("Danh sách lúc đầu: ");


        productManagement.add(new Product(9L, "Alo", "Ok", 399L, "Đây là phần mô tả"));
        listProduct = productManagement.findAll();
        displayList(listProduct);

        System.out.println("Ghi file....");
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

        System.out.println("Đọc file: ");
        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("BinaryProductList.txt"));
            List<Product> product = (ArrayList<Product>) readFile.readObject();
            for (int i = 0; i < product.size(); i++) {
                System.out.println(product.get(i).toString());
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
