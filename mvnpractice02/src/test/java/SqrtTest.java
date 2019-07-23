import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {
    @Test
    void test() {
        long x = 5;
        long tmpResult = 0;
        long startTime;
        long finishTime;

        long loopSize = 2_000_000_000;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < loopSize; i++) {
            tmpResult += (x * x);
        }
        finishTime = System.currentTimeMillis();
        System.out.println("x*x " + (finishTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < loopSize; i++) {
            tmpResult += Math.pow(x, 2);
        }
        finishTime = System.currentTimeMillis();
        System.out.println("Math.pow(x,2) " + (finishTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < loopSize; i++) {
            tmpResult += (x * x * x);
        }
        finishTime = System.currentTimeMillis();
        System.out.println("x*x*x " + (finishTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < loopSize; i++) {
            tmpResult += Math.pow(x, 3);
        }
        finishTime = System.currentTimeMillis();
        System.out.println("Math.pow(x,3) " + (finishTime - startTime));
        System.out.println(tmpResult);

        /*
        startTime = System.nanoTime();
        tmpResult = Math.pow(x,2);
        finishTime = System.nanoTime();
        System.out.println("Pow2 " + (finishTime-startTime));

        startTime = System.nanoTime();
        tmpResult = Math.pow(x,3);
        finishTime = System.nanoTime();
        System.out.println("Pow3 " + (finishTime-startTime));

        startTime = System.nanoTime();
        tmpResult = x*x*x;
        finishTime = System.nanoTime();
        System.out.println("x*x " + (finishTime-startTime));
        */
    }

    private static final long LOOP_SIZE = 2_000_000_000L;


    @Test
    void count() {
        System.out.println("Math time: " + mathStopwatch(0.0));
        System.out.println("xx time: " + xxStopwatch(0.0));
    }

    private long mathStopwatch(double sum) {
        //double sum = 0;
        double x = 2;
        final long startTime = System.currentTimeMillis();
        for (long i = 0; i < LOOP_SIZE; i++) {
            sum += Math.pow(x, 3.0);
        }
        final long endTime = System.currentTimeMillis();
        final long time = endTime - startTime;
        System.out.println(sum);
        return time;
    }

    private long xxStopwatch(double sum) {
        // double sum = 0;
        double x = 2;
        final long startTime = System.currentTimeMillis();
        for (long i = 0; i < LOOP_SIZE; i++) {
            sum += x * x * x;
        }
        final long endTime = System.currentTimeMillis();
        final long time = endTime - startTime;
        System.out.println(sum);
        return time;
    }
}



