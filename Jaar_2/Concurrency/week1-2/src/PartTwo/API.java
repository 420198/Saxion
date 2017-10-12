package PartTwo;

import com.sun.scenario.effect.Merge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sklar on 8/31/2016.
 */
public class API {
    private Random random = new Random();
    private List<Integer> array_unsorted_main = new ArrayList<>();
    private List<Integer> array_unsorted_sub_1 = new ArrayList<>();
    private List<Integer> array_unsorted_sub_2 = new ArrayList<>();

    private List<Integer> array_sorted_main = new ArrayList<>();
    private List<Integer> array_sorted_sub_1 = new ArrayList<>();
    private List<Integer> array_sorted_sub_2 = new ArrayList<>();
    private int maxSize;

    private double totaltime;
    private int multiplier = 7;

    private Thread t1;
    private Thread t2;

    private void run(){
        this.maxSize = 10000;


            array_unsorted_main = new ArrayList<>();

            for (int j = 0; j < maxSize; j++) { //random nummertjes machen
                array_unsorted_main.add(random.nextInt(10000));
            }

            array_unsorted_sub_1 =  array_unsorted_main.subList(0,array_unsorted_main.size()/2);
            array_unsorted_sub_2 =  array_unsorted_main.subList(array_unsorted_main.size()/2,array_unsorted_main.size());

            long tStart = System.currentTimeMillis();

            t1 = new Thread(() -> {
                array_sorted_sub_1 = bubbleSort(array_unsorted_sub_1);
            });
            t2 = new Thread(() -> {
                array_sorted_sub_2 = bubbleSort(array_unsorted_sub_2);
            });
            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            array_sorted_main = merge(array_sorted_sub_1,array_sorted_sub_2);



        System.out.println("Average : " + (Double.toString(totaltime/multiplier)));
    }

    public List<Integer> bubbleSort(List<Integer> invoer) {
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

    public List<Integer> merge(List<Integer> left, List<Integer> right){
        int i =0, j =0, k=0;
        while(i< left.size() && j < right.size()){
            if (left.get(i) < right.get(j)) {
                array_sorted_main.add(k, left.get(i));
                i++;
            }
            else {
                array_sorted_main.add(k,right.get(j));
                j++;
            }
            k++;
        }
        while(i < left.size()){
            array_sorted_main.add(k, left.get(i));
            i++;
            k++;
        }
        while(j < right.size()){
            array_sorted_main.add(k, right.get(j));
            j++;
            k++;
        }

        return array_sorted_main;
    }

    public static void main(String args[]){
        new API().run();
    }
}
