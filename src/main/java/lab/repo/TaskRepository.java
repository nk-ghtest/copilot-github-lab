package lab.repo;

import lab.model.Task;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 疑似リポジトリ（永続化はしない）
 * Copilotレビュー用に、あえて「ありがちな欠陥」を入れています。
 */
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    /**
     * @param id    task identifier (must not be null)
     * @param title task title (must not be null or blank)
     * @param note  optional note
     * @return the saved Task
     * @throws IllegalArgumentException if id or title is null/blank
     */
    public Task saveTask(String id, String title, String note) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id must not be null or blank");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be null or blank");
        }
        Instant now = Instant.now();
        Task task = new Task(id, title.trim(), note, now, false);
        tasks.add(task);
        return task;
    }

    public List<Task> loadTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public Optional<Task> findById(String id) {
        return tasks.stream().filter(t -> t.id().equals(id)).findFirst();
    }

    public boolean markDone(String id) {
        Optional<Task> opt = findById(id);
        if (opt.isEmpty()) return false;

        Task current = opt.get();
        tasks.remove(current);
        tasks.add(current.withDone(true));
        return true;
    }
}
