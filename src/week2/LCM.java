package week2;

import java.util.Scanner;

public class LCM {


    private static long lcm_naive(int a, int b) {
        int c = a / gcd(a,b);
        int d = b / gcd(a,b);

        return (long) c * d * gcd(a,b);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm_naive(a, b));
    }
}

