package PartOne;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sklar on 8/31/2016.
 */
public class API {
    private Random random = new Random();
    private ArrayList<Integer> array = new ArrayList<>();
    private int maxSize;

    private double totaltime;
    private int multiplier = 7;

    private void run(){
        this.maxSize = 10000;
        for (int i = 0; i < maxSize; i++) { //random nummertjes machen
            array.add(random.nextInt(10000));
        }

        for (int i = 0; i < multiplier; i++) {

            long tStart = System.currentTimeMillis();
            ArrayList<Integer> sorted = this.bubbleSort(array);
            long tEnd = System.currentTimeMillis();
            long tDelta = tEnd - tStart;
            double elapsedSeconds = tDelta / 1000.0;

            if(i != 0 && i != 6){
                totaltime += elapsedSeconds;
            }
        }

        this.multiplier = this.multiplier - 2;
        System.out.println("Average : " + (Double.toString(totaltime/multiplier)));
    }

    public ArrayList<Integer> bubbleSort(ArrayList<Integer> invoer) {
        int i, j, tijdelijk;
        for (j = 0; j < invoer.size(); j++) {
            for (i = 1; i < invoer.size() - j; i++) {
                if (invoer.get(i-1) > invoer.get(i)) {
                    tijdelijk = invoer.get(i);
                    invoer.set(i,invoer.get(i-1));
                    invoer.set(i-1,tijdelijk);
                }
            }
        }
        return invoer;
    }

    public static void main(String args[]){
        new API().run();
    }
}
