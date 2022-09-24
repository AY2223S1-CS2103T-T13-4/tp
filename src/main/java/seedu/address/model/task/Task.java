package seedu.address.model.task;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.person.*;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {

    public enum Assignment {
        ASSIGNOR, ASSIGNEE;

        @Override
        public String toString() {
            switch (this) {
            case ASSIGNEE:
                return "M";
            case ASSIGNOR:
                return "O";
            default:
                return " ";
            }
        }
    }

    private final Person person;
    private final Assignment assignment;
    private final String description;
    private final boolean isDone;

    /**
     * Every field must be present and not null.
     */
    public Task(Person person, Assignment assignment, String description, boolean isDone) {
        requireAllNonNull(person, assignment, description, isDone);
        this.person = person;
        this.assignment = assignment;
        this.description = description;
        this.isDone = isDone;
    }

    public Person getPerson() {
        return person;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    /**
     * Returns true if both tasks have the same description, person and assignment.
     * This defines a weaker notion of equality between two tasks.
     */
    public boolean isSameTask(Task otherTask) {
        if (otherTask == this) {
            return true;
        }

        return otherTask != null
                && otherTask.getPerson().equals(getPerson())
                && otherTask.getAssignment().equals(getAssignment())
                && otherTask.getDescription().equals(getDescription());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Task)) {
            return false;
        }

        // TODO: Include isDone in equality check?
        Task otherTask = (Task) other;
        return otherTask.getPerson().equals(getPerson())
                && otherTask.getAssignment().equals(getAssignment())
                && otherTask.getDescription().equals(getDescription())
                && (otherTask.isDone() == (isDone()));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(person, assignment, description, isDone);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(String.format("[%s]", isDone()))
                .append(String.format("[%s]", getAssignment()))
                .append(String.format("[%s]", getPerson().getName()))
                .append("\n")
                .append(getDescription());



        return builder.toString();
    }

}

