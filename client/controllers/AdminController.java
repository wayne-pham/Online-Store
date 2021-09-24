package client.controllers;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import client.views.AdminView;
import server.common.AccountType;
import server.endpoints.RemoteDAO;
import server.models.Account;
import server.models.Product;

public class AdminController {
    // Attributes
    private RemoteDAO stub;
    private AdminView view;

    // Main
    public static void main(String[] args) {

    }

    // Constructor
    public AdminController() throws MalformedURLException, RemoteException, NotBoundException {
        String name = "//in-csci-rrpc01:2020/RemoteDAOImpl";
        this.stub = (RemoteDAO) Naming.lookup(name);
        this.view = new AdminView();
        System.out.println("\nSuccess! Admin API connected. Starting Program...\n\n");
    }

    // Methods
    public void printAccountInfo(Account account){
        view.viewAccountDetails(account);
    }

    public void printAllAccountsOnList() throws RemoteException {
        view.viewAccountList(stub.getAccounts());
    }

    public void printAllProductsOnList() throws RemoteException {
        view.viewProductList(stub.getProducts());
    }

    public void addProductToInventory(Scanner input) throws RemoteException {
        Product product = new Product();

        System.out.println("Enter Product Name:");
        String name = input.nextLine();
        product.setName(name);

        System.out.println("Enter Product Description:");
        String description = input.nextLine();
        product.setDescription(description);

        System.out.println("Enter Product Amount:");
        String inputAmount = input.nextLine();
        int amount = Integer.parseInt(inputAmount);
        product.setAmount(amount);

        System.out.println("Enter Product Price:");
        String inputPrice = input.nextLine();
        double price = Double.parseDouble(inputPrice);
        product.setPrice(price);

        stub.createProduct(product);
        System.out.println("Product Created.");
    }

    public void removeProductFromInventory(Scanner input) throws RemoteException {
        if(stub.getProducts().size() == 0){
            System.out.println("There are no products at the moment. Add some first.");
        }
        else{
            printAllProductsOnList();

            System.out.println("Select product to delete: \n");
            String selection = input.nextLine();

            // Convert string input to integer
            int index = Integer.parseInt(selection);

            // Confirmation to delete
            System.out.println("Are you sure you want to delete this product? This is permanent! \n");
            String confirmation = input.nextLine();
            confirmation.toLowerCase();

            if(confirmation.equals("yes")) {
                stub.deleteAccount(index);
                System.out.println("Product Deleted.");
            }
            else if(confirmation.equals("no")) {   
                System.out.println("Product Deletion Canceled.");
            }
            else{
                System.out.println("Invalid Response.");
                System.out.println("Product Deletion Canceled.");
            }

            stub.deleteProduct(index);
            System.out.println("Product Deleted.");
        }
    }

    public void updateProductInInventory(Scanner input) throws RemoteException {
        if(stub.getProducts().size() == 0){
            System.out.println("There are no products at the moment. Add some first.");
        }
        else{
            printAllProductsOnList();
            System.out.println("Select product to update: \n");
            String selection = input.nextLine();

            // Convert string input to integer
            int index = Integer.parseInt(selection);

            Product updatedProduct = new Product();

            System.out.println("Enter Product Name:");
            String name = input.nextLine();
            updatedProduct.setName(name);

            System.out.println("Enter Product Description:");
            String description = input.nextLine();
            updatedProduct.setDescription(description);

            System.out.println("Enter Product Amount:");
            String inputAmount = input.nextLine();
            int amount = Integer.parseInt(inputAmount);
            updatedProduct.setAmount(amount);

            System.out.println("Enter Product Price:");
            String inputPrice = input.nextLine();
            double price = Double.parseDouble(inputPrice);
            updatedProduct.setPrice(price);


            stub.updateProduct(index, updatedProduct);
            System.out.println("Product Updated.");
        }
    }
    
    public void addNewAccountToDatabase(Scanner input) throws RemoteException {
        Account account = new Account();
        
        System.out.println("Enter First Name");
        String firstName = input.nextLine();
        account.setFirstName(firstName);
        

        System.out.println("Enter Last Name");
        String lastName = input.nextLine();
        account.setLastName(lastName);
        

        System.out.println("Enter email");
        String email = input.nextLine();
        account.setEmail(email);
        

        System.out.println("Enter password.");
        String password = input.nextLine();
        account.setPassword(password);
        
        AccountType type = determineType(input);
        account.setType(type);
        System.out.println("Type is set.");

        stub.createAccount(account);
        System.out.println("Account Created.");
    }

    public void updateAccountInDatabase(Scanner input) throws RemoteException {
        
        if(stub.getAccounts().size() == 0){
            System.out.println("There are no accounts at the moment. Add some first.");
        }
        else{
            // show available accounts and prompt user to enter a number that corresponds to an account
            printAllAccountsOnList();
            System.out.println("Select account to update: \n");
            String selection = input.nextLine();

            // Convert string input to integer
            int index = Integer.parseInt(selection);

            Account updatedAccount = new Account();

            System.out.println("Enter First Name");
            String firstName = input.nextLine();
            updatedAccount.setFirstName(firstName);
            

            System.out.println("Enter Last Name");
            String lastName = input.nextLine();
            updatedAccount.setLastName(lastName);
            

            System.out.println("Enter email");
            String email = input.nextLine();
            updatedAccount.setEmail(email);
            

            System.out.println("Enter password.");
            String password = input.nextLine();
            updatedAccount.setPassword(password);
            
            AccountType type = determineType(input);
            updatedAccount.setType(type);
            System.out.println("Type is set.");        

            // Update account to Database.
            stub.updateAccount(index, updatedAccount);
            System.out.println("Account Updated.");
        }
        
    }

    public void removeAccountInDatabase(Scanner input) throws RemoteException {

        if(stub.getAccounts().size() == 0){
            System.out.println("There are no accounts at the moment. Add some first.");
        }
        else{
            // show available accounts and prompt user to enter a number that corresponds to an account
            printAllAccountsOnList();
            System.out.println("Select account to delete: \n");
            String selection = input.nextLine();

            // Convert string input to integer
            int index = Integer.parseInt(selection);

            // Confirmation to delete
            System.out.println("Are you sure you want to delete this account? This is permanent! \n");
            String confirmation = input.nextLine();
            confirmation.toLowerCase();

            if(confirmation.equals("yes")) {
                stub.deleteAccount(index);
                System.out.println("Account Deleted.");
            }
            else if(confirmation.equals("no")) {   
                System.out.println("Account Deletion Canceled.");
            }
            else{
                System.out.println("Invalid Response.");
                System.out.println("Account Deletion Canceled.");
            }
        }

    }

    public AccountType determineType(Scanner input){
        System.out.println("What type of account is this? ");
        System.out.println("1. Admin ");
        System.out.println("2. Customer ");
        AccountType type;
        int result = input.nextInt();
        if(result == 1){
            type = AccountType.ADMINISTRATOR;
    
        }
        else if(result == 2){
            type = AccountType.CUSTOMER;
        }
        else{
            System.out.println("Not a defined type.");
            System.out.println("New Account will default to type: Other");
            type = AccountType.OTHER;
        }
        return type;
    }
}
