package sunkur.java.samples;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinMain {
    public static void main(String[] args) {
        int data[] = new int[1024*1024*1024]; //512MB
        ForkJoinPool pool = new ForkJoinPool();
        long startMillis = System.currentTimeMillis();
        pool.invoke(new RandomArrayAction(data,0,data.length -1,1000));
        long fillCompleted = System.currentTimeMillis();
        Integer max = pool.invoke(new FindMaxTask(data, 0, data.length-1, 1000));
        long maxCompleted = System.currentTimeMillis();
        System.out.println("Max:" + max);
        System.out.printf("Fork-Join performance%nFill time : %dms%nFind Max time %dms%n",  fillCompleted - startMillis, maxCompleted - fillCompleted );

    }
}
