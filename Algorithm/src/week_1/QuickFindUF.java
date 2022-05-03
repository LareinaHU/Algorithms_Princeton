package week_1;

import edu.princeton.cs.algs4.StdIn;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {

        return id[p] == id[q];

    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            System.out.println("original p: " + p + " ; original q: " + q);
            System.out.println(uf.connected(p, q));
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println("p: " + p + " ; q: " + q);
            }
        }
    }

}
