package client.controllers;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import client.views.CustomerView;
import server.endpoints.RemoteDAO;
import server.models.Product;

public class CustomerController {

    private RemoteDAO stub;
    private CustomerView view;

    public static void main(String[] args) {

    }

    public CustomerController() throws MalformedURLException, RemoteException, NotBoundException {
        String name = "//in-csci-rrpc01:2020/RemoteDAOImpl";
        this.stub = (RemoteDAO) Naming.lookup(name);
        this.view = new CustomerView();
        System.out.println("\nSuccess! Customer API connected. Starting Program...\n\n");
    }


    public void browse() throws RemoteException {
        view.viewProductList(stub.getProducts());
    }

    public void purchase(Scanner input) throws RemoteException {
        browse();
        // Select the amount to buy.
        System.out.println("Select product for purchase.");
        String selection = input.nextLine();
        int productPosition = Integer.parseInt(selection);
        
        System.out.println("How much do you want to buy?");
        String amount = input.nextLine();
        int amountToBuy = Integer.parseInt(amount);

        if(amountToBuy > stub.getProducts().get(productPosition).getAmount()){
            System.out.println("Purchase amount cannot exceed inventory");
        }
        else{
            Product productToBuy = stub.getProducts().get(productPosition);
            double total = productToBuy.getPrice() * amountToBuy;
            System.out.println("Your total: " + total);

            System.out.println("Enter the total cost of your purchase.");
            String payment = input.nextLine();
            double amountToPay = Double.parseDouble(payment);
            
            if(amountToPay == total){
                System.out.println("Thank you for shopping with us");

                // Build product to update database with new info
                Product updatedProduct = new Product().name(productToBuy.getName())
                                                      .amount(productToBuy.getAmount() - amountToBuy)
                                                      .description(productToBuy.getDescription())
                                                      .price(productToBuy.getPrice())
                                                      .type(productToBuy.getType());

                stub.updateProduct(productPosition, updatedProduct);
            }
            else{
                System.out.println("Please Enter the correct amount. ");
            }
        }

    }

    // This method returns a No Line Found. Do Not Use.
    public int promptWithConversion(String text){
        System.out.println(text);
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        int amount = Integer.parseInt(inputString);
        input.close();
        return amount;
    }
}
