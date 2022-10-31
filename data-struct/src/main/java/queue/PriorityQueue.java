package queue;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 优先队列
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/10/31 16:52
 */
public class PriorityQueue<E> implements Queue<E> {

    private final Logger log = LoggerFactory.getLogger(PriorityQueue.class);

    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    transient Object[] queue;

    private int size = 0;

    public PriorityQueue() {
        queue = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        int i = size;
        if (i > queue.length) {
            grow(i + 1);
        }
        size = i + 1;
        if (i == 0) {
            queue[0] = e;
        } else {
            siftUp(i, e);
        }
        return false;
    }

    private void grow(int i) {
    }

    /**
     * 入队
     *
     * @param k 标识
     * @param x 数据
     */
    private void siftUp(int k, E x) {
        siftUpComparable(k, x);
    }

    /**
     * 二叉堆存入数据时，存到队列的尾部，通过向上迁移比较
     *
     * @param k 标识
     * @param x 数据
     */
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            // 获取父节点的index，除以二取整
            int parent = (k - 1) >>> 1;
            log.info("【入队】寻找当前节点的父节点位置。k：{}, parent：{}", k, parent);
            Object e = queue[parent];
            // 如果当前位置元素，大于父节点元素，则退出循环
            if (key.compareTo((E) e) > 0) {
                log.info("【入队】值对比，父节点：{} 目标节点：{}", JSON.toJSONString(e), JSON.toJSONString(key));
                break;
            }
            // 相反，父节点元素 > 当前元素，则将父节点与当前节点进行替换
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
        log.info("【入队】完成 Idx：{} Val：{} \r\n当前队列：{} \r\n", k, JSON.toJSONString(key), JSON.toJSONString(key));
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    public int compareTo(E firstElement, E secondElement) {
        throw new RuntimeException("未实现 compareTo 方法");
    }

}
