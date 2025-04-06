public class main {
    public static void main(String[] args) {
        String input = "Testing Testing 123";
        Huffman huffman = new Huffman(input);

        // Generate Huffman codes
        huffman.buildHuffmanTree();
        huffman.generateHuffmanCodes();
        huffman.displayCodesTable();

        // Encode the input text
        String encodedText = huffman.encode();
        System.out.println("\nEncoded text: " + encodedText);

        // Decode the encoded text
        String decodedText = huffman.decode(encodedText);
        System.out.println("\nDecoded text: " + decodedText);
    }
}
