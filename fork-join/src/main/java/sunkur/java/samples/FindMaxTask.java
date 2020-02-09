package sunkur.java.samples;
import java.util.concurrent.RecursiveTask;

public class FindMaxTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;
    private final int threshold;
    private final int[] myArray;
    private final int start;
    private final int end;
    public FindMaxTask(int[] myArray, int start, int end, int threshold) {
        super();
        this.threshold = threshold;
        this.myArray = myArray;
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        if(end - start < threshold) {
            int max = Integer.MIN_VALUE;
            for(int i = start; i <=end ; i++) {
                int n = myArray[i];
                if(n>max) {
                    max = n;
                }
            }
            return max;
        } else {
            int midway = (end - start) / 2 + start;
            FindMaxTask f1 = new FindMaxTask(myArray, start, midway, threshold);
            f1.fork();
            FindMaxTask f2 = new FindMaxTask(myArray, midway+1, end, threshold);
            return Math.max(f2.compute(), f1.join());
        }
    }
}
