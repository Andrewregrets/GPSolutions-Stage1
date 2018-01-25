import java.io.*;
import java.util.*;

public class Main {

    private static String s;
    private static String t;

    public static void main(String[] args) throws IOException {
        readInputData();

        String result = isDescendant(t, s) ? "YES" : "NO";

        writeToFile(result);
    }

    private static boolean isDescendant(String t, String s) {
        char[] tArr = t.toCharArray();
        int i = 0;

        firstLoop:
        for (char sEl : s.toCharArray()) {
            for (; i < tArr.length; i++)
                if (sEl == tArr[i]) {
                    i++;
                    continue firstLoop;
                }
            return false;
        }

        return true;
    }

    private static void writeToFile(String valueToWrite) throws IOException {
        Writer wr = new FileWriter("OUTPUT.TXT");
        wr.write(valueToWrite);
        wr.close();
    }

    private static void readInputData() throws FileNotFoundException {
        Scanner reader = new Scanner(new File("INPUT.TXT"));

        s = reader.nextLine();
        t = reader.nextLine();
        reader.close();
    }
}
