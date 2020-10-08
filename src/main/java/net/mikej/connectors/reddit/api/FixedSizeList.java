package net.mikej.connectors.reddit.api;

import java.util.ArrayList;

public class FixedSizeList<T> extends ArrayList<T> {
  private static final long serialVersionUID = -9163435898443354485L;
  private final int maxSize;
  
  public FixedSizeList(final int maxSize) {
    super();
    this.maxSize = maxSize;
  }

  @Override
  public boolean add(T thing) {
    while (super.size() > this.maxSize) {
      super.remove(0);
    }
    super.add(thing);
    return true;
  }
}