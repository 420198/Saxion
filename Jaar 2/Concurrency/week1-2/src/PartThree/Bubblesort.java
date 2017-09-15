package PartThree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 8-9-2016.
 */
public class Bubblesort implements Runnable {
    public List<Integer> arrayList;
    private int treshold;
    private int middle;

    public Bubblesort(List<Integer> arrayList, int treshold) {
        this.arrayList = arrayList;
        this.treshold = treshold;
        this.middle = arrayList.size() / 2;
        System.out.println(arrayList.size() + " ha");
    }

    @Override
    public void run() {
        if (arrayList.size() < treshold) {
            sort();
        }else if(treshold<arrayList.size()){
            Bubblesort rLeft = new Bubblesort(arrayList.subList(0, middle), treshold);
            Bubblesort rRight = new Bubblesort(arrayList.subList(middle, arrayList.size()), treshold);


            Thread tLeft = new Thread(rLeft);
            Thread tRight = new Thread((rRight));
            tRight.start();
            tLeft.start();
            try {
                tLeft.join();
                tRight.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            merge(rLeft.arrayList, rRight.arrayList);
            System.out.println(arrayList.size() + ":size");
        }
    }

    private void merge(List<Integer> left, List<Integer> right) {
        int i = 0, j = 0, k = 0;
        List<Integer> temp = new ArrayList<>();
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                temp.add(k, left.get(i));
                i++;
            } else {
                temp.add(k, right.get(j));
                j++;
            }
            k++;
        }
        while (i < left.size()) {
            temp.add(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()) {
            temp.add(k, right.get(j));
            j++;
            k++;
        }
        this.arrayList = temp;
    }

    public List<Integer> getArrayList() {
        return arrayList;
    }

    private void sort() {
        int i, j, tijdelijk;
        for (j = 0; j < arrayList.size(); j++) {
            for (i = 1; i < arrayList.size() - j; i++) {
                if (arrayList.get(i - 1) > arrayList.get(i)) {
                    tijdelijk = arrayList.get(i);
                    arrayList.set(i, arrayList.get(i - 1));
                    arrayList.set(i - 1, tijdelijk);
                }
            }
        }
    }
}
