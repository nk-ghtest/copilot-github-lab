package lab.repo;

import lab.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {

    private TaskRepository repo;

    @BeforeEach
    void setUp() {
        repo = new TaskRepository();
    }

    @Test
    void saveTask_validTitle_returnsTask() {
        Task task = repo.saveTask("id-1", "Buy milk", null);
        assertEquals("id-1", task.id());
        assertEquals("Buy milk", task.title());
        assertFalse(task.done());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "  "})
    void saveTask_nullOrBlankTitle_throwsIllegalArgumentException(String title) {
        assertThrows(IllegalArgumentException.class,
                () -> repo.saveTask("id-1", title, null));
    }
}
