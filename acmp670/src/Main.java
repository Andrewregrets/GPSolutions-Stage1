import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int sourceN = readIntFromFile();

        int resultN;
        resultN = FindNumber(sourceN);
        writeToFile(Integer.toString(resultN));
    }

    private static int FindNumber(int sourceN) {
        int resultPosition = 0;
        int resultN = 0;

        while (resultPosition < sourceN) {
            resultN++;
            if(!hasDuplicateDigits(resultN))
                resultPosition++;
        }

        return resultN;
    }

    private static boolean hasDuplicateDigits(int number) {
        final int MAX_DECIMAL_DIGITS_IN_INT = 10;
        boolean[] flagArr = new boolean[MAX_DECIMAL_DIGITS_IN_INT];

        while (number > 0) {
            int r = number % 10;
            if (flagArr[r])
                return true;
            else flagArr[r] = true;
            number /= 10;
        }

        return false;
    }

    private static void writeToFile(String valueToWrite) throws IOException {
        Writer wr = new FileWriter("OUTPUT.TXT");
        wr.write(valueToWrite);
        wr.close();
    }

    private static int readIntFromFile() throws FileNotFoundException {
        Scanner reader = new Scanner(new File("INPUT.TXT"));
        int result = reader.nextInt();
        reader.close();

        return result;
    }
}
