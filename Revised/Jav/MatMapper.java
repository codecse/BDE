import java.io.*;

public class MatMapper {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 3, 3}, {5, 5, 6}};
        int[][] matrix2 = {{1, 2}, {3, 4}, {5, 6}};

        try {
            FileWriter fileWriter = new FileWriter("output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            writeMatrixToFile(bufferedWriter, "M", matrix1);
            writeMatrixToFile(bufferedWriter, "N", matrix2);

            bufferedWriter.close();
            System.out.println("Output written to output.txt successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to output.txt: " + e.getMessage());
        }
    }

    private static void writeMatrixToFile(BufferedWriter writer, String matrixName, int[][] matrix) throws IOException {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                writer.write(matrixName + "," + i + "," + j + "," + matrix[i][j]);
                writer.newLine();
            }
        }
    }
}

