package taskmanager;


import java.text.SimpleDateFormat;
import java.util.*;

public class TaskManager {
    public static void main(String[] args) {
    	
    	
    	
        TaskStore taskStore = new TaskStore();
        
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Task Manager Menu:");
            System.out.println("a. Add New Task");
            System.out.println("b. Delete a Task");
            System.out.println("c. Update Task Status");
            System.out.println("d. Display All Pending Tasks");
            System.out.println("e. Display Pending Tasks for Today");
            System.out.println("f. Display Tasks Sorted by Task Date");
            System.out.println("q. Quit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "a":
                    taskStore.addTask();
                    break;
                case "b":
                    taskStore.deleteTask();
                    break;
                case "c":
                    taskStore.updateTaskStatus();
                    break;
                case "d":
                    taskStore.displayAllPendingTasks();
                    break;
                case "e":
                    taskStore.displayPendingTasksForToday();
                    break;
                case "f":
                    taskStore.displayTasksSortedByTaskDate();
                    break;
                case "q":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class TaskStore {
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private int taskIdCounter = 1;

    public void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Task Name: ");
        String taskName = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Task Date (dd-MM-yyyy): ");

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date taskDate = dateFormat.parse(scanner.nextLine());
            Task task = new Task(taskName, description, taskDate);
            tasks.put(taskIdCounter, task);
            System.out.println("Task added successfully with ID: " + taskIdCounter);
            taskIdCounter++;
        } catch (Exception e) {
            System.out.println("Invalid date format. Task not added.");
        }
    }

    public void deleteTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Task ID to delete: ");
        int taskIdToDelete = Integer.parseInt(scanner.nextLine());

        if (tasks.containsKey(taskIdToDelete)) {
            tasks.get(taskIdToDelete).setActive(false);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void updateTaskStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Task ID to update status: ");
        int taskIdToUpdate = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Status (PENDING/IN_PROGRESS/COMPLETED): ");
        String status = scanner.nextLine().toUpperCase();

        if (tasks.containsKey(taskIdToUpdate)) {
            try {
                Task.Status taskStatus = Task.Status.valueOf(status);
                tasks.get(taskIdToUpdate).setStatus(taskStatus);
                System.out.println("Task status updated successfully!");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status. Status not updated.");
            }
        } else {
            System.out.println("Task not found.");
        }
    }

    public void displayAllPendingTasks() {
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            Task task = entry.getValue();
            if (task.isActive() && task.getStatus() == Task.Status.PENDING) {
                System.out.println(task.getTaskId() + " - " + task.getTaskName());
            }
        }
    }

   
    	 public void displayPendingTasksForToday() {
    	        Date today = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    	System.out.println("Today's Date: " + dateFormat.format(today));
    	for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
    	    Task task = entry.getValue();
    	    if (task.isActive() && task.getStatus() == Task.Status.PENDING &&
    	        dateFormat.format(task.getTaskDate()).equals(dateFormat.format(today))) {
    	        System.out.println(task.getTaskId() + " - " + task.getTaskName());
    	    }
    	}
    	

    }

    public void displayTasksSortedByTaskDate() {
        List<Map.Entry<Integer, Task>> sortedTasks = new ArrayList<>(tasks.entrySet());
        sortedTasks.sort(Comparator.comparing(taskEntry -> taskEntry.getValue().getTaskDate()));

        for (Map.Entry<Integer, Task> entry : sortedTasks) {
            Task task = entry.getValue();
            if (task.isActive()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println(task.getTaskId() + " - " + task.getTaskName() + " - " +
                        dateFormat.format(task.getTaskDate()));
            }
        }
    }
}
