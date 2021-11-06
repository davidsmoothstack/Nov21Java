package three;

public class IntConsumer extends Thread {
    private static volatile int count;
    private final IntBuffer buffer;
    public Integer id;

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

                    final var value = this.buffer.pop().get();

                    System.out.println(
                            String.format("Consumer %d consumed %d", this.id, value));
                }

                Thread.sleep(Main.randomRange(3_000, 5_000));
            }
        }
        catch (final Exception e) {
            System.out.println("Error in consumer: " + e.getMessage());
        }
    }
}
