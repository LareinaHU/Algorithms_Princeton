package week5;

import java.util.Arrays;
import java.util.PriorityQueue;

public class stick {
    public static int connectSticks(int[] sticks) {
        if (sticks.length <= 1) return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int stick : sticks) {
            heap.offer(stick);
        }
        int start = heap.poll();
        int count = start;
        System.out.println(count);
        for (int i = 1; i < sticks.length; i++) {
            int s1 = heap.poll();
            int s = s1 + count;
            count += s;
            heap.offer(s);
        }

        return count - start *(sticks.length - 1);
    }

    public static void main(String[] args) {
        int[] sticks = {4, 3 , 2};
        Arrays.sort(sticks);
        for (int i : sticks) {
            System.out.println("i-------" + i);
        }
        int k = connectSticks(sticks);
        System.out.println(k);
    }
}
