package week_1;

import edu.princeton.cs.algs4.StdIn;

public class UF {

    public UF(int N) {
    }



    boolean connected(int p, int q){
        return p-q>0;
    }

    void union(int p,int q){
        return;
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
       UF uf = new UF(N);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(!uf.connected(p,q)){
                uf.union(p,q);
                System.out.println("p: " + p+" ; q: "+q);
            }
        }
    }
}
