import java.io.*;

public class Mapper {

    public static void main(String[] args) throws IOException {
        String inputFilePath = "StockDataSet.txt";
	String outputFilePath = "output.txt";

        BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
	PrintWriter writer = new PrintWriter(outputFilePath);

        String line;

        while ((line = br.readLine()) != null) {
            String[] items = line.split(",");
            if (items.length >= 8) {
                String stockName = items[0];
		String key = items[1];
                float price = Float.parseFloat(items[7]);
		writer.println(stockName + " " + key + " " + price);

                System.out.println(stockName + " " + key + " " + price);
            }
        }

        br.close();
	writer.close();
    }
}

