#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("${artifactId}/ToDo.txt");
        ${artifactId}.writeCSV(path, new String[][]{{"Buy groceries", "0"}, {"Do the laundry", "0"}, {"Clean the dishes", "1"}});
    }
}