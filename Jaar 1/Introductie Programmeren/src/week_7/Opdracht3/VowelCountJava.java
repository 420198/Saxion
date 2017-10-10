package week_7.Opdracht3;

import kotlin.ranges.IntRange;

import java.util.Scanner;

public class VowelCountJava {
    public static void main(String[] args) {
        new VowelCountJava().run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        String str;
        System.out.print("Input your sentence: ");
        str = s.nextLine();
        System.out.println("This sentence contains "+vowelCount(str)+" vowels.");
    }

    /**
     * Replace all the characters that do NOT equal (^ in the regex) a o i u y or e
     *
     * @param s string to check
     * @return vowel amount
     */
    private int vowelCount(String s){
        return s.toLowerCase().replaceAll("[^aoiuye]","").length();
    }
}
