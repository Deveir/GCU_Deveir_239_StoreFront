package Store;
/**
 * Represents a product that can be sold in the store.
 * A salable product has a name, description, price, and quantity.
 */
public class SalableProduct {
    private String name;
    private String description;
    private double price;
    private int quantity;

    /**
     * Creates a new SalableProduct object.
     *
     * @param name the product name
     * @param description the product description
     * @param price the product price
     * @param quantity the available quantity
     */
    public SalableProduct(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product description.
     *
     * @return the product description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the product price.
     *
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the available quantity.
     *
     * @return the product quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the product description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the product price.
     *
     * @param price the new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the product quantity.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Increases the available quantity.
     *
     * @param amount the amount to add
     */
    public void increaseQuantity(int amount) {
        quantity += amount;
    }

    /**
     * Decreases the available quantity.
     *
     * @param amount the amount to subtract
     */
    public void decreaseQuantity(int amount) {
        quantity -= amount;
    }

    /**
     * Checks whether enough quantity is available.
     *
     * @param requestedQuantity the requested quantity
     * @return true if enough quantity exists, otherwise false
     */
    public boolean hasEnoughQuantity(int requestedQuantity) {
        return quantity >= requestedQuantity;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return product details as a string
     */
    @Override
    public String toString() {
        return "Product Name: " + name
                + ", Description: " + description
                + ", Price: $" + String.format("%.2f", price)
                + ", Quantity: " + quantity;
    }
}