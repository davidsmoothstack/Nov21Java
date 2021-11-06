package three;

public class IntProducer extends Thread {
    private static volatile int count;
    private final IntBuffer buffer;
    public Integer id;

    public IntProducer(final IntBuffer buffer) {
        this.buffer = buffer;
        id = ++IntProducer.count;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this.buffer) {
                    if (this.buffer.isFull())
                        continue;

                    final var randomInt = Main.randomRange(1, 999);
                    this.buffer.push(randomInt);

                    System.out.println(
                            String.format("Producer %d produced %d", this.id, randomInt));
                }

                Thread.sleep(Main.randomRange(3_000, 5_000));
            }
        }
        catch (final Exception e) {
            System.out.println("Error in producer: " + e.getMessage());
        }
    }
}
