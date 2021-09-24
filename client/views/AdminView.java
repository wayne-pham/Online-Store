package client.views;

import java.util.List;

import server.models.Account;
import server.models.Product;

public class AdminView {

    public static void main(String[] args) {
 
    }
    
    // Constructors
    public AdminView(){

    }

    // Methods

    // AccountDatabase
    public void viewAccountDetails(Account account){
        System.out.println(account.getFirstName());
        System.out.println(account.getLastName());
        System.out.println(account.getEmail());
        System.out.println(account.getType());
    }

    public void viewAccountList(List<Account> accountList){
        int number = 0;
        if(accountList.size() == 0){
            System.out.println("There are currently no accounts in the Database. \n");
        }
        else{
            for (Account account : accountList) {
                System.out.println(number + ".");
                System.out.println(account.getFirstName());
                System.out.println(account.getLastName());
                System.out.println(account.getEmail());
                System.out.println(account.getType());
                System.out.println();
                number++;
            }
        }
    }


    // Inventory
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

    public void viewProductDetails(Product product){
        System.out.println(product.getName());
        System.out.println(product.getDescription());
        System.out.println(product.getAmount());
        System.out.println(product.getPrice());
        System.out.println(product.getType());
    }

}
