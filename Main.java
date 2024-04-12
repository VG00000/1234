import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
//Loop to continue the user input until they exit
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Delete Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear the invalid input
                continue;//IntelliJ recommended :)
            }


            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = sc.nextLine();
                    String dueDateStr;//Iniitalize the duedate in string for the program to accept
                    LocalDate dueDate;//Same thing but for the date packet to accept
                    do {
                        System.out.print("Enter due date (yyyy-MM-dd): ");
                        dueDateStr = sc.nextLine();
                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");//Checks if user inputs date format correctly
                            dueDate = LocalDate.parse(dueDateStr, formatter);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
                        }
                    } while (true);
                    Task task = new Task(taskManager.getTasks().size() + 1, description, dueDate.toString());
                    taskManager.addTask(task);
                    System.out.println("Task added successfully. Task ID: " + task.getId());
                    break;
                case 2:
                    try{System.out.print("Enter task ID to mark as completed: ");
                    int taskId = sc.nextInt();
                    taskManager.markTaskCompleted(taskId);//Calls method as in every case
                    System.out.println("Task marked as completed.");
            }catch(InputMismatchException exception)//Checks for correct usage
            {
                System.out.println("Please enter a valid Task ID.");
                sc.next();
            }
                    break;
                case 3://Same as case 2
                    try {
                        System.out.print("Enter task ID to delete: ");
                        int taskId = sc.nextInt();
                        taskManager.deleteTask(taskId);
                        System.out.println("Task " + taskId + "deleted.");
                    }catch(InputMismatchException exception)
                    {
                        System.out.println("Please enter a valid Task ID.");
                        sc.next();
                    }
                    break;
                case 4://Just calls method
                    taskManager.viewAllTasks();
                    break;
                case 5://Calls method
                    taskManager.dueToday();
                    break;


                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
