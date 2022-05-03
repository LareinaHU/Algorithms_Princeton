package week2;

import java.util.HashMap;
import java.util.Scanner;

public class fibAgainTimeExceeded {

    public static long getFibonacciOf(long n, long m) {
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0l, 0l);
        map.put(1l, 1l);
        if (n == 0) return 0;
        if (n == 1) return 1;
        for (long i = 2; i <= n; i++) {
            if (map.containsKey(i - 1) && map.containsKey(i - 2)) {
                map.put(i, (map.get(i - 1) + map.get(i - 2))%m);
            }
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciOf(n, m));

    }
}