package hash_table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashMap01<K, V> implements Map<K, V>{
    
    private final Logger log = LoggerFactory.getLogger(HashMap01.class);
    private final Object[] tab = new Object[8];

    @Override
    public void put(K key, V value) {
        int idx = key.hashCode() & (tab.length - 1);
        tab[idx] = value;
    }

    @Override
    public V get(K key) {
        int idx = key.hashCode() & (tab.length - 1);
        return (V) tab[idx];
    }
    
}
