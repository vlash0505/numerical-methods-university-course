package methods.gaussian;

public class LUDecomposition {

    private int[][] lowerDecomposedMatrix;
    private int[][] upperDecomposedMatrix;

    public LUDecomposition(int[][] matrix) {
        decompose(matrix);
    }

    private void decompose(int[][] matrix) {
        int size = 5;

        int[][] lowerMatrix = new int[size][size];
        int[][] upperMatrix = new int[size][size];

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

    public int[][] getLowerDecomposedMatrix() {
        return lowerDecomposedMatrix;
    }

    public int[][] getUpperDecomposedMatrix() {
        return upperDecomposedMatrix;
    }
}
