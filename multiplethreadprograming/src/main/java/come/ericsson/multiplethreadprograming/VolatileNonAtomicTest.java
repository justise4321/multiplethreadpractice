package come.ericsson.multiplethreadprograming;

public class VolatileNonAtomicTest {

    private static volatile int count = 0;

    public static void increase() {
        count++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {

                public void run() {
                    for (int i = 0; i < 1000; i++)
                        increase();
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(count);
    }

}
