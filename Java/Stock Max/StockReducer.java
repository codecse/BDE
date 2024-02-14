import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StockReducer{

    public static void main(String[] args) throws IOException {
        String fileName = "StockDataSet.txt";
        Map<String, Float> maxClosePrices = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String key = parts[0] + "," + parts[1];
                float closePrice = Float.parseFloat(parts[7]);

                if (!maxClosePrices.containsKey(key) || closePrice > maxClosePrices.get(key)) {
                    maxClosePrices.put(key, closePrice);
                }
            }
        }

        for (Map.Entry<String, Float> entry : maxClosePrices.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
