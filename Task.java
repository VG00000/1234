public class Task {
    private int id;
    private String description;
    private String dueDate;
    private boolean completed;
//Initialized variables
    public Task(int id, String description, String dueDate) {//Constructor
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }
//Getters and setters for all variables needed in the program functions
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }
//Checks if Task is completed or not
    public boolean isCompleted() {
        return completed;
    }
//To make a task completed
    public void markCompleted() {
        this.completed = true;
    }
}