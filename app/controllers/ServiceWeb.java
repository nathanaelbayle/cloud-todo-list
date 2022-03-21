package controllers;

import models.Task;
import play.mvc.Controller;

import java.util.List;

/**
 * Service Web class.
 *
 * @author BAYLE Nathanaël
 * @author GUY Adrien
 */
public class ServiceWeb extends Controller {

    /**
     * @POST Add new task.
     * Test (curl) : curl --data "title=task-from-curl" localhost:9000/api/tache
     * @param title the task title
     * @return the new task
     */
    public static void ajouterTache(String title) {
        Task task = new Task(title);
        task.save();
        renderJSON(task.toString());
    }


    /**
     * @GET All tasks.
     * Test (curl) : curl localhost:9000/api/taches.json
     * @return collection of tasks
     */
    public static void listTache() {
        List<Task> tasks = Task.findAll();
        renderJSON(tasks.toString());
    }


    /**
     * @GET Task by id.
     * Test (curl) : curl localhost:9000/api/tache/{id}.json
     * @param id the task id
     * @return the task
     */
    public static void getTache(Long id) {
        Task task = Task.findById(id);
        renderJSON(task.toString());
    }


    /**
     * @PUT Update task title.
     * Test (curl) : curl -X PUT --data "title=aaabbb" localhost:9000/api/tache/{id}
     * @param title the new task title
     * @return the updated task
     */
    public static void editTitleTache(Long id, String title) {
        Task task = Task.findById(id);
        task.title = title;
        task.save();
        renderJSON(task.toString());
    }


    /**
     * @PUT Update task status.
     * Test (curl) : curl -X PUT localhost:9000/api/tache/{id}/change-statut
     * @param id the task id
     * @return the updated task
     */
    public static void changeStatutTache(Long id) {
        Task task = Task.findById(id);
        task.done = !task.done;
        task.save();
        renderJSON(task.toString());
    }


    /**
     * @DELETE Remove task.
     * Test (curl) : curl -X DELETE localhost:9000/api/tache/{id}
     * @param id the task id
     * @return the deleted task
     */
    public static void supprimeTache(Long id) {
        Task task = Task.findById(id);
        task.delete();
        renderJSON(task.toString());
    }
}
