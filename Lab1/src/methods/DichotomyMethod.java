package methods;


public class DichotomyMethod extends AbstractMethod {

    public DichotomyMethod(double a, double b, double eps) {
        super(a, b, eps);
    }

    public void performCalculation() {
        double c;
        double newC;
        if (!(equation(A) * equation(B) < 0)) {
            throw new IllegalArgumentException();
        }
        do {
            c = (A + B) / 2;
            if (equation(A) * equation(c) < 0) {
                B = c;
            } else {
                A = c;
            }
            newC = (A + B) / 2;
        } while (Math.abs(newC - c) >= 2 * eps);
        System.out.println("x " + newC);
        System.out.println("f(x) " + equation(newC));
    }

}
