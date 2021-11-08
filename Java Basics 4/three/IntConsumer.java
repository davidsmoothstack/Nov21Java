package three;

public class IntConsumer extends Thread {
    private static volatile int count;
    public final Integer id;
    private final IntBuffer buffer;

    public IntConsumer(final IntBuffer buffer) {
        this.buffer = buffer;
        id = ++IntConsumer.count;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this.buffer) {
                    if (this.buffer.isEmpty())
                        continue;

                    final Integer value = this.buffer.pop().get();

                    System.out.printf("Consumer %d consumed %d\n", this.id, value);
                }

                Thread.sleep(Main.randomRange(3_000, 5_000));
            }
        }
        catch (final Exception e) {
            System.out.println("Error in consumer: " + e.getMessage());
        }
    }
}
