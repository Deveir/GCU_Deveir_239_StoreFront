package Store;
import java.util.ArrayList;

/**
 * Represents a shopping cart for the store.
 * The shopping cart holds cart items selected by the user.
 */
public class ShoppingCart {
    private ArrayList<CartItem> items;

    /**
     * Creates an empty shopping cart.
     */
    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /**
     * Adds a product to the cart.
     * If the product already exists in the cart, its quantity is increased.
     *
     * @param product the product to add
     * @param quantity the quantity to add
     */
    public void addProduct(SalableProduct product, int quantity) {
        CartItem existingItem = findCartItem(product.getName());

        if (existingItem != null) {
            existingItem.increaseQuantity(quantity);
        } else {
            items.add(new CartItem(product, quantity));
        }
    }

    /**
     * Removes a product quantity from the cart.
     *
     * @param productName the product name
     * @param quantity the quantity to remove
     * @return true if removed successfully, otherwise false
     */
    public boolean removeProduct(String productName, int quantity) {
        CartItem existingItem = findCartItem(productName);

        if (existingItem == null) {
            return false;
        }

        if (existingItem.getQuantity() < quantity) {
            return false;
        }

        if (existingItem.getQuantity() == quantity) {
            items.remove(existingItem);
        } else {
            existingItem.decreaseQuantity(quantity);
        }

        return true;
    }

    /**
     * Finds a cart item by product name.
     *
     * @param productName the product name
     * @return the matching cart item, or null if not found
     */
    public CartItem findCartItem(String productName) {
        for (CartItem item : items) {
            if (item.getProduct().getName().equalsIgnoreCase(productName)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Returns all items in the cart.
     *
     * @return the list of cart items
     */
    public ArrayList<CartItem> getItems() {
        return items;
    }

    /**
     * Checks whether the cart is empty.
     *
     * @return true if empty, otherwise false
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Calculates the total cost of the cart.
     *
     * @return the total cart cost
     */
    public double getTotal() {
        double total = 0.0;

        for (CartItem item : items) {
            total += item.getSubtotal();
        }

        return total;
    }

    /**
     * Displays the cart contents.
     */
    public void displayCart() {
        if (isEmpty()) {
            System.out.println("Shopping cart is empty.");
            return;
        }

        System.out.println("\nShopping Cart:");
        for (CartItem item : items) {
            System.out.println(item);
        }
        System.out.println("Cart Total: $" + String.format("%.2f", getTotal()));
    }
}