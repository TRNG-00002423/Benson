package todo;

public class TodoDemo {
    public static void main(String[] args) {
        // TODO: add tasks, print, complete one, print again
        TodoListManager todoManager = new TodoListManager();
        todoManager.addTask("Feed fish");
        todoManager.addTask("Feed cat");
        todoManager.listTasks();
        System.out.println(todoManager.size());
        try{
            todoManager.completeTask(2);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Index out of bound");
        }
        todoManager.completeTask(1);
        todoManager.listTasks();
        System.out.println(todoManager.size());
    }
}