package pet;
import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import pet.*;
public class PetStoreApplication {
	private static final String ADMIN_LOGIN_ID = "admin";
	 private static final String ADMIN_PASSWORD = "admin";
	 private static final String CUSTOMER_LOGIN_ID = "c1";
	 private static final String CUSTOMER_PASSWORD = "c1";
	 private static int orderCounter = 1;
	 private static List<Pet> pets = new ArrayList<>();
	 private static List<Order> orders = new ArrayList<>();
	 private static Map<Integer, Integer> petStocks = new HashMap<>();
	 private static String loggedInUser = null;
	 public static void main(String[] args) {
	 initializePets();
	 displayMenu();
	 }
	 private static void initializePets() {
	 pets.add(new Pet(101, "Bull Dog", Category.DOG, 1000, 50));
	 pets.add(new Pet(102, "Siamese Cat", Category.CAT, 800, 40));
	 pets.add(new Pet(103, "Goldfish", Category.FISH, 50, 100));
	 pets.add(new Pet(104, "Holland Lop Rabbit", Category.RABBIT, 200, 30));
	 for (Pet pet : pets) {
	 petStocks.put(pet.getPetId(), pet.getStocks());
	 }
	 }
	 private static void displayMenu() {
	 Scanner scanner = new Scanner(System.in);
	 while (true) {
	 System.out.println("\nPet Store Application Menu:");
	 System.out.println("1. Login");
	 System.out.println("2. Add new Pet (Admin only functionality)");
	 System.out.println("3. Update Pet details (Admin only functionality)");
	 System.out.println("4. Display all available pets");
	 System.out.println("5. Order a Pet");
	 System.out.println("6. Check order status by Order ID");
	 System.out.println("7. Update order status (Admin only functionality)");
	 System.out.println("8. Exit");
	 System.out.print("Enter your choice: ");
	 int choice = scanner.nextInt();
	 scanner.nextLine();
	 try {
	 switch (choice) {
	 case 1:
	 login();
	 break;
	 case 2:
	 addNewPet();
	 break;
	 case 3:
	 updatePetDetails();
	 break;
	 case 4:
	 displayAvailablePets();
	 break;
	 case 5:
	 orderAPet();
	 break;
	 case 6:
	 checkOrderStatus();
	 break;
	 case 7:
	 updateOrderStatus();
	 break;
	 case 8:
	 System.out.println("Exiting the application.");
	 scanner.close();
	 System.exit(0);
	 default:
	 System.out.println("Invalid choice. Please try again.");
	 }
	 } catch (AuthenticationException | AuthorizationException | OutOfStockException e) {
	 System.out.println("Error: " + e.getMessage());
	 }
	 }
	 }
	 private static void login() throws AuthenticationException {
	 Scanner scanner = new Scanner(System.in);
	 System.out.print("Enter login ID: ");
	 String loginId = scanner.nextLine();
	 System.out.print("Enter password: ");
	 String password = scanner.nextLine();
	 if (loginId.equals(ADMIN_LOGIN_ID) && password.equals(ADMIN_PASSWORD)) {
	 loggedInUser = ADMIN_LOGIN_ID;
	 System.out.println("Admin logged in successfully.");
	 } else if (loginId.equals(CUSTOMER_LOGIN_ID) && password.equals(CUSTOMER_PASSWORD)) {
	 loggedInUser = CUSTOMER_LOGIN_ID;
	 System.out.println("Customer logged in successfully.");
	 } else {
	 loggedInUser = null;
	 throw new AuthenticationException("Invalid login credentials.");
	 }
	 }
	 private static void addNewPet() throws AuthorizationException {
	 if (isAdminLoggedIn()) {
	 Scanner scanner = new Scanner(System.in);
	 System.out.print("Enter Pet ID: ");
	 int petId = scanner.nextInt();
	 scanner.nextLine();
	 System.out.print("Enter Pet Name: ");
	 String name = scanner.nextLine();
	 System.out.print("Enter Category (CAT, DOG, RABBIT, FISH): ");
	 String categoryInput = scanner.nextLine();
	 Category category = Category.valueOf(categoryInput);
	 System.out.print("Enter Unit Price: ");
	 double unitPrice = scanner.nextDouble();
	 scanner.nextLine();
	 System.out.print("Enter Stocks: ");
	 int stocks = scanner.nextInt();
	 scanner.nextLine();
	 Pet pet = new Pet(petId,name, category, unitPrice, stocks);
	 pets.add(pet);
	 petStocks.put(petId, stocks);
	 System.out.println("New Pet added successfully.");
	 } else {
	 throw new AuthorizationException("Only admins can add new pets.");
	 }
	 }
	 
	 
	 private static void updatePetDetails() throws AuthorizationException {
	 if (isAdminLoggedIn()) {
	 Scanner scanner = new Scanner(System.in);
	 System.out.print("Enter Pet ID to update: ");
	 int petId = scanner.nextInt();
	 scanner.nextLine();
	 for (Pet pet : pets) {
	 if (pet.getPetId() == petId) {
	 System.out.print("Enter New Unit Price: ");
	 double unitPrice = scanner.nextDouble();
	 scanner.nextLine();
	 System.out.print("Enter New Stocks: ");
	 int stocks = scanner.nextInt();
	 scanner.nextLine();
	 pet.setStocks(stocks);
	 petStocks.put(petId, stocks);
	 pet.setUnitPrice(unitPrice);
	 System.out.println("Pet details updated successfully.");
	 return;
	 }
	 }
	 System.out.println("Pet with ID " + petId + " not found.");
	 } else {
	 throw new AuthorizationException("Only admins can update pet details.");
	 }
	 }
	 
	 
	 
