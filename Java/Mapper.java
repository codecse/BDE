import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mapper {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    System.out.println(word + "\t" + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
