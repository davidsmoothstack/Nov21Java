package two;

public class Main {
    public static void main(final String[] args) {
        Object lockObj1 = new Object();
        Object lockObj2 = new Object();

        // Thread 1
        final Thread t1 = new Thread(() -> {
            synchronized (lockObj1) {
                try {
                    System.out.println("T1 locked resource 1");
                    Thread.sleep(500);

                    synchronized (lockObj2) {
                        System.out.println("T1 locked resource 2");
                    }
                }
                catch (final Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            // Will never reach
            System.out.println("Done with thread 1");
        });

        // Thread 2
        final Thread t2 = new Thread(() -> {
            synchronized (lockObj2) {
                try {
                    System.out.println("T2 locked resource 2");
                    Thread.sleep(500);

                    synchronized (lockObj1) {
                        System.out.println("T2 locked resource 1");
                    }
                }
                catch (final Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            // Will never reach
            System.out.println("Done with thread 2");
        });

        t1.start();
        t2.start();
    }
}