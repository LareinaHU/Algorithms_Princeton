package week4;

import java.util.Arrays;
import java.util.Random;


public class try0426 {

    static int[][] memo;

    static int numOfPathsToDest(int n) {
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dp(n - 1, n - 1, memo);
        // your code goes here
    }

    static int dp(int i, int j, int[][] memo) {
        if (i < 0 || j < 0) return 0;
        else if (j == 0) memo[i][j] = 1;
        else if (i < j) memo[i][j] = 0;
        else if (memo[i][j] != -1) {
            return memo[i][j];
        } else {
            memo[i][j] = dp(i, j - 1, memo) + dp(i - 1, j, memo);
        }

        return memo[i][j];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(numOfPathsToDest(i));
        }
    }
}



