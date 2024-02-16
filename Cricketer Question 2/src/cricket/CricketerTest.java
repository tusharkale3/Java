package cricket;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CricketerTest {
    public static void main(String[] args) {
        List<Cricketer> cricketers = new ArrayList<>();
        
        cricketers.add(new Cricketer("Cricketer 1", 25, "email1@example.com", "1234567891", 80));
        cricketers.add(new Cricketer("Cricketer 2", 28, "email2@example.com", "1234567892", 75));
        cricketers.add(new Cricketer("Cricketer 3", 22, "email3@example.com", "1234567893", 90));
        cricketers.add(new Cricketer("Cricketer 4", 24, "email4@example.com", "1234567894", 85));
        cricketers.add(new Cricketer("Cricketer 5", 30, "email5@example.com", "1234567895", 70));
        Scanner scanner = new Scanner(System.in);
        Cricketer cricketer; // Declare cricketer variable here

        while (true) {
            System.out.println("\nCricketer Menu: "
                    + "\n1. Add Cricketer"
                    + "\n2. Modify Cricketer's Rating "
                    + "\n3. Search Cricketer by Name "
                    + "\n4. Display All Cricketers "
                    + "\n5. Display All Cricketers Sorted by Rating "
                    + "\n6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Cricketer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Cricketer Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Cricketer Email ID: ");
                    String emailId = scanner.nextLine();
                    System.out.print("Enter Cricketer Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Cricketer Rating: ");
                    int rating = scanner.nextInt();
                    scanner.nextLine();

                    cricketer = new Cricketer(name, age, emailId, phone, rating);
                    cricketers.add(cricketer);
                    System.out.println("Cricketer added: " + cricketer.getName());
                    break;

                case 2:
                    System.out.print("Enter Cricketer Name to Modify Rating: ");
                    String nameToModify = scanner.nextLine();
                    System.out.print("Enter New Rating: ");
                    int newRating = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;

                    for (Cricketer c : cricketers) {
                        if (c.getName().equalsIgnoreCase(nameToModify)) {
                            c.setRating(newRating);
                            System.out.println("Rating for " + c.getName() + " modified.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Cricketer not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Cricketer Name to Search: ");
                    String nameToSearch = scanner.nextLine();
                    boolean foundCricketer = false;

                    for (Cricketer c : cricketers) {
                        if (c.getName().equalsIgnoreCase(nameToSearch)) {
                            System.out.println("Cricketer found:\n" + c);
                            foundCricketer = true;
                            break;
                        }
                    }

                    if (!foundCricketer) {
                        System.out.println("Cricketer not found.");
                    }
                    break;

                case 4:
                    System.out.println("\nAll Cricketers:");
                    for (Cricketer c : cricketers) {
                        System.out.println(c);
                        System.out.println("----------");
                    }
                    break;

                case 5:
                    if (cricketers.isEmpty()) {
                        System.out.println("No cricketers to display.");
                    } else {
                        List<Cricketer> sortedCricketers = new ArrayList<>(cricketers);
                        Collections.sort(sortedCricketers, (c1, c2) -> Integer.compare(c2.getRating(), c1.getRating()));

                        System.out.println("\nAll Cricketers Sorted by Rating:");
                        for (Cricketer c : sortedCricketers) {
                            System.out.println(c);
                            System.out.println("----------");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
