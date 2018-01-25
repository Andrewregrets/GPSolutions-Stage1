import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int sourceN = readIntFromFile();

        int resultN = FindNumber(sourceN);

        writeToFile(Integer.toString(resultN));
    }

    private static int FindNumber(int sourceN) {
        int resultPosition = 0;
        int resultN = 0;

        while (resultPosition < sourceN) {
            resultN++;
            if(!hasDuplicateDigits(Integer.toString(resultN).toCharArray()))
                resultPosition++;
        }

        return resultN;
    }

    private static boolean hasDuplicateDigits(char[] digits) {
        int numberOfDigits = digits.length;

        for (int i = 0; i < numberOfDigits-1; i++)
            for (int j = i + 1; j < numberOfDigits; j++)
                if(digits[i] == digits[j])
                    return true;

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
