package three;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IntBuffer implements Iterable<Integer> {
  private Collection<Integer> intCollection;
  public Integer maxSize;

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

  public boolean add(Integer e) {
    return intCollection.add(e);
  }

  public boolean remove(Object o) {
    return intCollection.remove(o);
  }

  @Override
  public Iterator<Integer> iterator() {
    return intCollection.iterator();
  }
}
