import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import client.frontController.FrontController;

public class Program {
    
    FrontController frontController;

    public static void main(String[] args) {
        
        try {
            Scanner input = new Scanner(System.in);
            Program client = new Program();
            client.run(input);
            input.close(); 
        } 
        catch (Exception e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
        
    }
    
    public Program() throws MalformedURLException, RemoteException, NotBoundException {
        this.frontController = new FrontController();
    }
    
    public void run(Scanner input) throws RemoteException {
        frontController.mainMenu(input);
    }

    public void printMenu(){
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
