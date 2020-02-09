package sunkur.java.samples;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayAction extends RecursiveAction {
    private final int[] myArray;
    private final int start, end;
    private final int treshold;

    public RandomArrayAction(int[] myArray, int start, int end, int treshold) {
        this.myArray = myArray;
        this.start = start;
        this.end = end;
        this.treshold = treshold;
    }


    @Override
    protected void compute() {
        if (end - start < treshold) {
            // set array
            for (int i = start; i <= end; i++) {
                this.myArray[i] = ThreadLocalRandom.current().nextInt();
            }
        } else {
            // split array to be set
            int midway = (end - start) / 2 + start;
            RandomArrayAction r1 = new RandomArrayAction(myArray, start, midway, treshold);
            RandomArrayAction r2 = new RandomArrayAction(myArray, midway + 1, end, treshold);
            invokeAll(r1, r2);
        }
    }
}
