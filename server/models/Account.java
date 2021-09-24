package server.models;

import java.io.Serializable;
import java.util.UUID;

import server.common.AccountType;

public class Account implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Attributes
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private AccountType type;

    public static void main(String[] args) {

        Account a1 = new Account().firstName("Blub")
                                  .lastName("McBluberson")
                                  .email("blub@blub.com")
                                  .password("blubby")
                                  .type(AccountType.CUSTOMER);

        System.out.println(a1.getFirstName() + " " + a1.getLastName());
        System.out.println("User Id: " + a1.getId());
    }

    public Account(){
        this.id = UUID.randomUUID();
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.type = AccountType.OTHER;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    // Fluent Builder Pattern: A derivation of the Builder pattern.
    public Account firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public Account lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public Account email(String email){
        this.email = email;
        return this;
    }

    public Account password(String password){
        this.password = password;
        return this;
    }

    public Account type(AccountType type){
        this.type = type;
        return this;
    }
}
