import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reducer {

    public static void main(String[] args) throws IOException {
        // Input file path
        String inputFile = "mapper_output.txt";

        // Read input file
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();

        // Split the input into words
        String[] words = content.toString().split("\\s+");

        // Map phase
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            // Skip counting if the word consists entirely of digits
            if (word.matches("\\d+")) {
                continue;
            }
            
            // Update word count
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        // Reduce phase
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

