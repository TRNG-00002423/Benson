/**
 * Partner B — comparable task for PriorityQueue.
 * TODO: implement Comparable<Task> (document ordering rule)
 */
public class Task implements Comparable<Task> {
    // TODO fields priority, description
    private int priority;
    private String description;

    // TODO ctor, getters, toString
    

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }


    @Override
    public int compareTo(Task o) {
        return o.getPriority() - this.priority;
    }

    @Override
    public String toString() {
        return "Task [priority=" + priority + ", description=" + description + "]";
    }

    
}