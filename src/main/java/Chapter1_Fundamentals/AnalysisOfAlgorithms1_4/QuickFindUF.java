package Chapter1_Fundamentals.AnalysisOfAlgorithms1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class QuickFindUF {
    private int[] id;
    private int count;
    int x= 0 ;

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            x++;
        }
    }

    public boolean connceted(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        x++;
        return id[p];
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId != qId){
            for (int i = 0; i < id.length; i++) {
                if(id[i] == qId )id[i] = pId;
                x++;
            }
            count --;
        }
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connceted(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
            StdOut.print("访问次数"+uf.x);
            StdOut.println(Arrays.toString(uf.id));
        }
        StdOut.println(uf.count + " components");

    }
}
