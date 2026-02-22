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

    public Task createTask(String title, String note) {
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
