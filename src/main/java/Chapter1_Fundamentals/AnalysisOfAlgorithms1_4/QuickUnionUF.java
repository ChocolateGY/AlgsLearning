package Chapter1_Fundamentals.AnalysisOfAlgorithms1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class QuickUnionUF {
    private int[] id;
    private int count;
    int x= 0 ;
    public QuickUnionUF(int N){
        count = N;
        id = new int[N];
        for(int i = 0; i< N ;i++){
            id[i] = i;
            x++;
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p , int q){
        return find(p) == find(q);
    }
    public int find(int p){
        while(p != id[p] ) {
            x++;
            p = id[p];
        }
        return p;
    }
    public void union(int p ,int q){
        int pId = find(p);
        int qId = find(q);
        if(pId == qId) return;
        id[pId] = qId; //是id[pId]而非id[p]
        x++;
        count --;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            StdOut.print(p+"  "+q);
            if(uf.connected(p,q)){
                StdOut.println();
                continue;
            }
            uf.union(p,q);
            StdOut.println("  union");
            StdOut.print("访问次数"+uf.x);
            StdOut.println(Arrays.toString(uf.id));
        }
        StdOut.println(uf.count+"  components.");
        StdOut.println(Math.log(2)/Math.log(2));
        StdOut.println(Math.log(10)/Math.log(2));
    }
}

/**
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