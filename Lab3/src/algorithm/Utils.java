package algorithm;

public class Utils {

    public static double findNorm(double[] firstVector, double[] secondVector) {
        double result = 0;
        for (int i = 0; i < firstVector.length; i++) {
            result += Math.abs(firstVector[i] - secondVector[i]);
        }
        return result;
    }

    public static double[][] multiplyMatrixByScalar(double[][] matrix, double number) {
        double[][] new_matrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                new_matrix[i][j] = matrix[i][j] * number;
            }
        }
        return new_matrix;
    }

    public static double[] multiplyMatrixByVector(double[][] markovMatrix, double[] x0) {
        double[] result = new double[markovMatrix.length];
        for (int i = 0; i < markovMatrix.length; i++) {
            for (int j = 0; j < markovMatrix.length; j++) {
                result[i] += markovMatrix[i][j] * x0[j];
            }
        }
        return result;
    }

    public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[secondMatrix.length][secondMatrix.length];
        for (int i = 0; i < secondMatrix.length; i++) {
            for (int j = 0; j < secondMatrix.length; j++) {
                for (int k = 0; k < secondMatrix.length; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return result;
    }

    public static double[][] addMatrices(double[][] matrix, double[][] matrix2) {
        double[][] new_matrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                new_matrix[i][j] = matrix[i][j] + matrix2[i][j];
            }
        }
        return new_matrix;
    }

    public static double[][] getMatrixDegree(double[][] matrix, int degree) {
        double[][] result = matrix;
        for (int i = 1; i < degree; i++) {
            result = multiplyMatrices(result, matrix);
        }
        return result;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] vector : matrix) {
            printVector(vector);
        }
    }

    public static void printVector(double[] vector){
        for (double i: vector) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
