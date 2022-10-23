package methods.gaussian;

public class LUDecomposition {

    private double[][] lowerDecomposedMatrix;
    private double[][] upperDecomposedMatrix;

    public LUDecomposition(double[][] matrix) {
        decompose(matrix);
    }

    private void decompose(double[][] matrix) {
        int size = 5;

        double[][] lowerMatrix = new double[size][size];
        double[][] upperMatrix = new double[size][size];

        //Matrix decomposition into upper and
        //lower triangular matricies
        for (int i = 0; i < size; i++) {
            //upper
            for (int j = i; j < size; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += (lowerMatrix[i][k] * upperMatrix[k][j]);
                }
                upperMatrix[i][j] = matrix[i][j] - sum;
            }
            //lower
            for (int j = i; j < size; j++) {
                if (i == j) {
                    lowerMatrix[i][i] = 1;
                }
                else {
                    int sum = 0;
                    for (int k = 0; k < i; k++) {
                        sum += (lowerMatrix[j][k] * upperMatrix[k][i]);
                    }
                    lowerMatrix[j][i] = (matrix[j][i] - sum) / upperMatrix[i][i];
                }
            }
        }
        lowerDecomposedMatrix = lowerMatrix;
        upperDecomposedMatrix = upperMatrix;
    }

    public double[][] getLowerDecomposedMatrix() {
        return lowerDecomposedMatrix;
    }

    public double[][] getUpperDecomposedMatrix() {
        return upperDecomposedMatrix;
    }
}
