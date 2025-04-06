public class InternalNode extends Node {
    private Node leftNode;
    private Node rightNode;

    public InternalNode(Node leftNode, Node rightNode) {
        super(leftNode.getFrequency() + rightNode.getFrequency());
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }
}
