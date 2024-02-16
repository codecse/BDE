import java.io.*;
import java.util.*;

public class Reducer {

    public static void main(String[] args) throws IOException {
        String fileName = "output.txt";
        Map<String, Float> maxClosePrices = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");

                // Check if the line has at least three parts
                if (parts.length >= 3) {
                    String key = parts[0] + "," + parts[1];
                    float closePrice = Float.parseFloat(parts[2]);

                    if (!maxClosePrices.containsKey(key) || closePrice > maxClosePrices.get(key)) {
                        maxClosePrices.put(key, closePrice);
                    }
		}
            }
        }

        for (Map.Entry<String, Float> entry : maxClosePrices.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}

