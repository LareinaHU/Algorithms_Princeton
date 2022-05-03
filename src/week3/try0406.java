//package week3;
//
//import java.util.*;
//
//public class try0406 {
//
//    public static int MS(int[] a, int l, int r) {
//        int count = 0;
//        int mid = 0;
//        if (l + 1 < r) {
//            mid = l + (r - l) / 2;
//            count += MS(a, l, mid);
//            count += MS(a, mid, r);
//            count += MM(a, l, mid, r);
//        }
//        return count;
//    }
//
//    public static int MM(int[] a, int left, int middle, int right) {
//        int n = 0;
//        int[] la = Arrays.copyOfRange(a, left, middle);
//        int[] ra = Arrays.copyOfRange(a, middle, right);
//        int ll = 0, rr = 0;
//        while (ll < la.length && rr < ra.length) {
//            if(la[ll] <= ra[rr]){
//                a[ll++] =
//            }else{
//
//            }
//        }
//
//        return n;
//    }
//}