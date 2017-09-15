/**
 * Created by sklar on 12/27/2016.
 */
public class Link {
    private Node nodeTwo;
    private Color linkColor;

    /**
     * Create a link with another node.
     * No need for a node one because the list is saved from within the node.
     * Therefore you only need the node it links to
     *
     * @param nodeTwo Node linknked to
     * @param linkColor Color of the link
     */
    public Link(Node nodeTwo, Color linkColor) {
        this.nodeTwo = nodeTwo;
        this.linkColor = linkColor;
    }

    /**
     * Getters
     */
    public Node getNodeTwo() {
        return nodeTwo;
    }

    public Color getLinkColor() {
        return linkColor;
    }

    /**
     * Sets the link to a string
     * @return A link in string format
     */
    @Override
    public String toString() {
        return "Link{" +
                " nodeTwo=" + nodeTwo +
                ", linkColor=" + linkColor +
                '}';
    }
}
