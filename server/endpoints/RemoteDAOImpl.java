package server.endpoints;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.UUID;

import server.database.AccountsDatabase;
import server.database.Inventory;
import server.models.Account;
import server.models.Product;

public class RemoteDAOImpl extends UnicastRemoteObject implements RemoteDAO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Attributes
    AccountsDatabase database;
    Inventory inventory;

    // Main
    public static void main(String[] args) {
        try {
            String name = "//in-csci-rrpc01:2020/RemoteDAOImpl";

            RemoteDAO stub = new RemoteDAOImpl();
            
            Naming.rebind(name, stub);

            System.out.println("Success! RMI Registry Activated.");
        } catch (Exception e) {
            System.out.println("Oh no. Something went wrong.");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // Constructor
    public RemoteDAOImpl() throws RemoteException {
        super();
        this.database = new AccountsDatabase();
        this.inventory = new Inventory();
    }

    @Override
    public List<Account> getAccounts() throws RemoteException {
        return database.getAccounts();
    }

    @Override
    public Account getAccount(UUID id) throws RemoteException {
        return database.getAccount(id);
    }

    @Override
    public void createAccount(Account account) throws RemoteException {
        database.createAccount(account);

    }

    @Override
    public void updateAccount(int accountPosition, Account updatedAccount) throws RemoteException {
        database.updateAccount(accountPosition, updatedAccount);

    }

    @Override
    public void deleteAccount(int index) throws RemoteException {
        database.deleteAccount(index);

    }

    @Override
    public List<Product> getProducts() throws RemoteException {
        return inventory.getProducts();
    }

    @Override
    public Product getProduct(UUID id) throws RemoteException {
        return inventory.getProduct(id);
    }

    @Override
    public void createProduct(Product product) throws RemoteException {
        inventory.createProduct(product);
    }

    @Override
    public void updateProduct(int productPosition, Product updatedProduct) throws RemoteException {
        inventory.updateProduct(productPosition, updatedProduct);;
    }

    @Override
    public void deleteProduct(int index) throws RemoteException {
        inventory.deleteProduct(index);
    }
}
