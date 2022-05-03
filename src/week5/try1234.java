package week5;

import java.util.*;

public class try1234 {
    public static int connectSticks(int[] sticks) {
        if (sticks.length == 1) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i : sticks) {
            pq.add(i);
        }
        int ans = 0;
        int res = 0;
        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            ans = s1 + s2;
            res += ans;
            pq.add(ans);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 43, 543};
        System.out.println(connectSticks(a));
    }
}