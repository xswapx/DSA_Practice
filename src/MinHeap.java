import java.util.ArrayList;

public class MinHeap {
    private final ArrayList<Integer> minHeap = new ArrayList<>();

    private void swapFunc(int i, int j) {
        int swap = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, swap);
    }

    private int getLeftChild(int i) {
        return (i * 2) + 1;
    }

    private int getRightChild(int i) {
        return (i * 2) + 2;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private void heapify(int minInd) {
        int min = minInd;
        int left = getLeftChild(minInd);
        int right = getRightChild(minInd);
        if (left < minHeap.size() && minHeap.get(min) > minHeap.get(left)) {
            min = left;
        }
        if (right < minHeap.size() && minHeap.get(min) > minHeap.get(right)) {
            min = right;
        }
        if (min != minInd) {
            swapFunc(min, minInd);
            heapify(min);
        }
    }

    public void insertNumber(int n) {
        minHeap.add(n);
        if (minHeap.size() > 1) {
            int lastElIn = minHeap.size() - 1;
            int parent = getParent(lastElIn);
            while (minHeap.get(parent) > minHeap.get(lastElIn)) {
                swapFunc(parent, lastElIn);
                lastElIn = parent;
                parent = getParent(lastElIn);
            }
        }
    }

    public int removeMinEement() {
        int toRemove = minHeap.get(0);
        int lastInd = minHeap.get(minHeap.size() - 1);
        minHeap.set(0, lastInd);
        minHeap.remove(minHeap.size() - 1);
        heapify(0);
        return toRemove;
    }

    public void displayHeap() {
        for (int x : minHeap) {
            System.out.print(x + ", ");
        }
    }

}
