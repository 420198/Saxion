import java.util.LinkedList;
import java.util.List;

/**
 * Created by sklar on 1/11/2017.
 */
public class Board {
    private Node endPosition;

    /**
     * Constructor
     *
     * @param endPosition is the end position of your board
     */
    public Board(Node endPosition) {
        this.endPosition = endPosition;
    }

    /**
     * Gets all the possible states one node can go to.
     * Uses the getNeighbours method of a node to get possibly neighbours of a node based on a color.
     * The pion1 boolean is needed so the nodes dont switch around in the state itself.
     *
     * @param nodeOne Is the node it gets neighbours from, for new possible states based on the linkcolors it has with links.
     *                This linkcolor needs to match with the color nodetwo is on
     * @param nodeTwo Is the node it uses the color from for getting neighbours for node 1
     * @param pion1   Is the pion nodeone set to pion 1 or not. Needed so it doesnt actually switch the nodes around in the state
     * @return A list of possible states based on all the above.
     */
    public LinkedList<State> getPossibleStates(Node nodeOne, Node nodeTwo, boolean pion1) {
        LinkedList<State> possibleState = new LinkedList<>();
        List<Node> possibleNodes = nodeOne.getNeighbours(nodeTwo.getColor());
        for (Node node : possibleNodes) {
            if (node.getPosition() != nodeTwo.getPosition()) {
                if (pion1) {
                    State state = new State(node, nodeTwo);
                    possibleState.add(state);
                } else {
                    State state = new State(nodeTwo, node);
                    possibleState.add(state);
                }
            }
        }
        return possibleState;
    }

    /**
     * Check if this state is the finished state
     *
     * @param state is the given state
     * @return true if one has finished
     * return false if none has finished
     */
    public boolean finishedState(State state) {
        if (state.getPionOne().getPosition() == endPosition.getPosition() ||
                state.getPionTwo().getPosition() == endPosition.getPosition()) {
            return true;
        }
        return false;
    }
}