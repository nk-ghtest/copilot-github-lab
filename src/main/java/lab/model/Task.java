package lab.model;

import java.time.Instant;
import java.util.Objects;

public final class Task {
    private final String id;
    private final String title;
    private final String note;
    private final Instant createdAt;
    private final boolean done;

    public Task(String id, String title, String note, Instant createdAt, boolean done) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.createdAt = createdAt;
        this.done = done;
    }

    public String id() { return id; }
    public String title() { return title; }
    public String note() { return note; }
    public Instant createdAt() { return createdAt; }
    public boolean done() { return done; }

    public Task withDone(boolean done) {
        return new Task(id, title, note, createdAt, done);
    }

    @Override
    public String toString() {
        return "Task{id='%s', title='%s', done=%s}".formatted(id, title, done);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return done == task.done
                && Objects.equals(id, task.id)
                && Objects.equals(title, task.title)
                && Objects.equals(note, task.note)
                && Objects.equals(createdAt, task.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, note, createdAt, done);
    }
}
