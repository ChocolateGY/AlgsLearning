package Chapter1_Fundamentals.AnalysisOfAlgorithms1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class PathCompressionQuickUnionUF {
    int[] id;
    int count;
    public PathCompressionQuickUnionUF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    public boolean connected(int p , int q){
        return find(p) == find(q);
    }
    //迭代，还会有高度
//    public int find(int p){
//        while(id[p] != p){
//            id[p] = id[id[p]];// 这行代码进行路径压缩
//            p = id[p];
//        }
//        return p;
//    }
    //递归，最佳
    public int find(int p){
        if(id[p] != p){
            id[p] = find(id[p]);
        }
        return id[p];
//上述递归相当于一下代码，将每个子节点连向root节点
//        int root = p ;
//        while(id[root]!=root)
//            root = id[root];
//        int old_parent = p;
//        while(p!=root){
//            id[p] = root;
//            p = old_parent;
//            old_parent = id[old_parent];
//        }
//        return root;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count --;
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        PathCompressionQuickUnionUF uf = new PathCompressionQuickUnionUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p+"  "+q);
            StdOut.println(Arrays.toString(uf.id));
        }
        StdOut.println(uf.count+" components");

    }
}
