public class Node implements Comparable<Node> {
    private final int frequency;
    
    public Node(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override    // My IDE recommended adding this override. Im not sure why. 
    public int compareTo(Node other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}