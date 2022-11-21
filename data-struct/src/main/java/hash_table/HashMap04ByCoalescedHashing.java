package hash_table;

import com.alibaba.fastjson.JSON;

import java.util.Objects;

/**
 * 合并散列
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/11/21 15:57
 */
public class HashMap04ByCoalescedHashing<K, V> implements Map<K, V> {

    private final Node<K, V>[] tab = new Node[8];

    @Override
    public void put(K key, V value) {
        int idx = key.hashCode() & (tab.length - 1);
        if (tab[idx] == null) {
            tab[idx] = new Node<>(key, value);
            return;
        }
        if (Objects.equals(tab[idx].key, key)) {
            tab[idx] = new Node<>(key, value);
            return;
        }
        int cursor = tab.length - 1;
        while (tab[cursor] != null && tab[cursor].key != key) {
            --cursor;
        }
        tab[cursor] = new Node<>(key, value);

        while (tab[idx].idxOfNext != 0) {
            idx = tab[idx].idxOfNext;
        }

        tab[idx].idxOfNext = cursor;

    }

    @Override
    public V get(K key) {
        int idx = key.hashCode() & (tab.length - 1);
        while (tab[idx].key != key) {
            idx = tab[idx].idxOfNext;
        }
        return tab[idx].value;
    }

    static class Node<K, V> {
        final K key;
        V value;
        int idxOfNext;

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

        public int getIdxOfNext() {
            return idxOfNext;
        }

        public void setIdxOfNext(int idxOfNext) {
            this.idxOfNext = idxOfNext;
        }

    }

    @Override
    public String toString() {
        return "HashMap04ByCoalescedHashing{" +
                "tab=" + JSON.toJSONString(tab) +
                '}';
    }
}
