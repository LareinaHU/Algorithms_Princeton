package week2;

import java.math.BigInteger;

public class fibAgainBigInteger {
    /*
     * Fast matrix method. Easy to describe, but has a constant factor slowdown compared to doubling method.
     * [1 1]^n   [F(n+1) F(n)  ]
     * [1 0]   = [F(n)   F(n-1)].
     */
    private static BigInteger fastFibonacciMatrix(int n) {
        BigInteger[] matrix = {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO};
        return matrixPow(matrix, n)[1];
    }

    // Computes the power of a matrix. The matrix is packed in row-major order.
    private static BigInteger[] matrixPow(BigInteger[] matrix, int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        BigInteger[] result = {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE};
        while (n != 0) {  // Exponentiation by squaring
            if (n % 2 != 0)
                result = matrixMultiply(result, matrix);
            n /= 2;
            matrix = matrixMultiply(matrix, matrix);
        }
        return result;
    }

    // Multiplies two matrices.
    private static BigInteger[] matrixMultiply(BigInteger[] x, BigInteger[] y) {
        return new BigInteger[]{
                multiply(x[0], y[0]).add(multiply(x[1], y[2])),
                multiply(x[0], y[1]).add(multiply(x[1], y[3])),
                multiply(x[2], y[0]).add(multiply(x[3], y[2])),
                multiply(x[2], y[1]).add(multiply(x[3], y[3]))
        };
    }


    /*
     * Simple slow method, using dynamic programming.
     * F(n+2) = F(n+1) + F(n).
     */
    private static BigInteger slowFibonacci(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }
        return a;
    }


    // Multiplies two BigIntegers.
    private static BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }
}

