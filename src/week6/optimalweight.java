package week6;

import java.util.Arrays;
import java.util.Scanner;

public class optimalweight {
    public static int optimalWeight(int W, int[] w) {
        int[][] dp = new int[w.length + 1][W + 1];

        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= W; j++) {

                dp[i][j] = dp[i - 1][j];
                if (w[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + w[i - 1]);
                }
            }
        }

//        for(int[] d: dp) System.out.println(Arrays.toString(d));

        return dp[w.length][W];
    }


    public static void main(String[] args) {
        int W = 10;
        int[] w = {1, 4, 8};
        int k = optimalWeight(W, w);
        System.out.println(k);
    }
}
