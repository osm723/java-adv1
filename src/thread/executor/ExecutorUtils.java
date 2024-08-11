package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

public class ExecutorUtils {

    public static void printState(ExecutorService service) {
        if (service instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queuedTask = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount();
            log("[pool=" + pool + " , active=" + active
                    + " , quequeuedTaskued=" + queuedTask
                    + " , completedTask=" + completedTask);
        } else {
            log(service);
        }
    }

    public static void printState(ExecutorService service, String taskName) {
        if (service instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queuedTask = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount();
            log(taskName + " -> [pool=" + pool + " , active=" + active
                    + " , quequeuedTaskued=" + queuedTask
                    + " , completedTask=" + completedTask);
        } else {
            log(service);
        }
    }
}
