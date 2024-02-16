package util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
	 private static List<Employee> employees = new ArrayList<>();
	 public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 int choice;
	 do {
	 displayMenu();
	 choice = scanner.nextInt();
	 scanner.nextLine(); // Consume the newline character
	 switch (choice) {
	 case 1:
	 addFullTimeEmployee(scanner);
	 break;
	 case 2:
	 addPartTimeEmployee(scanner);
	 break;
	 case 3:
	 deleteEmployeeById(scanner);
	 break;
	 case 4:
	 searchEmployeeByAadhaarNumber(scanner);
	 break;
	 case 5:
	 displayAllEmployeeDetails();
	 break;
	 case 6:
	 displayAllEmployeeDetailsSortedByDateOfJoining();
	 break;
	 case 7:
	 System.out.println("Exiting the program.");
	 break;
	 default:
	 System.out.println("Invalid choice. Please select a valid option.");
	 }
	 } while (choice != 7);
	 }
	 private static void displayMenu() {
	 System.out.println("\nEmployee Management System Menu:");
	 System.out.println("1. Add Full Time Employee");
	 System.out.println("2. Add Part Time Employee");
	 System.out.println("3. Delete an Employee by Emp Id");
	 System.out.println("4. Search Employee Details by Aadhaar Number");
	 System.out.println("5. Display All Employee Details");
	 System.out.println("6. Display All Employee Details Sorted by Date of Joining");
	 System.out.println("7. Exit");
	 System.out.print("Select an option: ");
	 }
	 private static void addFullTimeEmployee(Scanner scanner) {
	 // Input validation is not implemented here for brevity. You should validate input in a real application.
	 System.out.print("Enter name: ");
	 String name = scanner.nextLine();
	 System.out.print("Enter date of joining (yyyy-MM-dd): ");
	 LocalDate dateOfJoining = LocalDate.parse(scanner.nextLine());
	 System.out.print("Enter phone number: ");
	 String phoneNumber = scanner.nextLine();
	 System.out.print("Enter Aadhaar number: ");
	 String aadhaarNumber = scanner.nextLine();
	 System.out.print("Enter monthly salary: ");
	 double monthlySalary = scanner.nextDouble();
	 FTE fte = new FTE(name, dateOfJoining, phoneNumber, aadhaarNumber, monthlySalary);
	 employees.add(fte);
	 System.out.println("Full Time Employee added successfully.");
	 }
	 
	 
	 private static void addPartTimeEmployee(Scanner scanner) {
	 // Input validation is not implemented here for brevity. You should validate input in a real application.
	 System.out.print("Enter name: ");
	 String name = scanner.nextLine();
	 System.out.print("Enter date of joining (yyyy-MM-dd): ");
	 LocalDate dateOfJoining = LocalDate.parse(scanner.nextLine());
	 System.out.print("Enter phone number: ");
	 String phoneNumber = scanner.nextLine();
	 System.out.print("Enter Aadhaar number: ");
	 String aadhaarNumber = scanner.nextLine();
	 System.out.print("Enter hourly payment: ");
	 double hourlyPayment = scanner.nextDouble();
	 PTE pte = new PTE(name, dateOfJoining, phoneNumber, aadhaarNumber, hourlyPayment);
	 employees.add(pte);
	 System.out.println("Part Time Employee added successfully.");
	 }
	 
	 
	 private static void deleteEmployeeById(Scanner scanner) {
	 // Input validation is not implemented here for brevity. You should validate input in a real application.
	 System.out.print("Enter Emp Id to delete: ");
	 int empIdToDelete = scanner.nextInt();
	 for (Employee employee : employees) {
	 if (employee.getEmpId() == empIdToDelete) {
	 employees.remove(employee);
	 System.out.println("Employee with Emp Id " + empIdToDelete + " deleted successfully.");
	 return;
	 }
	 }
	 System.out.println("Employee with Emp Id " + empIdToDelete + " not found.");
	 }
	 private static void searchEmployeeByAadhaarNumber(Scanner scanner) {
	 // Input validation is not implemented here for brevity. You should validate input in a real application.
	 System.out.print("Enter Aadhaar number to search: ");
	 String aadhaarToSearch = scanner.nextLine();
	 for (Employee employee : employees) {
	 if (employee.getAadhaarNumber().equals(aadhaarToSearch)) {
	 displayEmployeeDetails(employee);
	 return;
	 }
	 }
	 System.out.println("Employee with Aadhaar Number " + aadhaarToSearch + " not found.");
	 }
	 private static void displayEmployeeDetails(Employee employee) {
	 System.out.println("\nEmployee Details:");
	 System.out.println("Emp Id: " + employee.getEmpId());
	 System.out.println("Name: " + employee.getName());
	 System.out.println("Date of Joining: " + employee.getDateOfJoining());
	 System.out.println("Phone Number: " + employee.getPhoneNumber());
	 System.out.println("Aadhaar Number: " + employee.getAadhaarNumber());
	 if (employee instanceof FTE) {
	 System.out.println("Employee Type: Full Time");
	 System.out.println("Monthly Salary: " + ((FTE) employee).getMonthlySalary());
	 } else if (employee instanceof PTE) {
	 System.out.println("Employee Type: Part Time");
	 System.out.println("Hourly Payment: "+ ((PTE) employee).getHourlyPayment());
	 }
	 }
	 private static void displayAllEmployeeDetails() {
	 System.out.println("\nAll Employee Details:");
	 for (Employee employee : employees) {
	 displayEmployeeDetails(employee);
	 System.out.println("----------------");
	 }
	 }
	 private static void displayAllEmployeeDetailsSortedByDateOfJoining() {
	 System.out.println("\nAll Employee Details Sorted by Date of Joining:");
	 employees.stream()
	 .sorted((e1, e2) -> e1.getDateOfJoining().compareTo(e2.getDateOfJoining()))
	 .forEach(employee -> {
	 displayEmployeeDetails(employee);
	 System.out.println("----------------");
	 });
	 }
	
}
