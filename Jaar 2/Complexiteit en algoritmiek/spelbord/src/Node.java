import java.util.ArrayList;

/**
 * Created by sklar on 12/24/2016.
 */
public class Node {
    private byte position;
    private Color color;
    private ArrayList<Link> links;

    /**
     * Constructor for node
     *
     * @param position Positions
     * @param color Color
     */
    public Node(byte position, Color color) {
        this.position = position;
        this.color = color;
        this.links = new ArrayList<>();
    }

    /**
     * Gets all neighbours based on a color and adds that to a list of possible nodes it can go to
     *
     * @param color Color the linkcolor must match with.
     * @return Nodes to go to
     */
    public ArrayList<Node> getNeighbours(Color color) {
        ArrayList<Node> possibleNodes = new ArrayList<>();
        for (Link link : links) {
            if (link.getLinkColor() == color) {
                possibleNodes.add(link.getNodeTwo());
            }
        }
        return possibleNodes;
    }

    /**
     * Add a link to the list
     *
     * @param link is the link
     */
    public void addLink(Link link) {
        this.links.add(link);
    }

    /**
     * Getters
     */
    public Color getColor() {
        return color;
    }

    public byte getPosition() {
        return position;
    }

    /**
     * To string method for a node
     *
     * @return A node in string format
     */
    @Override
    public String toString() {
        return "Node{" +
                "position=" + position +
                ", color=" + color +
                '}';
    }
}
