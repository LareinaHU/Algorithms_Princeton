package week2;

import java.util.Scanner;

public class fibonacci_last_digit {
    private static long getFibonacciLastDigitNaive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 10;
        }
        return fib[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}
