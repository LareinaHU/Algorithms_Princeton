package week5;

import java.util.Scanner;

public class Edit {
    public static boolean EditDistance(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if (Math.abs(l1 - l2) >= 2) return false;
        if (l1 == 0 && l2 == 0) return false;
        int count = 0;
        for (int i = 0, j = 0; i < l1 && j < l2; ) {
            if (s.charAt(i) != t.charAt(i)) {
                count++;
                if (count >= 2) {
                    return false;
                }
            }
            i++;
            j++;

        }

        return true;
    }

    public static void main(String args[]) {
        String a = "qewrw";
        String b = "qeerw";
        System.out.println(EditDistance(a, b));

    }
}