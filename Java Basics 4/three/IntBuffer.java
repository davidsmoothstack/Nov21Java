package three;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

public class IntBuffer implements Iterable<Integer> {
    private final Collection<Integer> intCollection;
    public Integer maxSize;

    public IntBuffer(final Integer maxSize) {
        intCollection = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public Boolean isFull() {
        return this.intCollection.size() == this.maxSize;
    }

    public int size() {
        return this.intCollection.size();
    }

    public boolean isEmpty() {
        return this.intCollection.size() == 0;
    }

    public boolean push(final Integer e) {
        return this.intCollection.add(e);
    }

    public Optional<Integer> pop() {
        if (this.isEmpty())
            return Optional.empty();

        final var removed = this.iterator().next();
        this.intCollection.remove(removed);

        return Optional.of(removed);
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.intCollection.iterator();
    }
}
