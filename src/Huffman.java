
public class Huffman {
    private Node root;
    private final String text;
    private int[] charFrequencies;
    private String[] huffmanCodes;

    public Huffman(String text) {
        this.text = text;
        this.charFrequencies = new int[128]; // ASCII characters
        this.huffmanCodes = new String[128];
        fillCharFrequenciesArray();
    }

    private void fillCharFrequenciesArray() {
        for (char character : text.toCharArray()) {
           charFrequencies[character]++;
        }
    }

    public void buildHuffmanTree() {
        PriorityQueue pq = new PriorityQueue(text.length());
        // Add all characters and their frequencies to the priority queue
        for (char c = 0; c < charFrequencies.length; c++) {
            if (charFrequencies[c] > 0) {
                pq.add(new Leaf(c, charFrequencies[c]));
            }
        }

        // Build the Huffman tree
        while (pq.size() > 1) {
            Node left = (Node) pq.poll();
            Node right = (Node) pq.poll();
            InternalNode parent = new InternalNode(left, right);
            pq.add(parent);
        }
        root = (Node) pq.poll();
    }

    public void generateHuffmanCodes() {
        generateHuffmanCodesHelper(root, "");
    }

    private void generateHuffmanCodesHelper(Node node, String code) {
        if (node instanceof Leaf) {
            Leaf leaf = (Leaf) node;
            huffmanCodes[leaf.getCharacter()] = code.length() > 0 ? code : "0"; // Assign "0" for the root node
            return;
        } 
        InternalNode internalNode = (InternalNode) node;
        if (internalNode.getLeftNode() != null) {
            generateHuffmanCodesHelper(internalNode.getLeftNode(), code + "0");
        }
        if (internalNode.getRightNode() != null) {
            generateHuffmanCodesHelper(internalNode.getRightNode(), code + "1");
        }
    }

    public String encode() {
        StringBuilder encodedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            encodedText.append(huffmanCodes[character]);
        }
        return encodedText.toString();
    }

    public String decode(String encodedText) {
        StringBuilder decodedText = new StringBuilder();
        Node currentNode = root;
        for (char bit : encodedText.toCharArray()) {
            if (bit == '0') {
                currentNode = ((InternalNode) currentNode).getLeftNode();
            } else {
                currentNode = ((InternalNode) currentNode).getRightNode();
            }
            if (currentNode instanceof Leaf) {
                decodedText.append(((Leaf) currentNode).getCharacter());
                currentNode = root; // Reset to the root for the next character
            }
        }
        return decodedText.toString();
    }

    public void displayCodesTable() {
        System.out.println("Huffman Code Table:");
        for (char c = 0; c < huffmanCodes.length; c++) {
            if (huffmanCodes[c] != null) {
                System.out.println("'" + c + " : " + huffmanCodes[c]);
            }
        }
    }
}
