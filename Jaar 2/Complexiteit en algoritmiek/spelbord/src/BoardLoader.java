import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sklar on 12/27/2016.
 */
public class BoardLoader {
    private Scanner scanner;
    private HashMap<Byte, Node> tempNodes;
    private String[] lineRead;

    /**
     * Board loader constructor
     *
     * @param file de file
     * @throws FileNotFoundException
     */
    public BoardLoader(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
        tempNodes = new HashMap<>();
    }

    /**
     * Function for loading board, reads node by $node and links by %link
     */
    public void loadBoard() {
        while (scanner.hasNext()) {
            lineRead = scanner.nextLine().split(";");
            if (lineRead[0].equals("$node")) {
                createNode(lineRead);
            } else if (lineRead[0].equals("%link")) {
                createLink(lineRead);
            }
        }
    }

    /**
     * Creates a node by reading a line
     *
     * @param line String array
     */
    private void createNode(String[] line) {
        Node node = new Node(Byte.parseByte(line[1]), stringToColor(line[2]));
        tempNodes.put(node.getPosition(), node);
    }

    /**
     * Creates links by getting a line, adds it to the node needed.
     * For every second I it creates a new link, starting from 2
     *
     * @param line is the line that was read in
     */
    private void createLink(String[] line) {
        for (byte i = 2; i < line.length; i += 2) {
            Node nodeTwo = tempNodes.get(Byte.parseByte(line[i]));
            Link link = new Link(nodeTwo, stringToColor(line[i + 1]));
            tempNodes.get(Byte.parseByte(line[1])).addLink(link);
        }
    }

    /**
     * This method creats a COLOR enum value from a string
     *
     * @param color is the string to be read in
     * @return is the color returned
     */
    public Color stringToColor(String color) {
        switch (color) {
            case "PURPLE":
                return Color.PURPLE;
            case "GREEN":
                return Color.GREEN;
            case "BLUE":
                return Color.BLUE;
            case "ORANGE":
                return Color.ORANGE;
            case "BLACK":
                return Color.BLACK;
            default:
                return Color.DEFAULT;
        }
    }

    /**
     * Returns all the nodes created.
     *
     * @return list of nodes
     */
    public HashMap<Byte, Node> getTempNodes() {
        return tempNodes;
    }
}
