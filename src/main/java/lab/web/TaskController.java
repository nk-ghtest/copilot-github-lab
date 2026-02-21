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
        // ❌ UIから title が null/空のまま来ることを想定したガードが薄い（レビュー対象）
        return service.createTask(titleFromUi, noteFromUi);
    }

    public boolean onDoneClicked(String taskId) {
        return service.completeTask(taskId);
    }

    public List<Task> onScreenShown() {
        return service.listTasks();
    }
}
