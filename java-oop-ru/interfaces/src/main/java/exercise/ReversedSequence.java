package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String dataString;
    public ReversedSequence() {

    }

    public ReversedSequence(String string) {
        this.dataString = string;
    }

    public int length() {
        return this.dataString.length();
    }

    public char charAt(int index) {
        return this.dataString.charAt(index);
    }

    public CharSequence subSequence(int firstIndex, int secondIndex) {
        return this.dataString.subSequence(firstIndex, secondIndex);
    }

    public String toString() {
        String currentString = this.dataString;
        String resultString = "";

        for (int i = 0; i < currentString.length(); i++) {
            resultString = charAt(i) + resultString;
        }
        return resultString;
    }
}
// END
