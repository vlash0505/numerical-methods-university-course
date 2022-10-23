package methods;

public abstract class AbstractMethod {

    protected final static double EPS = 0.000001;

    protected final double[][] matrix;
    protected final double[] vectorB;
    protected final int N;

    public AbstractMethod(double[][] matrix, double[] vectorB) {
        this.matrix = matrix;
        this.vectorB = vectorB;
        this.N = matrix.length;
    }

    public abstract void solve();

    protected void printResult(double[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.println("x" + i + " = " + values[i]);
        }
        System.out.println("\n");
    }
}
