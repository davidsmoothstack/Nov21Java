package three;

public class IntConsumer extends Thread {
    private static volatile int count;
    public Integer id;
    private IntBuffer buffer;

    public IntConsumer(IntBuffer buffer) {
        super();
        this.buffer = buffer;
        this.id = ++ count;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (buffer) {
                    if (buffer.isEmpty())
                        continue;

                    var value = buffer.pop().get();

                    System.out.println(
                            String.format("Consumer %d consumed %d", id, value));
                }

                Thread.sleep(Main.randomRange(3_000, 5_000));
            }
        }
        catch (Exception e) {
            System.out.println("Error in consumer: " + e.getMessage());
        }
    }
}
