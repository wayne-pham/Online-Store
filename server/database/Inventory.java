package server.database;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import server.common.ProductType;
import server.models.Product;

public class Inventory extends UnicastRemoteObject{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Attributes
    List<Product> products;

    public static void main(String[] args) {
        
    }

    public Inventory() throws RemoteException{
        this.products = new ArrayList<>();
        Product p1 = new Product().name("Roma Tomatoes")
                                  .description("Great for soups!")
                                  .amount(20).price(3d)
                                  .type(ProductType.FOOD);
        products.add(p1);
    }
    
    public List<Product> getProducts() throws RemoteException{
        return products;
    }

    public Product getProduct(UUID id) throws RemoteException{
        // temp product
        Product productToReturn = new Product();

        for (Product product : products) {
            if(product.getId() == id){
                productToReturn = product;
                break;
            }
        }
        return productToReturn;
    }
    
    public void createProduct(Product product) throws RemoteException{
        products.add(product);

    }
    
    public void updateProduct(int productPosition, Product updatedProduct) throws RemoteException{
        products.set(productPosition, updatedProduct);
    }
    
    public void deleteProduct(int index) throws RemoteException{
        products.remove(index);
    }

}
