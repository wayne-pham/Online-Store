package client.frontController;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import client.controllers.AdminController;
import client.controllers.CustomerController;
import client.views.AdminView;
import client.views.CustomerView;

public class FrontController {

    AdminController adminController;
    CustomerController customerController;
    AdminView adminView;
    CustomerView customerView;

    public static void main(String[] args) {

    }

    public FrontController() throws MalformedURLException, RemoteException, NotBoundException {
        this.adminController = new AdminController();
        this.customerController = new CustomerController();
    }

    public void mainMenu(Scanner input) throws RemoteException {
        printAccountTypes();
        String selection = input.nextLine();
        if(selection.equals("1")) {
            runCustomerPrompt(input);
        }
        else if(selection.equals("2")) {
            runAdminPrompt(input);
        }
        else if(selection.equals("3")) {
            System.out.println("Thank you for shopping with us. Come back soon!");
        }
        else{
            System.out.println("Not a valid option. Please try again!");
        }
    }

    public AdminController administrator(){
        return adminController;
    }

    public CustomerController customer(){
        return customerController;
    }

    public void printAccountTypes(){
        System.out.println("1. Customer");
        System.out.println("2. Administrator");
        System.out.println("3. Stop Program");
    }

    public void runAdminPrompt(Scanner input) throws RemoteException {
        // sentry variable
        boolean inSession = true;

        while (inSession) {
            // print the menu
            printAdminMenu();

            // Get user input
            String result = input.nextLine();

            // determine which method to run
            // based on user input
            if (result.equals("1")) {
                System.out.println("Option 1");
                adminController.printAllProductsOnList();
            } 
            else if (result.equals("2")) {
                System.out.println("Option 2");
                adminController.printAllAccountsOnList();
            } 
            else if (result.equals("3")) {
                System.out.println("Option 3");
                adminController.updateAccountInDatabase(input);
            }
            else if (result.equals("4")) {
                System.out.println("Option 4");
                adminController.updateProductInInventory(input);
            } 
            else if (result.equals("5")) {
                System.out.println("Option 5");
                adminController.addNewAccountToDatabase(input);
            } 
            else if (result.equals("6")) {
                System.out.println("Option 6");
                adminController.addProductToInventory(input);
            }  
            else if (result.equals("7")) {
                System.out.println("Option 7");
                adminController.removeAccountInDatabase(input);
            } 
            else if (result.equals("8")) {
                System.out.println("Option 8");
                adminController.removeProductFromInventory(input);
            } 
            else if (result.equals("9")) {
                System.out.println("Thank you for shopping with us. Come back soon! <-- Obligatory by company's policy");
                inSession = false;
            } 
            else {
                System.out.println("Not a valid option. Please try again!");
            }
        } // end while
    }

    public void runCustomerPrompt(Scanner input) throws RemoteException {
        boolean inSession = true;

        while(inSession){
            printCustomerMenu();

            String result = input.nextLine();

            if(result.equals("1")) {
                customerController.browse();
            }
            else if(result.equals("2")) {
                customerController.purchase(input);
            }
            else if(result.equals("3")) {
                System.out.println("Thank you for shopping with us. Come back soon!");
                input.close();
                inSession = false;
            }
            else{
                System.out.println("Not a valid option. Please try again!");
            }
        }
    }

    public void printCustomerMenu(){
        System.out.println("1. Browse");
        System.out.println("2. Purchase");
        System.out.println("3. Log out.");
    }

    public void printAdminMenu(){
        System.out.println("1. Show All Items In Inventory");
        System.out.println("2. Show All Accounts In Database");
        System.out.println("3. Update Account.");
        System.out.println("4. Update Product.");
        System.out.println("5. Add New Account.");
        System.out.println("6. Add New Product.");
        System.out.println("7. Remove Account.");
        System.out.println("8. Remove Product.");
        System.out.println("9. Log out.");
    }
}
