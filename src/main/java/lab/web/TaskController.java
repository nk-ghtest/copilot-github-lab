package lab.web;

import lab.model.Task;
import lab.service.TaskService;

import java.util.List;

/**
 * Androidでいうところの ViewModel / Controller 的な層のつもりの疑似クラス
 */
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    public Task onAddClicked(String titleFromUi, String noteFromUi) {
        if (titleFromUi == null || titleFromUi.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        return service.createTask(titleFromUi, noteFromUi);
    }

    public boolean onDoneClicked(String taskId) {
        return service.completeTask(taskId);
    }

    public List<Task> onScreenShown() {
        return service.listTasks();
    }
}
