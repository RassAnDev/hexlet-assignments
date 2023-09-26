package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {

        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);

        maxThread.start();
        LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " started");

        minThread.start();
        LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " started");

        try {
            maxThread.join();
        } catch (InterruptedException e) {
           LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " interrupted");
        }

        try {
            minThread.join();
        } catch (InterruptedException e) {
            LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " interrupted");
        }

        LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " finished");
        LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " finished");

        return Map.of("min", minThread.getResult(), "max", maxThread.getResult());
    }
    // END
}
