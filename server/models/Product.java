package server.models;

import java.io.Serializable;
import java.util.UUID;

import server.common.ProductType;

public class Product implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Attributes
    private UUID id;
    private String name;
    private String description;
    private int amount;
    private ProductType type;
    private double price;
    
    public static void main(String[] args) {
        Product p1 = new Product().name("Roma Tomatoes").description("Great for soups.").price(3d).type(ProductType.FOOD);
        
        System.out.println("Product Id: " + p1.getId());
        System.out.println(p1.getName());
        System.out.println(p1.getDescription());
        System.out.println(p1.getPrice());
        System.out.println(p1.getType());

    }

    public Product(){
        this.id = UUID.randomUUID();
        this.amount = 0;
        this.name = "";
        this.description = "";
        this.price = 0d;
        this.type = ProductType.OTHER;
    }

    // Getters
    public UUID getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public ProductType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    // Fluent Builder Pattern
    public Product name(String name) {
        this.name = name;
        return this;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }

    public Product price(double price) {
        this.price = price;
        return this;
    }

    public Product type(ProductType type) {
        this.type = type;
        return this;
    }
    public Product amount(int amount){
        this.amount = amount;
        return this;
    }
}
