package ua.edu.ukma;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("CSVHandler/ToDo.txt");
        CSVHandler.writeCSV(path, new String[][]{{"Buy groceries", "0"}, {"Do the laundry", "0"}, {"Clean the dishes", "1"}});
    }
}