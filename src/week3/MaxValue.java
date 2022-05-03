 package week3;

import java.util.HashMap;
import java.util.Scanner;

public class MaxValue {
    private static int getMaxDensity(int[] values, int[] weights) {
        double max = 0;
        int MaxIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if (weights[i] != 0 && (double) values[i] / weights[i] > max) {
                max = (double) values[i] / weights[i];
                MaxIndex = i;
            }
        }
        return MaxIndex;
    }

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double V = 0;

        for (int i = 0; i < values.length; i++) {
            if (capacity <= 0) return V;
            int maxIndex = getMaxDensity(values, weights);
            int a = Math.min(weights[maxIndex], capacity);
            V += a * (double) values[maxIndex] / weights[maxIndex];
            weights[maxIndex] -= a;
            capacity -= a;
        }
        return V;
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }

}
