package todo;

import java.util.ArrayList;
import java.util.List;

public class TodoListManager {
    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        this.tasks.add(task);
    }

    public String getTask(int index) {
        if(index > this.tasks.size()){
            throw new IndexOutOfBoundsException();
        }
        return this.tasks.get(index);
    }

    public void completeTask(int index) {
        this.tasks.remove(index);    
    }

    public List<String> listTasks() {
        System.out.println("Listing tasks:");
        for(String task: this.tasks){
            System.out.println(task);
        }
        return this.tasks;
    }

    public int size() {
        return this.tasks.size();
    }
}