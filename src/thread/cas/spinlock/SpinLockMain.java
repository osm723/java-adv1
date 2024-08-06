package thread.cas.spinlock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockMain {

    public static void main(String[] args) {
        //spinLockBad spinLock = new spinLockBad();
        spinLock spinLock = new spinLock();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                spinLock.lock();

                try {
                    log("비지니스 로직 실행");
                    sleep(1);
                } finally {
                    spinLock.unlock();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }
}
