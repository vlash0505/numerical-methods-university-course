package methods;

public class RelaxationMethod extends AbstractMethod {

    public RelaxationMethod(double a, double b, double eps) {
        super(a, b, eps);
    }

    public void performCalculation() {
        double M1 = 6, m1 = 2;
        double tau = -2.0 / (M1 + m1);
        double x1 = A;
        double x = Double.MAX_VALUE;
        int i = 0;

        while (Math.abs(x - x1) >= eps) {
            x = x1;
            x1 = x + tau * equation(x);
            i++;
        }
        System.out.println("i " + i);
        System.out.println("x " + x);
        System.out.println("f(x) " + equation(x));
    }
}
