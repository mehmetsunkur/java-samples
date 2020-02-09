package sunkur.java.samples;
import java.util.Random;

public class SingleThreadMain {
    public static void main(String[] args) {
        int data[] = new int[1024*1024*1024]; //512MB
        long startMillis = System.currentTimeMillis();
        Random rnd = new Random();
        for (int i = 0 ; i < data.length; i++){
            data[i] = rnd.nextInt();
        }
        long fillCompleted = System.currentTimeMillis();
        int max = data[0];
        for(int i=1;i < data.length;i++){
            if(data[i] > max){
                max = data[i];
            }
        }
        long maxCompleted = System.currentTimeMillis();
        System.out.println("Max:" + max);
        System.out.printf("Single thread performance%nFill time: %dms%nFind Max time: %dms%n",  fillCompleted - startMillis, maxCompleted - fillCompleted );
    }
}
