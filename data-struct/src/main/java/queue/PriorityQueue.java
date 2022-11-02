package queue;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

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
        if (i >= queue.length) {
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

    /**
     * 扩容
     *
     * @param minCapacity 当前容量
     */
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ? (oldCapacity + 2) : (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - Integer.MAX_VALUE - 8 > 0)
            newCapacity = (minCapacity > Integer.MAX_VALUE - 8) ? Integer.MAX_VALUE : Integer.MAX_VALUE - 8;
        queue = Arrays.copyOf(queue, newCapacity);
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
    @SuppressWarnings("all")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            // 获取父节点的index，除以二取整
            int parent = (k - 1) >>> 1;
            log.info("【入队】寻找当前节点的父节点位置。k：{}, parent：{}", k, parent);
            Object e = queue[parent];
            // 如果当前位置元素，大于父节点元素，则退出循环
            if (key.compareTo((E) e) > 0) {
                log.info("【入队】值对比, 小于父节点，父节点：{} 目标节点：{}", JSON.toJSONString(e), JSON.toJSONString(key));
                break;
            }
            // 相反，父节点元素 > 当前元素，则将父节点与当前节点进行替换
            log.info("【入队】替换过程，父子节点位置替换，继续循环。父节点值：{} 存放到位置：{}", JSON.toJSONString(e), k);
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
        log.info("【入队】完成 Idx：{} Val：{} \r\n当前队列：{} \r\n", k, JSON.toJSONString(key), JSON.toJSONString(queue));
    }

    @Override
    @SuppressWarnings("unchecked")
    public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }

    private void siftDown(int k, E x) {
        siftDownComparable(k,  x);
    }

    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        int half = size >>> 1;
        while (k < half) {
            // 找到左子节点和右子节点，找出两个哪个最大
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            // 左子节点与右子节点比较，取最小的节点
            if (right < size && ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0) {
                log.info("【出队】左右子节点比对，获取最小值。left：{} right：{}", JSON.toJSONString(c), JSON.toJSONString(queue[right]));
            }
        }
        
        
    }

    @Override
    public E peek() {
        return null;
    }

    public int compareTo(E firstElement, E secondElement) {
        throw new RuntimeException("未实现 compareTo 方法");
    }

}