	 private static void displayAvailablePets() {
	 System.out.println("Available Pets:");
	 for (Pet pet : pets) {
	 System.out.println(pet);
	 }
	 }
	 
	 
	 private static void orderAPet() throws OutOfStockException {
	 if (isLoggedIn()) {
	 Scanner scanner = new Scanner(System.in);
	 System.out.print("Enter Pet ID to order: ");
	 int petId = scanner.nextInt();
	 scanner.nextLine();
	 System.out.print("Enter Quantity: ");
	 int quantity = scanner.nextInt();
	 scanner.nextLine();
	 if (petStocks.containsKey(petId)) {
	 int availableStock = petStocks.get(petId);
	 if (quantity > availableStock) {
	 throw new OutOfStockException("Not enough stock available for the selected pet.");
	 } else {
	 Order order = new Order(orderCounter, petId, quantity, Status.PLACED);
	 orders.add(order);
	 petStocks.put(petId, availableStock - quantity);
	 orderCounter++;
	 System.out.println("Order placed successfully. Order ID: " + orderCounter);
	 }
	 } else {
	 System.out.println("Pet with ID " + petId + " not found.");
	 }
	 }
	 }
	 private static void checkOrderStatus() {
	 if (isLoggedIn()) {
	 Scanner scanner = new Scanner(System.in);
	 System.out.print("Enter Order ID to check status: ");
	 int orderId = scanner.nextInt();
	 scanner.nextLine();
	 for (Order order : orders) {
	 if (order.getOrderId() == orderId) {
	 System.out.println("Order Status: " + order.getStatus());
	 return;
	 }
	 }
	 System.out.println("Order with ID " + orderId + " not found.");
	 }
	 }
	 
	 
	 
	 private static void updateOrderStatus() throws AuthorizationException {
	 if (isAdminLoggedIn()) {
	 Scanner scanner = new Scanner(System.in);
	 System.out.print("Enter Order ID to update status: ");
	 int orderId = scanner.nextInt();
	 scanner.nextLine();
	 for (Order order : orders) {
	 if (order.getOrderId() == orderId) {
	 System.out.print("Enter New Status (PLACED, IN_PROCESS, COMPLETED): ");
	 String statusInput = scanner.nextLine();
	 Status status = Status.valueOf(statusInput);
	 order.setStatus(status);
	 System.out.println("Order status updated successfully.");
	 return;
	 }
	 }
	 System.out.println("Order with ID " + orderId + " not found.");
	 } else {
	 throw new AuthorizationException("Only admins can update order status.");
	 }
	 }
	 
	 
	 private static boolean isLoggedIn() {
	 return loggedInUser != null;
	 }
	 private static boolean isAdminLoggedIn() {
	 return ADMIN_LOGIN_ID.equals(loggedInUser);
	 }

}
