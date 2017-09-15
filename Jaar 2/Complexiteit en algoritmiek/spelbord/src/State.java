/**
 * Created by sklar on 1/12/2017.
 */
public class State {
    private Node pionOne;
    private Node pionTwo;

    /**
     * Constructor for a state
     * @param pionOne pionOne
     * @param pionTwo pionTwo
     */
    public State(Node pionOne, Node pionTwo) {
        this.pionOne = pionOne;
        this.pionTwo = pionTwo;
    }

    /**
     * Checks if a different state has the same values as this state
     * @param obj is the checked object
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        return ((State)obj).getPionOne().getPosition() == pionOne.getPosition()
                && ((State)obj).getPionTwo().getPosition() == pionTwo.getPosition();
    }

    public Node getPionOne() {
        return pionOne;
    }

    public Node getPionTwo() {
        return pionTwo;
    }

    @Override
    public String toString() {
        return "State{" +
                "pionOne=" + pionOne +
                ", pionTwo=" + pionTwo +
                '}';
    }
}
