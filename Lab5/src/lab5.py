import numpy
import numpy as np
import matplotlib.pyplot as plt
from scipy.interpolate import CubicSpline

def function(x):
    return x ** 3 + 2 * x ** 2 - 3 * x + 1

def newton(xn, yn):
    split_diff = []
    for i in range(0, len(xn)):
        if i == 0:
            split_diff.append(yn)
            continue
        split_diff.append(line_calc(i, xn, split_diff[i - 1]))

    result = np.poly1d([split_diff[0][0]])
    for i in range(1, len(split_diff)):
        result += newton_polynomial(split_diff[i][0], xn, i)
    return result

def newton_polynomial(split_diff, xn, k):
    result = np.poly1d([split_diff])
    for i in range(0, k):
        result *= np.poly1d([1, -xn[i]])
    return result

def lagrange(xn, yn):
    result = np.poly1d([0])
    for i in range(len(xn)):
        result += lagrange_polinomial(xn, yn[i], i)
    return result

def lagrange_polinomial(xn, yi, i):
    result = np.poly1d([yi])
    for j in range(len(xn)):
        if i != j:
            result *= np.poly1d([1, -xn[j]]) / (xn[i] - xn[j])
    return result

def line_calc(p, xn, fx):
    i = 0
    j = 0
    result = np.zeros(len(xn) - p, dtype=float)
    while (i + p) < len(xn):
        result[j] = (fx[i + 1] - fx[i]) / (xn[i + p] - xn[i])
        j += 1
        i += 1
    return result

def yn(xn):
    y = []
    for xi in xn:
        y.append(function(xi))
    return y

#for reference see: https://stackoverflow.com/questions/31543775/how-to-perform-cubic-spline-interpolation-in-python
def cubic_interpolate(x0, x, y):
    xdiff = np.diff(x)
    dydx = np.diff(y)
    dydx /= xdiff

    n = size = len(x)

    w = np.empty(n-1, float)
    z = np.empty(n, float)

    w[0] = 0.
    z[0] = 0.
    for i in range(1, n-1):
        m = xdiff[i-1] * (2 - w[i-1]) + 2 * xdiff[i]
        w[i] = xdiff[i] / m
        z[i] = (6*(dydx[i] - dydx[i-1]) - xdiff[i-1]*z[i-1]) / m
    z[-1] = 0.

    for i in range(n-2, -1, -1):
        z[i] = z[i] - w[i]*z[i+1]

    index = x.searchsorted(x0)
    np.clip(index, 1, size-1, index)

    xi1, xi0 = x[index], x[index-1]
    yi1, yi0 = y[index], y[index-1]
    zi1, zi0 = z[index], z[index-1]
    hi1 = xi1 - xi0

    f0 = zi0/(6*hi1)*(xi1-x0)**3 + \
        zi1/(6*hi1)*(x0-xi0)**3 + \
        (yi1/hi1 - zi1*hi1/6)*(x0-xi0) + \
        (yi0/hi1 - zi0*hi1/6)*(xi1-x0)
    return f0

if __name__ == "__main__":
    xn = [0, 2, 3, 4]
    yn = yn(xn)

    x = np.asfarray(xn)
    y = np.asfarray(yn)
    x_new = np.linspace(x.min(), x.max(), 100)
    y_new = cubic_interpolate(x_new, x, y)
    plt.plot(x_new, y_new)
    f = CubicSpline(x, y, bc_type='natural')
    plt.plot(x_new, f(x_new), label='ref')

    lagr = lagrange(xn, yn)
    newt = newton(xn, yn)
    print(lagr)
    print(newt)

    plt.plot(xn, [numpy.polyval(lagr, x) for x in xn], 'b-')
    plt.plot(xn, [numpy.polyval(newt, x) for x in xn], 'g-')
    plt.show()
