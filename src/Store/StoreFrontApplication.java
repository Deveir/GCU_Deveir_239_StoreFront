package Store;
import java.util.Scanner;

/**
 * Main application class for the StoreFront program.
 * This class exercises all store functions through a menu-driven interface.
 */
public class StoreFrontApplication {

    /**
     * Main method that runs the StoreFront application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StoreFront store = new StoreFront();
        store.initializeStore();

        int choice;

        do {
            System.out.println("\n===== STORE FRONT MENU =====");
            System.out.println("1. View Store Products");
            System.out.println("2. Purchase Product");
            System.out.println("3. Cancel Purchase");
            System.out.println("4. View Shopping Cart");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    store.displayStoreProducts();
                    break;

                case 2:
                    System.out.print("Enter product name to purchase: ");
                    String purchaseName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int purchaseQty = scanner.nextInt();
                    scanner.nextLine();
                    store.purchaseProduct(purchaseName, purchaseQty);
                    break;

                case 3:
                    System.out.print("Enter product name to cancel: ");
                    String cancelName = scanner.nextLine();
                    System.out.print("Enter quantity to cancel: ");
                    int cancelQty = scanner.nextInt();
                    scanner.nextLine();
                    store.cancelPurchase(cancelName, cancelQty);
                    break;

                case 4:
                    store.displayShoppingCart();
                    break;

                case 5:
                    System.out.println("Exiting Store Front Application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}