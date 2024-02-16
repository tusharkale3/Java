package util;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
public class ProductItemTester {
	 public static void main(String[] args) {
	 List<ProductItem> productItems = new ArrayList<>();
	 Scanner scanner = new Scanner(System.in);
	 int choice;
	 
	 productItems.add(new ProductItem("P123", "Sample Product 1", 19.99, LocalDate.parse("2023-10-20"), 10));
     productItems.add(new ProductItem("P456", "Sample Product 2", 29.99, LocalDate.parse("2023-10-22"), 5));
     productItems.add(new ProductItem("P789", "Sample Product 3", 9.99, LocalDate.parse("2023-10-24"), 20));
     productItems.add(new ProductItem("P234", "Sample Product 4", 15.99, LocalDate.parse("2023-10-26"), 0));

	 do {
	 displayMenu();
	 choice = scanner.nextInt();
	 
	 scanner.nextLine(); // Consume the newline character
	 
	 
	 switch (choice) {
	 case 1:
	 addProductItem(scanner, productItems);
	 break;
	 case 2:
	 updateStock(scanner, productItems);
	 break;
	 case 3:
	 displayAllProductItems(productItems);
	 break;
	 case 4:
	 removeZeroStockItems(productItems);
	 break;
	 case 5:
	 displayDueShipmentItems(productItems);
	 break;
	 case 6:
	 System.out.println("Exiting the program.");
	 break;
	 default:
	 System.out.println("Invalid choice. Please select a valid option.");
	 }
	 } while (choice != 6);
	 }
	 private static void displayMenu() {
	 System.out.println("\nProduct Item Management Menu:");
	 System.out.println("1. Add a new product item");
	 System.out.println("2. Update the quantity of item in stock");
	 System.out.println("3. Display all product items");
	 System.out.println("4. Remove all products whose available stock is zero");
	 System.out.println("5. Display the product items with shipments due in the next week");
	 System.out.println("6. Exit");
	 System.out.print("Select an option: ");
	 }
	 private static void addProductItem(Scanner scanner, List<ProductItem> productItems) {
	 System.out.print("Enter Item Code: ");
	 String itemCode = scanner.nextLine();
	 System.out.print("Enter Description: ");
	 String description = scanner.nextLine();
	 System.out.print("Enter Price: ");
	 double price = scanner.nextDouble();
	 scanner.nextLine(); // Consume the newline character
	 System.out.print("Enter Shipment Date (yyyy-MM-dd): ");
	 LocalDate shipmentDate = LocalDate.parse(scanner.nextLine());
	 System.out.print("Enter Available Stock: ");
	 int availableStock = scanner.nextInt();
	 scanner.nextLine(); // Consume the newline character
	 ProductItem productItem = new ProductItem(itemCode, description, price, shipmentDate, 
	availableStock);
	 productItems.add(productItem);
	 System.out.println("Product item added successfully.");
	 }
	 
	 
	 private static void updateStock(Scanner scanner, List<ProductItem> productItems) {
	 System.out.print("Enter Item Code to update stock: ");
	 String itemCode = scanner.nextLine();
	 System.out.print("Enter quantity to add (positive) or remove (negative): ");
	 int quantity = scanner.nextInt();
	 ProductItem productItem = findProductItemByItemCode(productItems, itemCode);
	 if (productItem != null) {
	 if (productItem.getAvailableStock() + quantity >= 0) {
	 productItem.updateStock(quantity);
	 System.out.println("Stock updated successfully.");
	 } else {
	 System.out.println("Cannot remove more stock than available.");
	 }
	 } else {
	 System.out.println("Product item not found.");
	 }
	 }
	 private static void displayAllProductItems(List<ProductItem> productItems) {
	 System.out.println("\nAll Product Items:");
	 for (ProductItem productItem : productItems) {
	 System.out.println(productItem);
	 }
	 }
	 private static void removeZeroStockItems(List<ProductItem> productItems) {
	 productItems.removeIf(productItem -> productItem.getAvailableStock() == 0);
	 System.out.println("Product items with zero stock removed.");
	 }
	 
	 
	 private static void displayDueShipmentItems(List<ProductItem> productItems) {
	 LocalDate currentDate = LocalDate.now();
	 System.out.println("\nProduct Items with Shipments Due in the Next Week:");
	 List<ProductItem> dueShipmentItems = productItems.stream()
	 .filter(ProductItem::isShipmentDueInNextWeek)
	 .collect(Collectors.toList());
	 if (dueShipmentItems.isEmpty()) {
	 System.out.println("No product items have shipments due in the next week.");
	 } else {
	 for (ProductItem productItem : dueShipmentItems) {
	 System.out.println(productItem);
	 }
	 }
	 }
	 private static ProductItem findProductItemByItemCode(List<ProductItem> 
	 													productItems, String itemCode) {
	 for (ProductItem productItem : productItems) {
	 if (productItem.getItemCode().equals(itemCode)) {
	 return productItem;
	 }
	 }
	 return null;
	 }
	}