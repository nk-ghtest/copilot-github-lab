package lab;

import lab.repo.TaskRepository;
import lab.service.TaskService;
import lab.web.TaskController;

public class App {
    public static void main(String[] args) {
        TaskRepository repo = new TaskRepository();
        TaskService service = new TaskService(repo);
        TaskController controller = new TaskController(service);

        // テスト用: わざとnullを渡してクラッシュさせられる（Issueにしやすい）
        String title = null;
        controller.onAddClicked(title, "note");

        System.out.println(controller.onScreenShown());
    }
}
