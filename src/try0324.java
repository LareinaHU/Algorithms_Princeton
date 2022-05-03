import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class try0324 {
    public static int[][] a;

    static int numOfPathsToDest(int n) {
        a = new int[n][n];

        return dp(n - 1, n - 1);
    }

    public static int dp(int i, int j) {
        if (i < 0 || j < 0) return 0;
        else if (i < j) return 0;
        else if (j == 0) return 1;
        else {
            return dp(i - 1, j) + dp(i, j - 1);
        }
    }


    public static void main(String[] args) {
    for(int i = 0; i <= 5; i ++){
        System.out.println(numOfPathsToDest(i));
    }



    }
}


