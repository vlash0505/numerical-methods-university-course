package parsing;

import java.io.*;
import java.util.Scanner;

public class Serializer {

    public static int[][] parsePRConfig(File file) {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            Scanner scanner = new Scanner(in);

            final int size = scanner.nextInt();
            int[][] result = new int[size][size];

            while (scanner.hasNext()) {
                int fromNode = scanner.nextInt();
                int toNode = scanner.nextInt();

                result[fromNode][toNode] = 1;
            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("WRONG PARAMETRIZED FILE");
    }

}
