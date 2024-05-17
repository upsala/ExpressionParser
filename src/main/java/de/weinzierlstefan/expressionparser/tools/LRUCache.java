package de.weinzierlstefan.expressionparser.tools;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * A simple threadsafe LRU-Cache for internal uses
 *
 * @param <K> the type of keys maintained by this cache
 * @param <V> the type of values mapped by this cache
 */
public class LRUCache<K, V> {
  private final ReadWriteLock lock = new ReentrantReadWriteLock();
  private int cacheSize;
  private final Map<K, V> cache = new LinkedHashMap<>(16, 0.75f, true) {

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
      return size() >= cacheSize;
    }
  };

  /**
   * Constructs a new cache with a default size of 10
   */
  public LRUCache() {
    this.cacheSize = 10;
  }

  /**
   * Constructs a new cache with a default size of {@literal cacheSize}
   */
  public LRUCache(int cacheSize) {
    this.cacheSize = cacheSize;
  }

  /**
   * Sets the size of the cache
   *
   * @param cacheSize
   */
  public void setCacheSize(int cacheSize) {
    lock.writeLock().lock();
    try {
      this.cacheSize = cacheSize;
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   * returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
   * @param key the key whose associated value is to be returned
   * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
   */
  public V get(K key) {
    lock.readLock().lock();
    try {
      return cache.get(key);
    } finally {
      lock.readLock().unlock();
    }
  }

  /**
   * returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
   * @param key the key whose associated value is to be returned
   * @param defaultValue the default mapping of the key
   * @return the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key
   */
  public V getOrDefault(K key, V defaultValue) {
    lock.readLock().lock();
    try {
      return cache.getOrDefault(key, defaultValue);
    } finally {
      lock.readLock().unlock();
    }
  }

  /**
   * Returns the number of key-value mappings in this cache
   * @return the number of key-value mappings in this cache
   */
  public int size() {
    lock.readLock().lock();
    try {
      return cache.size();
    } finally {
      lock.readLock().unlock();
    }
  }

  /**
   * Returns true if this cache contains no key-value mappings.
   * @return true if this cache contains no key-value mappings
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns true if this cache contains a mapping for the specified key. More formally, returns true if and only if this cache contains a mapping for a key k such that Objects.equals(key, k). (There can be at most one such mapping.)
   * @param key whose presence in this map is to be tested
   * @return true if this map contains a mapping for the specified key
   */
  public boolean containsKey(K key) {
    lock.readLock().lock();
    try {
      return cache.containsKey(key);
    } finally {
      lock.readLock().unlock();
    }
  }

  /**
   *
   * @param key
   * @param value
   * @return
   */
  public V put(K key, V value) {
    lock.writeLock().lock();
    try {
      return cache.put(key, value);
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   *
   * @param key
   * @return
   */
  public V remove(K key) {
    lock.writeLock().lock();
    try {
      return cache.remove(key);
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   *
   * @param m
   */
  public void putAll(Map<? extends K, ? extends V> m) {
    lock.writeLock().lock();
    try {
      cache.putAll(m);
    } finally {
      lock.writeLock().unlock();
    }
  }

  /**
   * Removes all of the mappings from this cache. The cache will be empty after this call returns.
   */
  public void clear() {
    lock.writeLock().lock();
    try {
      cache.clear();
    } finally {
      lock.writeLock().unlock();
    }
  }
}
