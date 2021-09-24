package client.views;

import java.util.List;

import server.models.Product;

public class CustomerView {
    
    public static void main(String[] args) {
        
    }

    public CustomerView(){
        
    }

    public void viewProductList(List<Product> productList){
        int number = 0;
        if(productList.size() == 0){
            System.out.println("There are currently no products in Inventory. \n");
        }
        else{
            for (Product product : productList) {
                System.out.println(number + ".");
                System.out.println("Product Name: " + product.getName());
                System.out.println("Product Description: " + product.getDescription());
                System.out.println("Amount in Inventory: " + product.getAmount());
                System.out.println("$" + product.getPrice());
                System.out.println("Product type: " + product.getType());
                System.out.println();
                number++;
            }
        }
    }
}
