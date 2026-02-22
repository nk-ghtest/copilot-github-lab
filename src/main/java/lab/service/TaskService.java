package lab.service;

import lab.model.Task;
import lab.repo.TaskRepository;

import java.util.List;
import java.util.UUID;

public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    /**
     * @param title task title (must not be null or blank)
     * @param note  optional note
     * @return the created Task
     * @throws IllegalArgumentException if title is null or blank
     */
    public Task createTask(String title, String note) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be null or blank");
        }
        String id = UUID.randomUUID().toString();
        return repo.saveTask(id, title, note);
    }

    public boolean completeTask(String id) {
        return repo.markDone(id);
    }

    public List<Task> listTasks() {
        return repo.loadTasks();
    }
}
