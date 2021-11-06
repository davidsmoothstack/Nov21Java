package three;

public class IntProducer extends Thread {
    private static volatile int count;
    public Integer id;
    private IntBuffer buffer;

    public IntProducer(IntBuffer buffer) {
        super();
        this.buffer = buffer;
        this.id = ++ count;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (buffer) {
                    if (buffer.isFull())
                        continue;

                    var randomInt = Main.randomRange(1, 999);
                    buffer.push(randomInt);

                    System.out.println(
                            String.format("Producer %d produced %d", id, randomInt));
                }

                Thread.sleep(Main.randomRange(3_000, 5_000));
            }
        }
        catch (Exception e) {
            System.out.println("Error in producer: " + e.getMessage());
        }
    }
}
