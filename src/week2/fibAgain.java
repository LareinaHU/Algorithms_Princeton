package week2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class fibAgain {
    public static long getFibonacciOf(long n, long m) {
        long[][] F = {{1, 1}, {1, 0}};
        if (n == 0) return 0;
        if (n == 1) return 1;
        power(F, (n - 1));
        return F[0][0] % m;
    }

    /* Helper function that multiplies 2 matrices F and M of size 2*2, and
    puts the multiplication result back to F[][] */
    static void multiply(long F[][], long M[][]) {
        long x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        long y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        long z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        long w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    static void power(long[][] F, long n) {
        long i;
        long M[][] = {{1, 1}, {1, 0}};

        // n - 1 times multiply the matrix to {{1,0},{0,1}}
        for (i = 2; i <= n; i++) {
            multiply(F, M);
        }
    }


    /* Driver program to test above function */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciOf(n, m));
    }
}




