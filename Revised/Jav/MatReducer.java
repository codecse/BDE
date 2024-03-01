import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatReducer {
    public static void main(String[] args) {
        int[][] matrix1 = new int[2][3];
        int[][] matrix2 = new int[3][2];

        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals("M")) {
                    int i = Integer.parseInt(parts[1]);
                    int j = Integer.parseInt(parts[2]);
                    int value = Integer.parseInt(parts[3]);
                    matrix1[i][j] = value;
                } else if (parts[0].equals("N")) {
                    int i = Integer.parseInt(parts[1]);
                    int j = Integer.parseInt(parts[2]);
                    int value = Integer.parseInt(parts[3]);
                    matrix2[i][j] = value;
                }
            }
            reader.close();

            int[][] result = multiplyMatrices(matrix1, matrix2);
            printMatrix(result);
        } catch (IOException e) {
            System.err.println("Error reading from output.txt: " + e.getMessage());
        }
    }

    private static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int m = a.length;
        int n = b[0].length;
        int p = b.length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

