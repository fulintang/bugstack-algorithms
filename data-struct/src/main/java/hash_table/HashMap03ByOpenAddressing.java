package hash_table;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 开放寻址
 *
 * @param <K>
 * @param <V>
 */
public class HashMap03ByOpenAddressing<K, V> implements Map<K, V> {

    private final Logger log = LoggerFactory.getLogger(HashMap03ByOpenAddressing.class);
    private final Node<K, V>[] tab = new Node[8];

    @Override
    public void put(K key, V value) {
        int idx = key.hashCode() & (tab.length - 1);
        if (tab[idx] == null) {
            tab[idx] = new Node<>(key, value);
        } else {
            for (int i = idx, len = tab.length; i < len; i++) {
                if (tab[i] == null) {
                    tab[i] = new Node<>(key, value);
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        int idx = key.hashCode() & (tab.length - 1);
        for (int i = idx; i < tab.length; i++) {
            if (tab[i] != null && tab[i].key == key) {
                return tab[i].value;
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

    @Override
    public String toString() {
        return "HashMap03ByOpenAddressing{" +
                "tab=" + JSON.toJSONString(tab) +
                '}';
    }

}
