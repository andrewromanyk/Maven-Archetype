#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import com.opencsv.*;

public class ${artifactId} {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("ToDo.txt");
        writeCSV(path, new String[][]{{"Clean the dishes", "0"} , {"Buy groceries", "0"}});
        Map<String, Integer> map = readCSV(path);
        System.out.println(map);
    }

    public static HashMap<String, Integer> readCSV(Path filename) throws Exception {
        try (Reader reader = Files.newBufferedReader(filename)) {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withIgnoreQuotations(false)
                    .build();
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(0)
                    .withCSVParser(parser)
                    .build();
            HashMap<String, Integer> map = new HashMap<>();
            String[] line;
            while ((line = csvReader.readNext()) != null){
                map.put(line[0], Integer.parseInt(line[1]));
            }
            return map;
        }
    }
    public static void writeCSV(Path path, String[][] lines) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            for (String[] line : lines){
                writer.writeNext(line);
            }
        }
    }
}
