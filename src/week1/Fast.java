package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Fast {
    static long getMaxPairwiseProduct(int[] numbers) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        if (numbers.length < 2) return 0;
        for (int num : numbers) {
            if (numbers.length != 0) {
                heap.offer(num);
            }
        }
        long k1 = heap.poll();
        long k2 = heap.poll();
        return k1 * k2;  //Notice, if you want the result be a long style，
        // the two input numbers should also be long number.
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
