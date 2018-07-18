package come.ericsson.multiplethreadprograming;

public class VolatileVisibilityTest {

    static class Flag {

        boolean flagWithoutVolatile = false;
        volatile boolean flagWithVolatile = false;
    }

    public static void main(String[] args) {

        Flag flag = new Flag();
        new Thread(new Runnable() {

            public void run() {
                while (!flag.flagWithoutVolatile) {
                    // read variable marked by volatile

                    // write variable marked by volatile

                    // System.out.println()?

                    // synchronized

                    // Thread.sleep()

                }
                System.out.println("finish");
            }
        }).start();

        flag.flagWithoutVolatile = true;
        System.out.println("end");

    }

}
