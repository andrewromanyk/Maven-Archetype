package ua.edu.ukma;

import java.util.HashMap;

public class ToDo {
    HashMap<String, Integer> todo = new HashMap<String, Integer>();

    public ToDo(HashMap<String, Integer> TD) {
        todo = new HashMap<>(TD);
    }

    public String[] getTasks() { return todo.keySet().toArray(new String[0]); }
    public Integer[] getStatuses() { return todo.values().toArray(new Integer[0]); }

    public HashMap<String, Integer> getToDos() { return new HashMap<>(todo); }
    public HashMap<String, Integer> getFinishedTodos() {
        return getToDos(1);
    }
    public HashMap<String, Integer> getUnfinishedTodos() {
        return getToDos(0);
    }

    private HashMap<String, Integer> getToDos(int sort){
        // sort = 1 - finished tasks
        // sort = 0 - unfinished tasks
        HashMap<String, Integer> TD = new HashMap<>();
        for (String key : todo.keySet()) {
            if (todo.get(key) == sort) {
                TD.put(key, todo.get(key));
            }
        }
        return TD;
    }

    public void add(String task){
        todo.put(task, 0);
    }

    public boolean finish(int number){
        if (number < 1 || number > todo.size()) return false;
        todo.put(getTasks()[number-1], 1);
        return true;
    }
    public boolean unfinish(int number){
        if (number < 1 || number > todo.size()) return false;
        todo.put(getTasks()[number-1], 0);
        return true;
    }

    public boolean delete(int number){
        if (number < 1 || number > todo.size()) return false;
        todo.remove(getTasks()[number-1]);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("ToDos:\n");
        int i = 1;
        for (String key : todo.keySet()) {
            result.append(i++).append(". ").append(key).append(": ");
            result.append(todo.get(key) == 1 ? "Done" : "Not Done").append('\n');
        }
        return result.toString();
    }
}
