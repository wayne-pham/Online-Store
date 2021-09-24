package server.endpoints;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

import server.models.Account;
import server.models.Product;

public interface RemoteDAO extends Remote {
    
    public List<Account> getAccounts() throws RemoteException;

    public Account getAccount(UUID id) throws RemoteException;

    public void createAccount(Account account) throws RemoteException;

    public void updateAccount(int accountPosition, Account updatedAccount) throws RemoteException;

    public void deleteAccount(int index) throws RemoteException;

    public List<Product> getProducts() throws RemoteException;

    public Product getProduct(UUID id) throws RemoteException;

    public void createProduct(Product product) throws RemoteException;

    public void updateProduct(int productPosition, Product updatedProduct) throws RemoteException;

    public void deleteProduct(int index) throws RemoteException;
}
