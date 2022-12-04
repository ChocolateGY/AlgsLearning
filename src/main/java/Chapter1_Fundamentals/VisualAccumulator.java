package Chapter1_Fundamentals;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class VisualAccumulator {
    private double total;
    private int N;
    public VisualAccumulator(int trials,double max){
        StdDraw.setXscale(0,trials);
        StdDraw.setXscale(0,max);
        StdDraw.setPenRadius(.005);
    }
    public void addDataValue(double val){
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N,val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N,total/N);
    }

    public  double mean(){
        return total/N;
    }

    @Override
    public String toString() {
        return "Mean ("+N+" values): " + String.format("%7.5f",mean());
    }

    public static void main(String[] args) {
        int t = 200;
        VisualAccumulator a = new VisualAccumulator(t,1.0);
        for (int i = 0; i < t; i++) {
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);

    }
}
