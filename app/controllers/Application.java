package controllers;

import models.Task;
import play.mvc.Controller;

import java.util.List;

/**
 * Application controller class.
 *
 * @author BAYLE Nathanaël
 * @author GUY Adrien
 */
public class Application extends Controller {

    /**
     * Display all tasks and render associate template.
     *
     * @{link views/Application/listTache.html}
     */
    public static void listTache() {
        List<Task> tasks = Task.findAll();
        render(tasks);
    }


    /**
     * Render associate template.
     *
     * @{link views/Application/ajouterTacheForm.html}
     */
    public static void ajouterTacheForm() {
        render();
    }


    /**
     * Add new task and render associate template.
     *
     * @param title the task title
     * @{link views/Application/ajouterTachem.html}
     */
    public static void ajouterTache(String title) {
        Task task = new Task(title);
        task.save();
        render();
    }

    /**
     * Change task 'done' flag.
     *
     * @param id the task id
     */
    public static void validerTache(Long id) {
        Task task = Task.findById(id);
        task.done = !task.done;
        task.save();
    }


    /**
     * Delete a task.
     *
     * @param id the task id
     */
    public static void supprimerTache(Long id) {
        Task task = Task.findById(id);
        task.delete();
    }


    /**
     * Change task title.
     *
     * @param id the task id
     * @param title the new task title
     */
    public static void editTache(Long id, String title) {
        Task task = Task.findById(id);
        task.title = title;
        task.save();
    }
}