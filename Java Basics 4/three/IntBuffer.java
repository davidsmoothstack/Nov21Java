package three;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IntBuffer implements Collection<Integer> {
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

  @Override
  public int size() {
    return intCollection.size();
  }

  @Override
  public boolean isEmpty() {
    return intCollection.size() == 0;
  }

  @Override
  public boolean contains(Object o) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Iterator<Integer> iterator() {
    return intCollection.iterator();
  }

  @Override
  public Object[] toArray() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean add(Integer e) {
    return intCollection.add(e);
  }

  @Override
  public boolean remove(Object o) {
    return intCollection.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends Integer> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub

  }

}
