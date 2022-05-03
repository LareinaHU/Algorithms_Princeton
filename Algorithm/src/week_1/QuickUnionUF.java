package week_1;

import edu.princeton.cs.algs4.StdIn;

public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF QF = new QuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            System.out.println("original p: " + p + " ; original q: " + q);
            System.out.println(QF.connected(p, q));
            if (!QF.connected(p, q)) {

                QF.union(p, q);

            }
            System.out.println(QF.connected(p, q));
        }

    }
}
