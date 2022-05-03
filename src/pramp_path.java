public class pramp_path {
    static int res;

    static int numOfPathsToDest(int n) {
        // your code goes here
        res = 0;
        reverse(0, 0, n);
        return res;
    }

    static void reverse(int i, int j, int n) {
        if (i == n - 1 && j == n - 1) res++;
        if (validate(i + 1, j, n)) reverse(i + 1, j, n);
        if (validate(i, j + 1, n)) reverse(i, j + 1, n);
    }

    static boolean validate(int i, int j, int n) {
        return (i < n && j < n && i >= j);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            //  int i = 3;
            System.out.println(numOfPathsToDest(i));
        }
    }
}