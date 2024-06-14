#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("ToDo.txt");
        ToDo todo = new ToDo(CSVHandler.readCSV(path));
        boolean proceed = true;
        while(proceed){
            System.out.println(todo.toString());
            System.out.println("What do you want to do?");
            System.out.println("1: Add task");
            System.out.println("2: Remove task");
            System.out.println("3: Mark as done");
            System.out.println("4: Mark as not done");
            System.out.println("5: Leave and save${symbol_escape}n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            switch(input){
                case "1":
                    System.out.println("Enter name of the task to add: ");
                    String name = reader.readLine();
                    todo.add(name);
                    break;
                case "2":
                    System.out.println("Enter number of the task to remove: ");
                    String number = reader.readLine();
                    todo.delete(Integer.parseInt(number));
                    break;
                case "3":
                    System.out.println("Enter number of the task to mark as done: ");
                    String num = reader.readLine();
                    todo.finish(Integer.parseInt(num));
                    break;
                case "4":
                    System.out.println("Enter number of the task to mark as not done: ");
                    String num2 = reader.readLine();
                    todo.unfinish(Integer.parseInt(num2));
                    break;
                case "5":
                    proceed = false;
            }
        }
        CSVHandler.writeCSV(path, mapToStringArr(todo.getToDos()));
    }

    public static String[][] mapToStringArr(HashMap<String, Integer> map){
        String[][] arr = new String[map.size()][];
        int i = 0;
        for (String mapKey : map.keySet()){
            arr[i++] = new String[]{mapKey, Integer.toString(map.get(mapKey))};
        }
        return arr;
    }
}