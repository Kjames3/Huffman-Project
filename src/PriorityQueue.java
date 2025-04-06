public class PriorityQueue {
    private Node[] nodes;
    private int size;
    private final int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.nodes = new Node[capacity];
        size = 0;
    }

    public void add(Node node) {
        nodes[size] = node;
        moveUp(size);
        size++;
    }

    public Node poll() {
        if (size == 0) {
            return null; // or throw an exception
        }
        Node root = nodes[0];
        nodes[0] = nodes[size - 1];
        size--;
        moveDown(0);
        return root;
    }

    public int size() { return size;}

    private void moveUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (nodes[index].compareTo(nodes[parentIndex]) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void moveDown(int index) {
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestIndex = index;;
            if (leftChildIndex < size && nodes[leftChildIndex].compareTo(nodes[smallestIndex]) < 0) {
                smallestIndex = leftChildIndex;
            } 
            if (rightChildIndex < size && nodes[rightChildIndex].compareTo(nodes[index]) < 0) {
                smallestIndex = rightChildIndex;
            } if (smallestIndex == index) {
                break;
            }
            swap(index, smallestIndex);
            index = smallestIndex;
        }
    }

    private void swap(int i, int j) {
        Node temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
    }
}
