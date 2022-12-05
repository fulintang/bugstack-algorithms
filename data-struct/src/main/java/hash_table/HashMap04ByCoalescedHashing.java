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
            // 空的就直接放入
            tab[idx] = new Node<>(key, value);
            return;
        }
        if (Objects.equals(tab[idx].key, key)) {
            // 一样的键则直接覆盖
            tab[idx] = new Node<>(key, value);
            return;
        }
        // 游标起始为队列尾部
        int cursor = tab.length - 1;
        // 找寻非空的可覆盖游标
        while (tab[cursor] != null && tab[cursor].key != key) {
            --cursor;
        }
        // 覆盖
        tab[cursor] = new Node<>(key, value);

        // 寻找可替换的同hash项的next
        while (tab[idx].idxOfNext != 0) {
            idx = tab[idx].idxOfNext;
        }
        // 将可写入同hash项的下一位next写为游标
        tab[idx].idxOfNext = cursor;

    }

    @Override
    public V get(K key) {
        // hash下标
        int idx = key.hashCode() & (tab.length - 1);
        // 循环找到对应的下标（如果这个下标确实没有存在值呢？）
        while (tab[idx] !=null && tab[idx].key != key) {
            idx = tab[idx].idxOfNext;
        }
        if (tab[idx] == null)
            return null;
        return tab[idx].value;
    }

    static class Node<K, V> {
        final K key;
        V value;
        int idxOfNext; // 核心点在于多了一个next

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
