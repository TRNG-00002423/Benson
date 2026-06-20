import java.util.PriorityQueue;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Partner B — drain PriorityQueue in priority order. */
public class TaskQueueApp {
    private static Logger logger = LoggerFactory.getLogger("pair.b.tasks");
    public static void main(String[] args) {
        Queue<Task> q = new PriorityQueue<>();
        // TODO: offer tasks out of order, poll and print, peek demo
        q.add(new Task(1, "walk dog"));
        q.add(new Task(3, "cooking"));
        q.add(new Task(2, "guitar"));

        logger.info((q.peek()).toString());

        while (!q.isEmpty()) {
            Task task = q.poll();
            logger.debug(task.toString());
        }
    }
}