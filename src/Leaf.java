public class Leaf extends Node {
    private final char character;

    public Leaf(char character, int frequency) {
        // Call the constructor of the parent class (Node) with frequency
        super (frequency);
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
