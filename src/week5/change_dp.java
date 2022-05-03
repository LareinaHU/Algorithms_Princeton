package week5;

import java.util.Arrays;
import java.util.Scanner;

public class change_dp {
    private static int getchange(int m) {
        int[] coins = {1, 3, 4};
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= m; i++){
            for(int coin: coins){
                if(i >= coin){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[m];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getchange(m));

    }
}
