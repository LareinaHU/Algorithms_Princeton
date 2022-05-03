package week3;

import java.util.Scanner;

public class change {
    private static int getChange(int m) {
        int count = 0;

            count = m / 10 + (m % 10) / 5 + ((m % 10) % 5) / 1;
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }

}
