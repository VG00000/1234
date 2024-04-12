import java.time.LocalDate;
import java.util.ArrayList;
public class TaskManager {
    private ArrayList<Task> tasks;
//Contrucotr
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }
//Adds a task
    public void addTask(Task task) {
        tasks.add(task);
    }
//Marks a task as completed
    public void markTaskCompleted(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.markCompleted();
                break;
            }
        }
    }
//Deletes
    public void deleteTask(int taskId) {
        tasks.removeIf(task -> task.getId() == taskId);
    }
//Shows all tasks due today
    public void dueToday() {
        LocalDate today = LocalDate.now();
        System.out.println("Tasks due today:");
        for (Task task : tasks) {
            if (task.getDueDate().equals(today.toString())) {
                System.out.println("ID: " + task.getId() +
                        ", Description: " + task.getDescription() +
                        ", Due Date: " + task.getDueDate());
            }


        }
    }
//Shows all tasks due whenever if there arent any tasks says so
    public void viewAllTasks() {
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId() +
                    ", Description: " + task.getDescription() +
                    ", Due Date: " + task.getDueDate() +
                    ", Completed: " + task.isCompleted());
        }

        if(tasks.isEmpty()){
            System.out.println("No tasks available.");
        }
    }
    public ArrayList<Task> getTasks() {
        return tasks;
    }


}