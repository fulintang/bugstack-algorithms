package hash_table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashMap03ByOpenAddressing<K, V> implements Map<K, V> {
    
    private final Logger log = LoggerFactory.getLogger(HashMap03ByOpenAddressing.class);
    private final Node<K, V>[] tab = new Node[8];
    
    @Override
    public void put(K key, V value) {
        
    }

    @Override
    public V get(K key) {
        return null;
    }

    static class Node<K, V> {
        final K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

    }
    
    
}
