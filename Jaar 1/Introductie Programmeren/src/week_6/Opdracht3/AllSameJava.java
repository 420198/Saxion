package week_6.Opdracht3;

public class AllSameJava     {
    public static void main(String[] args) {
        new AllSameJava().run();
    }

    private void run() {
        System.out.println(allSame(1,1,1));
        System.out.println(allSame(1,1,2));
    }

    private boolean allSame(int a, int b, int c) {
        return a == b && a == c;
    }
}
