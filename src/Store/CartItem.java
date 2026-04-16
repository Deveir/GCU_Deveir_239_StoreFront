package Store;
/**
 * Represents one item in the shopping cart.
 * A cart item stores a product and the quantity selected.
 */
public class CartItem {
    private SalableProduct product;
    private int quantity;

    /**
     * Creates a new CartItem object.
     *
     * @param product the product
     * @param quantity the quantity added to the cart
     */
    public CartItem(SalableProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Returns the product.
     *
     * @return the product
     */
    public SalableProduct getProduct() {
        return product;
    }

    /**
     * Returns the quantity in the cart.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity in the cart.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Increases the quantity in the cart.
     *
     * @param amount the amount to add
     */
    public void increaseQuantity(int amount) {
        quantity += amount;
    }

    /**
     * Decreases the quantity in the cart.
     *
     * @param amount the amount to subtract
     */
    public void decreaseQuantity(int amount) {
        quantity -= amount;
    }

    /**
     * Returns the subtotal for this item.
     *
     * @return the subtotal amount
     */
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    /**
     * Returns a string representation of the cart item.
     *
     * @return cart item details as a string
     */
    @Override
    public String toString() {
        return product.getName()
                + " | Quantity: " + quantity
                + " | Subtotal: $" + String.format("%.2f", getSubtotal());
    }
}