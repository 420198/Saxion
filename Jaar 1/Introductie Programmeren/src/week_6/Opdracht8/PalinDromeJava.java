package week_6.Opdracht8;

public class PalinDromeJava {
    public static void main(String[] args) {
        new PalinDromeJava().run();
    }

    private void run() {
        System.out.println(isPalingDrone("pap"));
        System.out.println(isPalingDroneIgnoresCase("Pap"));
    }

    /**
     * Is it a palindrome? With case sensitivity
     * @param str to be checked
     * @return true/false
     */
    private boolean isPalingDrone(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }


    /**
     * Is it a palindrome? No case sensitivity
     * @param str to be checked
     * @return true/false
     */
    private boolean isPalingDroneIgnoresCase(String str) {
        return new StringBuilder(str).reverse().toString().equalsIgnoreCase(str);
    }
}
