package com.example.repo14;

import java.util.HashMap;

public class ProjectManagt {


    // Enum for task status
    enum TaskStatus {
        TODO, IN_PROGRESS, DONE
    }

    // Class representing a task
    class Task {
        private String taskId;
        private String title;
        private String description;
        private TaskStatus status;
        private String assignee;
        private int estimatedTime;
        private int timeSpent;

        public Task(String taskId, String title, String description, String assignee, int estimatedTime) {
            this.taskId = taskId;
            this.title = title;
            this.description = description;
            this.status = TaskStatus.TODO;
            this.assignee = assignee;
            this.estimatedTime = estimatedTime;
            this.timeSpent = 0;
        }

        // Getters and setters
    }

    // Class representing the Project Management Tool
    public class ProjectManagementTool {
        private Map<String, Task> tasks;

        public ProjectManagementTool() {
            this.tasks = new HashMap<>();
        }

        public void createTask(String taskId, String title, String description, String assignee, int estimatedTime) {
            tasks.put(taskId, new Task(taskId, title, description, assignee, estimatedTime));
        }

        public void assignTask(String taskId, String assignee) {
            Task task = tasks.get(taskId);
            if (task != null) {
                task.setAssignee(assignee);
                task.setStatus(TaskStatus.IN_PROGRESS);
            }
        }

        public void updateTaskStatus(String taskId, TaskStatus status) {
            Task task = tasks.get(taskId);
            if (task != null) {
                task.setStatus(status);
            }
        }

        public void updateTimeSpent(String taskId, int time) {
            Task task = tasks.get(taskId);
            if (task != null) {
                task.setTimeSpent(task.getTimeSpent() + time);
            }
        }

        // Other methods for Gantt chart visualization, collaboration tools, user roles, permissions, etc.

        public static void main(String[] args) {
            ProjectManagementTool pmTool = new ProjectManagementTool();
            pmTool.createTask("T001", "Implement Login Feature", "Implement login functionality for users", "John", 10);
            pmTool.createTask("T002", "Design Database Schema", "Design the database schema for the application", "Alice", 8);

            pmTool.assignTask("T001", "Emily");
            pmTool.updateTaskStatus("T001", TaskStatus.IN_PROGRESS);



            // Example usage:
            Task task = pmTool.tasks.get("T001");
            if (task != null) {
                System.out.println("Task ID: " + task.getTaskId());
                System.out.println("Title: " + task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Assignee: " + task.getAssignee());
                System.out.println("Status: " + task.getStatus());
                System.out.println("Estimated Time: " + task.getEstimatedTime() + " hours");
                System.out.println("Time Spent: " + task.getTimeSpent() + " hours");
            }
        }
    }


}
