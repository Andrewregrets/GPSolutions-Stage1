import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int wantedI;
    private static int wantedJ;
    private static int p;

    public static void main(String[] args) throws IOException {
//        long startTime = System.nanoTime();

        BufferedReader reader = new BufferedReader(new FileReader("INPUT.TXT"));
        readGeneralInputData(reader);

        int result = calculateResult(reader);
        writeToFile(Integer.toString(result));

//        long endTime = System.nanoTime();
//        System.out.printf("Result: %s\n", result);
//        System.out.printf("Elapsed time in milliseconds: %f\n", (endTime - startTime) / 1000000.0);
    }

    private static void readGeneralInputData(BufferedReader reader) throws IOException {
        String[] numbersStr = reader.readLine().split(" ");
        m = Integer.parseInt(numbersStr[0]);
        n = Integer.parseInt(numbersStr[1]);

        numbersStr = reader.readLine().split(" ");
        wantedI = Integer.parseInt(numbersStr[0]) - 1;
        wantedJ = Integer.parseInt(numbersStr[1]) - 1;

        p = Integer.parseInt(reader.readLine());
    }


    private static int[][] readNextMatrix(BufferedReader reader) throws IOException {
        reader.readLine();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            matrix[i] = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static int[] readFirstMatrixNeededArray(BufferedReader reader) throws IOException {
        reader.readLine();

        for (int i = 0; i < wantedI; i++) {
            reader.readLine();
        }

        String line = reader.readLine();

        for (int i = wantedI; i < n - 1; i++) {
            reader.readLine();
        }

        return Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int calculateResult(BufferedReader reader) throws IOException {
        int[] resultArray = readFirstMatrixNeededArray(reader);

        if (m == 1)
            return resultArray[wantedJ];

        for (int i = 1; i < m; i++) {
            resultArray = multiplyArrayMatrix(resultArray, readNextMatrix(reader));
        }

        return resultArray[wantedJ];
    }

    private static int[] multiplyArrayMatrix(int[] array, int[][] matrix) {
        int[] resultArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                resultArray[i] += array[j] * matrix[j][i];
                resultArray[i] %= p;
            }
        }
        return resultArray;
    }

    private static void writeToFile(String valueToWrite) throws IOException {
        Writer wr = new FileWriter("OUTPUT.TXT");
        wr.write(valueToWrite);
        wr.close();
    }
}
