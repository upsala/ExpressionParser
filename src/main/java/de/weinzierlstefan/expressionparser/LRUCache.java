package de.weinzierlstefan.expressionparser;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple LRU-Cache for internal uses
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
  private int cacheSize;

  public LRUCache() {
    super(16, 0.75f, true);
    this.cacheSize = 10;
  }

  public LRUCache(int cacheSize) {
    super(16, 0.75f, true);
    this.cacheSize = cacheSize;
  }

  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() >= cacheSize;
  }

  public void setCacheSize(int cacheSize) {
    this.cacheSize=cacheSize;
  }
}
