package model;

import java.io.Serializable;

public class Product implements Serializable {
    private long id;
    private String name;
    private String company;
    private long price;
    private String description;

    public Product() {
    }

    public Product(long id, String name, String company, long price, String description) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", company = '" + company + '\'' +
                ", price = " + price + "$" +
                ", description = '" + description + '\'' +
                '}';
    }
}
