package Chapter1_Fundamentals.AnalysisOfAlgorithms1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class UF {
    private int[] id;
    private int[] sz;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;

        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

//    public int find(int p) {
//        return id[p];
//    }
//
//    public void union(int p, int q) {
//        int pId = find(p);
//        int qId = find(q);
//
//        if(pId == qId) return;
//
//        for (int i = 0; i < id.length; i++) {
//            if(id[i] == pId) id[i] = qId;
//        }
//        count --;
//    }

    public int find(int p) {
        while(id[p] != p) p = id[p];
        return p;
    }
    public void union(int p,int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
//        id[pRoot] = qRoot;
        if(sz[pRoot]< sz[qRoot]){
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else{
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count --;
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        Stopwatch timer = new Stopwatch();
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q))continue;
            uf.union(p,q);
            StdOut.println(p+"  "+q);
        }
        double time = timer.elapsedTime();
        StdOut.println(uf.count() + "  components.  " + time + " seconds");
    }

/**
 * /Users/bytedance/projectspace/algs-data/tinyUF.txt
 * 10
 * 4 3
 * 3 8
 * 6 5
 * 9 4
 * 2 1
 * 8 9
 * 5 0
 * 7 2
 * 6 1
 * 1 0
 * 6 7
 */
}
