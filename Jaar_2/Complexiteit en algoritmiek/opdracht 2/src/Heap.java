/**
 * Created by sklar on 12/22/2016.
 */
public class Heap {
    protected int[] heap;
    protected int heapSize;
    protected int deadSpace;
    protected int maxHeapSize;

    /**
     * Heap constructor.
     * <p>
     * Sets the heap size,
     * the max heap size,
     * the deadspace
     * and creates a new heap array with size heapsize
     *
     * @param heapSize heap size
     */
    public Heap(int heapSize) {
        this.heapSize = heapSize;
        this.maxHeapSize = heapSize;
        this.deadSpace = 0;
        heap = new int[heapSize];
    }

    /**
     * This method is used to build a new heap by continuesly using perculate down.
     */
    protected void buildHeap() {
        for (int i = heapSize / 2; i >= 0; i--) {
            perculateDown(i);
        }
    }

    /**
     * Public insert method. Inserts a new number into the heap at the last position and perculates it up to the correct
     * position
     *
     * @param num is the number you want to insert into the heap.
     */
    public void insert(int num) {
        perculateUp(num, heapSize - 1);
    }

    /**
     * Removes the smallest number by setting one of the highest numbers in the tree to index 0
     * <p>
     * Perculates this number down so the tree becomes normal and correct again.</p>
     */
    public void removeSmallest() {
        heap[0] = heap[heapSize - 1];
        perculateDown(0);
    }

    /**
     * Perculates a number into the correct position by using the perculate up method.
     * <p>
     * As long as the position is not currently at 0, it will run inside the while loop
     * Inside it will get the parent position and the parent.
     * The parent is then checked against the number you are perculating up.
     * Only if the number is smaller it will be swapped with its parent. Then the new position shall be set,
     * Otherwise it will break from the loop because there is no need to continue.</p>
     *
     * @param num is the number you are perculating
     * @param pos is the position you are starting from.
     */
    private void perculateUp(int num, int pos) {
        heap[pos] = num;
        while (pos > 0) {
            int parentPosition = getParent(pos);

            int parent = heap[parentPosition];
            if (num < parent) {
                heap[parentPosition] = num;
                heap[pos] = parent;
                pos = parentPosition;
            } else {
                break;
            }
        }
    }

    /**
     * Perculates a number into the correct position by using the perculate down method.
     * <p>
     * First gets the left child if it has any, else the while loop is over
     * Next it checks if there is a right child and if it is smaller than the left child
     * if it is the rightchild will be the new smallest child.
     * Next it checks wether or not the current position is smaller than the smallest child.
     * If it isnt the two will swap and the new position will be set.
     * if it is than there is no need to continue the while loop so we will break.</p>
     *
     * @param i is the current position that you want to set right.
     */
    private void perculateDown(int i) {
        int pos = i;
        while (getLeftChild(pos) < heapSize) {
            int smallestChildPos = getLeftChild(pos);

            if (getLeftChild(pos) + 1 < heapSize && heap[getLeftChild(pos) + 1] < heap[getLeftChild(pos)]) {
                smallestChildPos = getLeftChild(pos) + 1;
            }

            if (heap[pos] > heap[smallestChildPos]) {
                swap(pos, smallestChildPos);
                pos = smallestChildPos;
            } else {
                break;
            }
        }
    }

    /**
     * Swap method, swaps a parent with a child, used in perculatedown
     *
     * @param parent Parent
     * @param child  Child
     */
    private void swap(int parent, int child) {
        int temp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = temp;
    }

    /**
     * Gets the parent of a child
     *
     * @param child is the child
     * @return parent of the child.
     */
    private int getParent(int child) {
        return (child - 1) / 2;
    }

    /**
     * Gets the left child
     *
     * @param mypos is the current position which you want the child from
     * @return left child
     */
    private int getLeftChild(int mypos) {
        return ((mypos + 1) * 2) - 1;
    }
}