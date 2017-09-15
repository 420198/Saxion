import java.util.Scanner;

/**
 * Created by sklar on 12/15/2016.
 */
public class RsHeap extends Heap {
    private String inF;
    private SimulatedFile outF;
    private int index = 0, amount = 0, splits = 1;

    public RsHeap(SimulatedFile inF, SimulatedFile outF, int heapSize) {
        super(heapSize);
        this.inF = inF.getFile();
        this.outF = outF;
    }

    /**
     * Run the replacement selection
     * <p>
     * First the scanner is created to loop through the simulated input file.
     * Next we start looping through the file, highering up the number each time.
     * Then we chceck if the heap has been filled yet.</p>
     * <p>
     * if it isnt we will insert a new number into it and increase the index.
     * If it is, we run the replacementselection part.</p>
     * <p>
     * Once the while loop is over we write away the last part of the heap.
     * Once that is done we write away the last deadspace.</p>
     * <p>
     * And at the very end we print everything out.</p>
     */
    public void run() {
        //Create heap
        Scanner scanner = new Scanner(inF);
        scanner.useDelimiter(",");

        outF.writeFile("Run " + splits + ": ");
        while (scanner.hasNext()) {
            amount++;
            if (index < heap.length) {
                insert(scanner.nextInt());
                index++;
            } else {
                replacementselection(scanner.nextInt(), heap[0]);
            }
        }
        writeLeftOver();
        writeOffLastDeadSpaceNums();

        // System.out.println(outF.getFile());
        System.out.println("Written of " + amount + " numbers in " + splits + " runs with heap size: " + maxHeapSize + "!\n");
    }


    /**
     * Write away left over numbers to the simulated file
     * <p>
     * First we write of what run it is (splits)
     * Next we loop through the heap and write off each number.
     * Then we remove this number from the heap.
     * Lastly we lower the heapsize.</p>
     */
    private void writeLeftOver() {
        splits++;
        outF.writeFile("\nRun " + splits + ": ");
        while (heapSize != 0) {
            outF.writeFile(heap[0] + ", ");
            removeSmallest();
            heapSize--;
        }
    }

    /**
     * Create the last heap with the left over deadspace
     * <p>
     * First we check that there even is a deadspace
     * Next we set the heapsize to the deadspace size and loop through it to set the numbers correctly in the heap
     * Once that is done we build the heap and write it off.</p>
     */
    private void writeOffLastDeadSpaceNums() {
        if (deadSpace != 0) {
            heapSize = deadSpace;
            for (int i = 0; i < deadSpace; i++) {
                heap[i] = heap[maxHeapSize - deadSpace + i];
            }
            buildHeap();
            writeLeftOver();
        }
    }

    /**
     * Replacement selection method.
     * <p>
     * First the heap is build, then the lowest number is written away to a simulated file.
     * This number is removed from the heap.
     * Next, the next number is checked against the smallest number.</p>
     * <p>
     * If it is higher, it will be added to the heap
     * If it is of equal value, it shall be written off immediatly
     * if it is lower, it will be added to the deadspace.</p>
     * <p>
     * When the heapsize is 0, a new run shall be started with the numbers in the deadspace.</p>
     *
     * @param nextNr   is the next number to be read in
     * @param smallest is the smallest number in the heap
     */
    public void replacementselection(int nextNr, int smallest) {
        buildHeap();
        outF.writeFile(heap[0] + ", ");
        removeSmallest();

        if (nextNr > smallest) {
            insert(nextNr);
        } else if (nextNr == smallest) {
            outF.writeFile(nextNr + ", ");
        } else {
            heapSize--;
            deadSpace++;
            heap[heapSize] = nextNr;
        }

        if (heapSize == 0) {
            splits++;
            outF.writeFile("\nRun " + splits + ": ");
            deadSpace = 0;
            heapSize = maxHeapSize;
            buildHeap();
            index = heap.length;
        }
    }

}