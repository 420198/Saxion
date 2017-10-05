package week_6.Opdracht10;

public class PyramidJava {
    public static void main(String[] args) {
        new PyramidJava().run();
    }

    private void run() {
        pyramid(23);
    }

    private void pyramid(int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n-i;j++) {
                System.out.print(" ");
            }
            for(int k=0;k<=i;k++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}
