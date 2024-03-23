import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Mapper {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            File outputFile = new File("mapper_output.txt");
            
            Scanner scanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(outputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    writer.write(word + "\t" + 1 + "\n");
                }
            }

            // Close the resources
            scanner.close();
            writer.close();
            
            System.out.println("Output has been written to mapper_output.txt");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

