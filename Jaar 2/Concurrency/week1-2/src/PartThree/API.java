package PartThree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class API {
    private Random random = new Random();
    private List<Integer> array_unsorted_main = new ArrayList<>();
    private int maxSize;

    private Thread t1;

    private void run(){
        this.maxSize = 800000;

        for (int i = 0; i < maxSize; i++) {
            array_unsorted_main.add(random.nextInt(10000));
        }
        Bubblesort bs = new Bubblesort(array_unsorted_main,1000);
        t1 = new Thread(bs);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]){
        new PartThree.API().run();
    }

}
