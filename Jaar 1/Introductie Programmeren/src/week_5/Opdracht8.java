package week_5;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

public class Opdracht8 {
    public static void main(String[] args) {
        new Opdracht8().run();
    }

    private void run() {
        // Eerste array aanmaken
        int[] listOne = new int[4];
        listOne[0] = 4;
        listOne[1] = 2;
        listOne[2] = 6;
        listOne[3] = 1;

        //Tweede array met lengte van de eerste
        int[] listOneReverse = new int[listOne.length];

        for (int i = 0; i < listOne.length; i++) {
            // listone.lengte-1-i zorgt ervoor dat hij telkens i van de lengte-1 er af haalt.
            listOneReverse[i] = listOne[listOne.length-1-i];
            System.out.println(listOneReverse[i]);
        }
    }
}
