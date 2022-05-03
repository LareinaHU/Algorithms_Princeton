public class pram_path_dp {
    private static int[][] memo;

    private static int path(int n) {

        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return dp(n - 1, n - 1, memo);
    }

    private static int dp(int i, int j, int[][] a) {
        if(i < 0 || j < 0) return 0;
        else if (j == 0) a[i][j] = 1;
        else if (i < j) a[i][j] = 0;

        else {
            a[i][j] = dp(i - 1, j, a) + dp(i, j - 1, a);
        }
        return a[i][j];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(path(i));
        }
    }
}
