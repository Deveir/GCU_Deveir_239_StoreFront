package Store;
/**
 * Represents the StoreFront system.
 * The StoreFront coordinates interactions between the inventory manager
 * and the shopping cart.
 */
public class StoreFront {
    private InventoryManager inventoryManager;
    private ShoppingCart shoppingCart;

    /**
     * Creates a StoreFront with an inventory manager and shopping cart.
     */
    public StoreFront() {
        inventoryManager = new InventoryManager();
        shoppingCart = new ShoppingCart();
    }

    /**
     * Initializes the store with sample products.
     */
    public void initializeStore() {
        inventoryManager.addProduct(new SalableProduct("Laptop", "15-inch laptop", 899.99, 10));
        inventoryManager.addProduct(new SalableProduct("Headphones", "Wireless headphones", 149.99, 20));
        inventoryManager.addProduct(new SalableProduct("Mouse", "Wireless mouse", 29.99, 30));
        inventoryManager.addProduct(new SalableProduct("Keyboard", "Mechanical keyboard", 79.99, 15));
    }

    /**
     * Purchases a product from the store.
     *
     * @param productName the product name
     * @param quantity the quantity to purchase
     */
    public void purchaseProduct(String productName, int quantity) {
        if (inventoryManager.isAvailable(productName, quantity)) {
            SalableProduct product = inventoryManager.findProduct(productName);
            inventoryManager.reduceStock(productName, quantity);
            shoppingCart.addProduct(product, quantity);
            System.out.println(quantity + " " + productName + "(s) purchased successfully.");
        } else {
            System.out.println("Purchase failed. Product not found or insufficient stock.");
        }
    }

    /**
     * Cancels a previously purchased product.
     *
     * @param productName the product name
     * @param quantity the quantity to cancel
     */
    public void cancelPurchase(String productName, int quantity) {
        boolean removed = shoppingCart.removeProduct(productName, quantity);

        if (removed) {
            inventoryManager.restoreStock(productName, quantity);
            System.out.println(quantity + " " + productName + "(s) removed from cart and returned to inventory.");
        } else {
            System.out.println("Cancellation failed. Product not found in cart or invalid quantity.");
        }
    }

    /**
     * Displays the available store products.
     */
    public void displayStoreProducts() {
        inventoryManager.displayInventory();
    }

    /**
     * Displays the shopping cart contents.
     */
    public void displayShoppingCart() {
        shoppingCart.displayCart();
    }
}
