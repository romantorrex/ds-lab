package romano.ds;

import java.util.Arrays;

/**
 * Implementation of a Max-Heap using an array.
 */
public class MaxHeap {

    private int[] heap;
    private int lastIndex;

    /**
     * Creates a heap with maximum capacity equal to 100.
     */
    public MaxHeap() {
        heap = new int[100];
    }

    public void insert(int value) {
        heap[lastIndex] = value;

        int current = lastIndex;
        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(parent(current), current);
            current = parent(current);
        }

        lastIndex++;
    }

    private void swap(int parent, int current) {
        int temp = heap[parent];
        heap[parent] = heap[current];
        heap[current] = temp;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(heap, 0, lastIndex));
    }

    private int leftChid(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }
}
