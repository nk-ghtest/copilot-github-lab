package lab.repo;

import lab.exception.InvalidTaskException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {

    private TaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TaskRepository();
    }

    @Test
    void saveTask_shouldThrowInvalidTaskException_whenTitleIsNull() {
        assertThrows(InvalidTaskException.class,
                () -> repository.saveTask("id-1", null, "note"));
    }

    @Test
    void saveTask_shouldThrowInvalidTaskException_whenTitleIsBlank() {
        assertThrows(InvalidTaskException.class,
                () -> repository.saveTask("id-2", "   ", "note"));
    }

    @Test
    void saveTask_shouldReturnTask_whenTitleIsValid() {
        var task = repository.saveTask("id-3", "Buy groceries", "note");
        assertEquals("Buy groceries", task.title());
        assertEquals("id-3", task.id());
    }
}
