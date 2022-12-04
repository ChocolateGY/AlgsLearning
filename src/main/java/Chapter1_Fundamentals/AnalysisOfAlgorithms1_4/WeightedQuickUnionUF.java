package Chapter1_Fundamentals.AnalysisOfAlgorithms1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class WeightedQuickUnionUF {
    int[] id;
    int[] sz;
    int count;
    int x= 0 ;
    public WeightedQuickUnionUF(int N){
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i <N; i++) {
            id[i] = i;
            sz[i] = 1;
            x++;
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p , int q ){
        return find(p) == find(q);
    }
    public int find(int p){
        while(id[p] != p) {
            p = id[p];
            x++;
        }
        return p;
    }
    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        if(sz[p] > sz[q]){
            id[qRoot] = pRoot;
            sz[p] += sz[q];
            x+=2;
        }else{
            id[pRoot] = qRoot;
            sz[q] += sz[p];
            x+=2;
        }
        count --;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p+"  "+q);
            StdOut.print("访问次数"+uf.x);
            StdOut.println(Arrays.toString(uf.id));
        }
        StdOut.println(uf.count+" components");

    }

}
