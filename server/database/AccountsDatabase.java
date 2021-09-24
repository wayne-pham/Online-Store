package server.database;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import server.common.AccountType;
import server.models.Account;

public class AccountsDatabase extends UnicastRemoteObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Attributes
    List<Account> accounts;

    public static void main(String[] args) throws RemoteException {
        // make the db
        AccountsDatabase ad = new AccountsDatabase();

        Account a1 = new Account().firstName("Blub")
                                  .lastName("McBluberson")
                                  .email("blub@blub.com")
                                  .password("blubby")
                                  .type(AccountType.CUSTOMER);

        Account a2 = new Account().firstName("Blubette")
                                  .lastName("McBluberson")
                                  .email("blub@blub.com")
                                  .password("blubby")
                                  .type(AccountType.CUSTOMER);

        // Account Created
        System.out.println("Created: \n");
        ad.createAccount(a1);
        ad.createAccount(a2);
        System.out.println(ad.getAccount(a1.getId()).getFirstName());
        System.out.println(ad.getAccount(a2.getId()).getFirstName());
        System.out.println();

        // Account Updated
        System.out.println("Updated: \n");
        ad.updateAccount(0, a2);
        System.out.println(ad.getAccount(a1.getId()).getFirstName());
        System.out.println(ad.getAccount(a2.getId()).getFirstName());
        System.out.println();

        // Account Deleted
        System.out.println("Delete: \n");
        ad.deleteAccount(0);
        System.out.println(ad.getAccount(a1.getId()).getFirstName());
        System.out.println(ad.getAccount(a2.getId()).getFirstName());

    }

    public AccountsDatabase() throws RemoteException {
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    
    public Account getAccount(UUID id) throws RemoteException {
        // temp account
        Account accountToReturn = new Account();

        for (Account account : accounts) {
            if(account.getId() == id){
                accountToReturn = account;
                break;
            }
        }
        return accountToReturn;
    }
    
    public void createAccount(Account account) throws RemoteException {
        accounts.add(account);
    }
    
    public void updateAccount(int accountPosition, Account updatedAccount) throws RemoteException {
        accounts.set(accountPosition, updatedAccount);
    }

    
    public void deleteAccount(int index) throws RemoteException {
        accounts.remove(index);
    }

}
