import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] array = readArrayFromFile();

        Collection resultCollection = FindSubsequenceWithGreatestAbsSum(array);

        writeOutput(resultCollection);
    }

    private static int[] readArrayFromFile() throws FileNotFoundException {
        Scanner reader = new Scanner(new File("INPUT.TXT"));
        int arraySize =  reader.nextInt();
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = reader.nextInt();
        }
        reader.close();

        return array;
    }

    private static Collection<Integer> FindSubsequenceWithGreatestAbsSum(int[] array) {
        int posSumAbs = 0;
        int negSumAbs = 0;

        Collection<Integer> positiveNumbersPositions = new ArrayDeque<>();
        Collection<Integer> negativeNumbersPositions = new ArrayDeque<>();

        for (int i = 0; i < array.length; i++) {
            if(array[i] > 0) {
                posSumAbs += array[i];
                positiveNumbersPositions.add(i+1);
            }
            if(array[i] < 0) {
                negSumAbs -= array[i];
                negativeNumbersPositions.add(i+1);
            }
        }

        if(posSumAbs > negSumAbs)
            return positiveNumbersPositions;
        else
            return negativeNumbersPositions;
    }

    private static void writeOutput(Collection<Integer> collectionToWrite) throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append(collectionToWrite.size()).append('\n');

        for (int number :
                collectionToWrite) {
            sb.append(number).append(' ');
        }

        writeToFile(sb.toString().trim());
    }

    private static void writeToFile(String valueToWrite) throws IOException {
        Writer wr = new FileWriter("OUTPUT.TXT");
        wr.write(valueToWrite);
        wr.close();
    }
}
