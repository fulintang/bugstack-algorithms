package hash_table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * 拉链寻址
 * 
 * @param <K>
 * @param <V>
 */
public class HashMap02BySeparateChaining<K, V> implements Map<K, V> {
    
    private final Logger log = LoggerFactory.getLogger(HashMap02BySeparateChaining.class);
    private final List<Node<K, V>>[] tab = new LinkedList[8];
    
    @Override
    public void put(K key, V value) {
        int idx = key.hashCode() & (tab.length - 1);
        if (tab[idx] == null) {
            tab[idx] = new LinkedList<>();
            tab[idx].add(new Node<>(key, value));
        } else {
            tab[idx].add(new Node<>(key, value));
        }
    }

    @Override
    public V get(K key) {
        int idx = key.hashCode() & (tab.length - 1);
        List<Node<K, V>> nodeLinkedList = tab[idx];
        if (nodeLinkedList == null)
            return null;
        for (Node<K, V> kvNode : nodeLinkedList) {
            if (key.equals(kvNode.getKey())) {
                return kvNode.value;
            }
        }
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
