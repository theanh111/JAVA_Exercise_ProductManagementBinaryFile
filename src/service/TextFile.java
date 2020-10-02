package service;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFile {
    public void writeFile(String pathname, List<Product> list) {
        System.out.println("- Writing file...");
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(pathname));
            for (int i = 0; i < list.size(); i++) {
                outputStream.writeObject(list);
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readFile(String pathname) {
        System.out.println("- Reading file... ");
        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(pathname));
            List<Product> productList = (ArrayList<Product>) readFile.readObject();
            for (int i = 0; i < productList.size(); i++) {
                System.out.println(productList.get(i).toString());
            }
            readFile.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
