 package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Majority {
    // private static int getMajorityElement(int[] a, int left, int right) {
        static int countNum(int[] a, int num, int left, int right) {
            int count = 0;
            for (int i = left; i < right; i++) {
                if (a[i] == num) count++;
            }

            return count;
        }

        private static int getMajorityElementNaive(int[] a) {
            for (int num : a) {
                int count = 0;
                for (int i : a) {
                    if (i == num) count++;
                }
                if (count > a.length / 2) return num;
            }
            return -1;
        }


        private static int getMajorityElement(int[] a, int left, int right) {
            if (left == right) return -1;

            if (left + 1 == right) return a[left];

            int mid = left + (right - left) / 2;
            int leftMajority = getMajorityElement(a, left, mid);
            int rightMajority = getMajorityElement(a, mid, right);

            if (leftMajority == rightMajority && leftMajority != -1) return leftMajority;

            int leftCount = countNum(a, leftMajority, left, right);
            int rightCount = countNum(a, rightMajority, left, right);

            if (leftCount > (right - left) / 2) return leftMajority;
            if (rightCount > (right - left) / 2) return rightMajority;

            return -1;
        }
//
//        if (left == right) {
//            return -1;
//        }
//        if (left + 1 == right) {
//            return a[left];
//        }
//        Arrays.sort(a);
//        left = 0;
//        right = a.length - 1;
//        if (left == right) return -1;
//        Stack<Integer> ss = new Stack();
//        for (int i : a) {
//            if (ss.isEmpty() || ss.peek() == i) {
//                ss.push(i);
//                int k = a.length % 2 > 0 ? (a.length -1) / 2 : a.length / 2;
//                if (ss.size() > k) return 1;
//            } else {
//                ss.empty();
//                continue;
//            }
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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
