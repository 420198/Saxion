package week_6.Opdracht5;

public class ReverseStringJava {
    public static void main(String[] args) {
        new ReverseStringJava().run();
    }

    private void run() {
        String str = "Hello World";
        System.out.println(str);
        System.out.println(reverse(str));
        System.out.println(reverseAnother(str));
    }

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private String reverseAnother(String str){
        int length = str.length();
        StringBuilder des = new StringBuilder(length);

        for (int i = length-1; i >=0 ; i--) {
            des.append(str.charAt(i));
        }
        return des.toString();
    }
}
