import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StockMapper {

    public static void main(String[] args) throws IOException {
        // Specify the input file name
        String inputFilePath = "StockDataSet.txt";

        // Read the input file
        BufferedReader br = new BufferedReader(new FileReader(inputFilePath));

        String line;

        // Parse and display Stock Name and Price
        while ((line = br.readLine()) != null) {
            String[] items = line.split(",");
            if (items.length >= 8) { // Ensure there are enough elements
                String stockName = items[0];
 String key = items[1];
                float price = Float.parseFloat(items[7]);
                System.out.println(stockName + "," + key + " " + price);
            }
        }

        br.close();
    }
}
