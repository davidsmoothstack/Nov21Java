package three;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

public class IntBuffer implements Iterable<Integer> {
    public Integer maxSize;
    private Collection<Integer> intCollection;

    public IntBuffer(Integer maxSize) {
        super();
        this.intCollection = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public Boolean isFull() {
        return intCollection.size() == maxSize;
    }

    public int size() {
        return intCollection.size();
    }

    public boolean isEmpty() {
        return intCollection.size() == 0;
    }

    public boolean push(Integer e) {
        return intCollection.add(e);
    }

    public Optional<Integer> pop() {
        if (isEmpty())
            return Optional.empty();

        var removed = iterator().next();
        intCollection.remove(removed);

        return Optional.of(removed);
    }

    @Override
    public Iterator<Integer> iterator() {
        return intCollection.iterator();
    }
}
