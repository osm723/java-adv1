package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        Thread thread = new Thread(new ParkTest(), "Thread-1");
        thread.start();

        sleep(100);
        log("Thread-1 state = " + thread.getState());
        log("unpark()");
        LockSupport.unpark(thread);

        //log("interrupt()");
        //thread.interrupt();
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();

            log("park 종료, state = " + Thread.currentThread().getState());
            log("인터럽트 상태 = " + Thread.currentThread().isInterrupted());
        }
    }
}
