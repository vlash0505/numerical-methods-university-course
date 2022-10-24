import methods.gaussian.GaussMethod;
import methods.jacobi.JacobiMethod;
import methods.seidel.SeidelMethod;

public class EntryPoint {

    public static void main(String[] args) {
        final double[][] matrix = Utils.buildRandomMatrix();
        final double[][] hilbertMatrix = Utils.buildRandomHilbertMatrix();
        final double[] vectorB = Utils.buildVectorB(matrix);

        System.out.println("Gauss method result: ");
        new GaussMethod(matrix, vectorB);
        System.out.println("Jacobi method result: ");
        new JacobiMethod(matrix, vectorB);
        System.out.println("Seidel method result: ");
        new SeidelMethod(matrix, vectorB);
    }
}
