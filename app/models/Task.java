package models;

import net.sf.oval.constraint.NotNull;
import play.db.jpa.Model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Task class.
 *
 * @author BAYLE Nathanaël
 * @author GUY Adrien
 */
@Entity
public class Task extends Model {

    /** The task id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    /** The task title. */
    @NotNull
    public String title;

    /** The 'isDone' flag. */
    @NotNull
    public boolean done;

    /**
     * Create a task.
     *
     * @param title the task title
     */
    public Task(String title) {
        this.title = title;
        this.done = false;
    }

    /**
     * Methode String.
     *
     * @return String format
     */
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", done=" + done +
                '}';
    }
}
