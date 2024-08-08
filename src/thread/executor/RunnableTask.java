package thread.executor;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class RunnableTask implements Runnable {

    private final String name;

    private int sleepMS = 1000;

    public RunnableTask(String name) {
        this.name = name;
    }

    public RunnableTask(String name, int sleepMS) {
        this.name = name;
        this.sleepMS = sleepMS;
    }

    @Override
    public void run() {
        log(name + " 시작");
        sleep(sleepMS);
        log(name + " 완료");
    }
}
