package thread.cas.increment;

import java.util.ArrayList;

import static util.ThreadUtils.sleep;

public class IncrementPerformanceMain {

    public static final int COUNT = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger) {
        long startMS = System.currentTimeMillis();

        for (long i = 0; i < COUNT; i++) {
            incrementInteger.increment();
        }

        long endMS = System.currentTimeMillis();

        System.out.println(incrementInteger.getClass().getSimpleName() + " : " + (endMS-startMS) + "ms");
    }
}
