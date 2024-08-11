package thread.executor.poolsize;

import thread.executor.ExecutorUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static thread.executor.ExecutorUtils.printState;
import static util.ThreadUtils.sleep;

public class PreStartPoolMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        printState(es);
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) es;
        poolExecutor.prestartAllCoreThreads();
        sleep(100);
        printState(es);

        es.close();
    }
}
