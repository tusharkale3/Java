package taskmanager;


import java.util.Date;

public class Task {
    private static int taskCounter = 1;
    private int taskId;
    private String taskName;
    private String description;
    private Date taskDate;
    private Status status;
    private boolean active;

   
    enum Status {
    	 PENDING, IN_PROGRESS, COMPLETED
    	 }


    public Task(String taskName, String description, Date taskDate) {
        this.taskId = taskCounter++;
        this.taskName = taskName;
        this.description = description;
        this.taskDate = taskDate;
        this.status = Status.PENDING; // Default status
        this.active = true; // Default active
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId +
               "\nTask Name: " + taskName +
               "\nDescription: " + description +
               "\nTask Date: " + taskDate +
               "\nStatus: " + status +
               "\nActive: " + active;
    }
}
