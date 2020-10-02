package service;

import model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductManagement implements Management<Product> {
    static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1L, "Iphone X", "Apple", 299L, "This is a smartphone"));
        products.add(new Product(2L, "Galaxy Note 10", "Samsung", 199L, "This is smartphone"));
        products.add(new Product(3L, "Redmi Note 8", "Xiaomi", 399L, "This a smartphone"));
        products.add(new Product(4L, "A93", "Oppo", 300L, "This is smartphone"));
        products.add(new Product(5L, "ROG Phone", "Asus", 500L, "This is smartphone"));
    }

    @Override
    public void add(Product product) {
        boolean flag = true;
        for (int i = 0; i < products.size(); i++) {
            if (product.getId() == products.get(i).getId()) {
                flag = false;
                break;
            }
        }
        if (flag) {
            products.add(product);
        }
    }

    @Override
    public void update(Long id, Product newObject) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.set(i, newObject);
            }
        }
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.remove(i);
            }
        }
    }

    @Override
    public Product findByID(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Product> findByCompanyName(String companyName) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (companyName.equals(product.getCompany())) {
                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            productList.add(iterator.next());
        }
        return productList;
    }
}