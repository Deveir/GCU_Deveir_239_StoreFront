package Store;
import java.util.ArrayList;

/**
 * Manages the inventory of products in the store.
 */
public class InventoryManager {
    private ArrayList<SalableProduct> products;

    /**
     * Creates an empty inventory manager.
     */
    public InventoryManager() {
        products = new ArrayList<>();
    }

    /**
     * Adds a product to inventory.
     *
     * @param product the product to add
     */
    public void addProduct(SalableProduct product) {
        products.add(product);
    }

    /**
     * Finds a product by name.
     *
     * @param productName the product name
     * @return the product if found, otherwise null
     */
    public SalableProduct findProduct(String productName) {
        for (SalableProduct product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Checks whether a product exists and enough quantity is available.
     *
     * @param productName the product name
     * @param requestedQuantity the requested quantity
     * @return true if available, otherwise false
     */
    public boolean isAvailable(String productName, int requestedQuantity) {
        SalableProduct product = findProduct(productName);

        if (product == null) {
            return false;
        }

        return product.hasEnoughQuantity(requestedQuantity);
    }

    /**
     * Reduces product stock after a purchase.
     *
     * @param productName the product name
     * @param quantity the quantity to remove
     * @return true if successful, otherwise false
     */
    public boolean reduceStock(String productName, int quantity) {
        SalableProduct product = findProduct(productName);

        if (product != null && product.hasEnoughQuantity(quantity)) {
            product.decreaseQuantity(quantity);
            return true;
        }

        return false;
    }

    /**
     * Restores product stock after a cancellation.
     *
     * @param productName the product name
     * @param quantity the quantity to restore
     * @return true if successful, otherwise false
     */
    public boolean restoreStock(String productName, int quantity) {
        SalableProduct product = findProduct(productName);

        if (product != null) {
            product.increaseQuantity(quantity);
            return true;
        }

        return false;
    }

    /**
     * Displays all products in inventory.
     */
    public void displayInventory() {
        System.out.println("\nStore Inventory:");
        for (SalableProduct product : products) {
            System.out.println(product);
        }
    }

    /**
     * Returns all products in inventory.
     *
     * @return the list of products
     */
    public ArrayList<SalableProduct> getProducts() {
        return products;
    }
}
