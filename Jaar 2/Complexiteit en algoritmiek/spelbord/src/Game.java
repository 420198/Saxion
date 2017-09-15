import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by sklar on 1/20/2017.
 */
public class Game {
    private State startState;
    private Board board;

    private int stepCount;

    private ArrayList<State> results;
    private ArrayList<State> searched;
    private ArrayList<State> impossibleStates;
    private ArrayList<ArrayList<State>> finished;

    public Game(byte posOne, byte posTwo, byte endPos, BoardLoader boardLoader) {
        stepCount = 0;
        searched = new ArrayList<>();
        impossibleStates = new ArrayList<>();
        finished = new ArrayList<>();
        startState = new State(boardLoader.getTempNodes().get(posOne), boardLoader.getTempNodes().get(posTwo));
        board = new Board(boardLoader.getTempNodes().get(endPos));
    }

    /**
     * Dit is de methode waar in het spel gestart wordt. Hier wordt 1 keer backtracken aangeroepen
     */
    public void play() {
        results = backTrack(startState, searched, finished);
        System.out.println("No more solutions have been found");
    }

    /**
     * De backTrack methode is het hart van het hele spel. Deze methode roept zichzelf telkens weer opnieuw aan en geeft
     * aan het eind een aantal oplossingen terug. De oplossingen die gevonden worden variëren op basis van welke keuze
     * er op het begin is gemaakt (welke pion op welke plek).
     * <p>
     * Als eerst wordt er een nieuwe lijst aangemaakt (currentSolution). Hierna hoogt hij de stappen teller op en print
     * hij uit in welke toestand nu gekeken wordt. Vervolgens kijken wij of de huidige toestand een eindtoestand is, zo
     * ja dan wordt de huidige toestand aan de currentSolution toegevoegd en dan wordt de lijst teruggegeven. Vervolgens
     * wordt deze lijst steeds verder teruggeven. Tot hij uiteindelijk bij de eerste aanroeping het resultaat toevoegt
     * aan een lijstje met gefinishte lijsten en uit print op welke stap er een oplossing gevonden is.
     * <p>
     * Als hij nog niet in de eindtoestand is dan worden eerst de buren opgehaald van pion 1 door de getPossibleStates
     * methode in de board class. Hierna wordt door de toestanden gelopen. Als deze toestand nog niet bezocht is en niet
     * in de impossibleStates zit, dan wordt hij bezocht door middel van opnieuw de backTrack methode aan te roepen. Dit
     * gaat om en om met pion 1 en twee tot hij uiteindelijk een oplossing vindt. Als hij bij één geen oplossing vindt
     * gaat hij net zo ver terug en probeert hij een andere route.
     *
     * @param currentState De huidge toestand
     * @param searched     de bezochte toestanden
     * @param finished     de gefinishde zoektochten
     * @return een lijst
     */
    private ArrayList<State> backTrack(State currentState, ArrayList<State> searched, ArrayList<ArrayList<State>> finished) {
        ArrayList<State> currentSolution = new ArrayList<>();
        stepCount++;
        System.out.println("Step: " + Integer.toString(stepCount) + ": " + currentState);
        if (board.finishedState(currentState)) {
            currentSolution.add(0, currentState);
            return currentSolution;
        } else {
            LinkedList<State> neighBoursNodeOne = board.getPossibleStates(currentState.getPionOne(),
                    currentState.getPionTwo(),
                    true);
            for (State state : neighBoursNodeOne) {
                if (!searched.contains(state) && !impossibleStates.contains(state)) {
                    searched.add(state);
                    currentSolution = backTrack(state, searched, finished);
                    if (goalReached(currentSolution)) {
                        currentSolution.add(0, currentState);
                        finished.add(currentSolution);
                        System.out.println("\r\nResult: " + finished.size() + " found at step: " + stepCount + "\r\n");
                        stepCount = 0;
                    }
                }
            }
            LinkedList<State> neighBoursNodeTwo = board.getPossibleStates(currentState.getPionTwo(),
                    currentState.getPionOne(),
                    false);
            for (State state : neighBoursNodeTwo) {
                if (!searched.contains(state) && !impossibleStates.contains(state)) {
                    searched.add(state);
                    currentSolution = backTrack(state, searched, finished);
                    if (goalReached(currentSolution)) {
                        currentSolution.add(0, currentState);
                        finished.add(currentSolution);
                        System.out.println("\r\nResult: " + finished.size() + " found at step: " + stepCount + "\r\n");
                        stepCount = 0;
                    }
                }
            }
        }
        impossibleStates.add(currentState);
        searched.remove(currentState);
        return new ArrayList<>();
    }

    /**
     * Deze methode wordt aangeroepen in de backtrack methode, hier wordt een lijstje aan meegegeven.
     * Als in dit lijstje een eindtoestand zit, dan wordt true gereturned.
     * Als hij er niet in zit wordt er false gereturned.
     *
     * @param solution is de lijst die meegegeven word
     * @return true of false wanneer het wel of niet een eindtoestand is
     */
    private boolean goalReached(ArrayList<State> solution) {
        for (State state : solution) {
            if (board.finishedState(state)) {
                return true;
            }
        }
        return false;
    }
}