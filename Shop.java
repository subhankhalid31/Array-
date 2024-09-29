import java.util.Scanner;

public class Shop {
    private Product productList[] = new Product[500];
    private Person owner;
    private String address;
    private static int productCount = 0;
    private static double revenue;

    public Shop(Person owner, String address) {
        this.owner = owner;
        this.address = address;
        this.productList = new Product[100];
    }

    public void addProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Product details");
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Price: ");
        double price = input.nextDouble();
        System.out.print("Quantity: ");
        int quantity = input.nextInt();
        Product product = new Product(name, price, quantity);
        productList[productCount++] = product;
        System.out.println("Product added");
    }

    public void sale() {
        System.out.println("Sale Menu");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        for (int i = 0; i < productCount; i++) {
            if (productList[i].getId().equals(id)) {
                productList[i].setQuantity(productList[i].getQuantity() - 1);
                revenue += productList[i].getPrice();
                System.out.println("Sale successful");
                return;
            }
        }
        System.out.println("Product not found");
    }

    public void modifyProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter product ID to modify: ");
        String idToModify = input.nextLine();

        for (int i = 0; i < productCount; i++) {
            if (productList[i].getId().equals(idToModify)) {
                System.out.println("Enter updated product details:");
                System.out.print("New Name: ");
                String newName = input.nextLine();
                System.out.print("New Price: ");
                double newPrice = input.nextDouble();
                System.out.print("New Quantity: ");
                int newQuantity = input.nextInt();

                productList[i].setName(newName);
                productList[i].setPrice(newPrice);
                productList[i].setQuantity(newQuantity);
                System.out.println("Product modified successfully.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void deleteProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter product ID to delete: ");
        String idToDelete = input.nextLine();

        for (int i = 0; i < productCount; i++) {
            if (productList[i].getId().equals(idToDelete)) {
                for (int j = i; j < productCount - 1; j++) {
                    productList[j] = productList[j + 1];
                }
                productCount--;
                System.out.println("Product deleted successfully.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void displayProducts() {
        if (productCount == 0) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("Product List:");
        for (int i = 0; i < productCount; i++) {
            System.out.println("ID: " + productList[i].getId() +
                               ", Name: " + productList[i].getName() +
                               ", Price: " + productList[i].getPrice() +
                               ", Quantity: " + productList[i].getQuantity());
        }
    }
}
