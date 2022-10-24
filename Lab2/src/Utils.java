import java.util.Random;

public class Utils {

    protected static final int SIZE = 5;

    public static double[][] buildRandomMatrix() {
        double[][] matrix = new double[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = new Random().nextDouble(10.0);
            }
        }
        return matrix;
    }

    public static double[][] buildRandomHilbertMatrix() {
        double[][] matrix = new double[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = 1.0 / ((i + 1) + (j + 1) - 1.0);
            }
        }
        return matrix;
    }

    public static double[] buildVectorB(double[][] matrix) {
        int N = matrix.length;
        double[] vectorB = new double[N];
        for (int i = 0; i < N; i++) {
            vectorB[i] = 0;
            for (int j = 0; j < N; j++) {
                vectorB[i] += matrix[i][j];
            }
        }
        return vectorB;
    }
}
