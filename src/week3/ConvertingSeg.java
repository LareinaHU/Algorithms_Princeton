// package week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class ConvertingSeg {
    //write your code here
    private static int[] optimalPoints(Segment[] segments) {
        Arrays.sort(segments, new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                return o1.start - o2.start;
            }
        });
        Stack<Segment> stack = new Stack<>();
        for (int i = 0; i < segments.length; i++) {
            if (stack.isEmpty() || stack.peek().end < segments[i].start) {
                stack.push(segments[i]);
            } else {
                Segment tem = stack.pop();
                int start = Math.max(tem.start, segments[i].start);
                int end = Math.min(tem.end, segments[i].end);
                stack.push(new Segment(start, end));

            }
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i).end;
        }

        return result;
    }

    private static class Segment {
    int start, end;

    Segment(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

