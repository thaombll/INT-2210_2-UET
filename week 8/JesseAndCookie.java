
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class JesseAndCookie {
    public static class PriorityQueue<T extends Comparable<T>> {
        private final List<T> heap;

        public PriorityQueue() {
            this.heap = new ArrayList<>();
        }

        public void enqueue(T element) {
            heap.add(element);
            heapifyUp();
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("PriorityQueue is empty");
            }

            T root = heap.get(0);
            int lastIdx = heap.size() - 1;
            heap.set(0, heap.get(lastIdx));
            heap.remove(lastIdx);
            heapifyDown();

            return root;
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("PriorityQueue is empty");
            }
            return heap.get(0);
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        public int size() {
            return heap.size();
        }

        private void heapifyUp() {
            int index = heap.size() - 1;
            while (hasParent(index) && getParent(index).compareTo(heap.get(index)) > 0) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        private void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && getRightChild(index).compareTo(getLeftChild(index)) < 0) {
                    smallerChildIndex = getRightChildIndex(index);
                }

                if (heap.get(index).compareTo(heap.get(smallerChildIndex)) < 0) {
                    break;
                } else {
                    swap(index, smallerChildIndex);
                }

                index = smallerChildIndex;
            }
        }

        private boolean hasParent(int index) {
            return index > 0;
        }

        private int getParentIndex(int index) {
            return (index - 1) / 2;
        }

        private T getParent(int index) {
            return heap.get(getParentIndex(index));
        }

        private boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < heap.size();
        }

        private int getLeftChildIndex(int index) {
            return 2 * index + 1;
        }

        private T getLeftChild(int index) {
            return heap.get(getLeftChildIndex(index));
        }

        private boolean hasRightChild(int index) {
            return getRightChildIndex(index) < heap.size();
        }

        private int getRightChildIndex(int index) {
            return 2 * index + 2;
        }

        private T getRightChild(int index) {
            return heap.get(getRightChildIndex(index));
        }

        private void swap(int i, int j) {
            T temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            q.enqueue(a[i]);
        }

        int cnt = 0;
        while (q.size() > 1 && q.peek() < k) {
            int x = q.dequeue();
            int y = q.dequeue();
            q.enqueue(x + 2 * y);
            cnt++;
        }

        if (q.peek() >= k) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }

        sc.close();
    }
}
