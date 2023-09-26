package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {

    private int[] numbers;
    private int result;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getResult() {
        return result;
    }

    public void run() {
        result = Arrays.stream(numbers).min().getAsInt();
//        for (int i = 0; i < numbers.length - 1; i++) {
//            if(numbers[i] < numbers[i + 1]) {
//                result = numbers[i];
//            }
//        }
    }
}
// END
