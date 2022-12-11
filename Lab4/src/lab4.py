import numpy as np
from math import sin, cos

def function(x: np.array) -> np.array:
    return np.array([x[0] ** 2 / x[1] ** 2 - cos(x[1]) - 2, x[0] ** 2 + x[1] ** 2 - 6])


def derivative(x: np.array) -> np.array:
    return np.array([
        [2 * x[0] / x[1] ** 2, -2 * x[0] ** 2 / x[1] ** 3 + sin(x[1])],
        [2 * x[0], 2 * x[1]]
    ])

def newton(x_0: np.array, func, derivative, epsilon: float) -> np.array:
    x = x_0
    i = 0
    while True:
        i += 1
        a = derivative(x)
        b = func(x)
        z = np.linalg.solve(a, b)
        x -= z
        if max(np.abs(z)) < epsilon:
            break
    print(i)
    return x

def newton_modified(x_0: np.array, func, derivative, epsilon: float) -> np.array:
    x = x_0
    a = np.linalg.inv(derivative(x))
    i = 0
    while True:
        i += 1
        b = func(x)
        z = np.linalg.solve(a, b)
        x -= z
        if max(np.abs(z)) < epsilon:
            break
    print(i)
    return x

def relaxation(x_0: np.array, func, derivative, epsilon: float):
    tau = 1 / derivative(x_0).max()
    x = x_0 - func(x_0) * tau
    i = 0
    while np.max(np.abs(x - x_0)) >= epsilon:
        i += 1
        x_0 = x
        x = x_0 - func(x_0) * tau
    print(i)
    return x

if __name__ == "__main__":
    print("Newton method:")
    sol = newton([0, 0], function, derivative, 0.001)
    print(f"Approx. solution - {sol}")
    sol = newton([2, 1.4], function, derivative, 0.001)
    print(f"Approx. solution - {sol}")

    print("Modified Newton method: ")
    sol = newton_modified([0, 0], function, derivative, 0.2)
    print(f"Approx. solution - {sol}")
    sol = newton_modified([2, 1.4], function, derivative, 0.001)
    print(f"Approx. solution - {sol}")

    print("Relaxation method")
    sol = relaxation(np.array([0, 0]), function, derivative, 0.002)
    print(f"Approx. solution - {sol}")
    sol = relaxation(np.array([2, 1.4]), function, derivative, 0.001)
    print(f"Approx. solution - {sol}")

