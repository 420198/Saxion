package week_6.Opdracht1;

public class HouseInJava {
    public static void main(String[] args) {
        new HouseInJava().run();
    }

    private void run() {
        drawHouse();
    }
    private void drawHouse(){
        System.out.println("   +  \r\n" +
                           "  + + \n" +
                           " +   + \n" +
                           "+-----+\n" +
                           "|  _  |\n" +
                           "| | | |\n" +
                           "| | | |\n" +
                           "|_+_+_|");
    }
}
