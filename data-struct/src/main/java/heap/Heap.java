package heap;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 手写堆
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/11/14 11:28
 */
public class Heap<E> implements IHeap<E> {

    private final Logger log = LoggerFactory.getLogger(Heap.class);
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    transient Object[] queue;
    private int size = 0;

    public Heap() {
        this.queue = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    @Override
    public boolean add(E element) {
        return offer(element);
    }

    @Override
    public boolean offer(E element) {
        if (element == null)
            throw new NullPointerException();
        int point = size; // 当前下标
        size = point + 1;
        if (point >= queue.length) {
            grow(size); // 扩容
        }
        if (point == 0) {
            queue[0] = element;
        } else {
            siftUpComparable(point, element);
        }
        return true;
    }

    private void grow(int minCapacity) {
        int oldCapacity = queue.length; // 数组长度
        int newCapacity = oldCapacity + ((oldCapacity < 64)
                ? (oldCapacity + 2)
                : (oldCapacity >> 1));
        //  TODO 需要理解下，为何需要判断最大值
        if (newCapacity - Integer.MAX_VALUE - 8 > 0)
            newCapacity = (minCapacity > Integer.MAX_VALUE - 8)
                    ? Integer.MAX_VALUE
                    : Integer.MAX_VALUE - 8;
        queue = Arrays.copyOf(queue, newCapacity);
    }

    /**
     * 入堆，入堆是将数据放到队尾，然后和前面的数进行比较。
     *
     * @param childPoint   子元素指针
     * @param childElement 子元素
     */
    private void siftUpComparable(int childPoint, E childElement) {
        log.info("【入队】放入的元素：{}， 当前队列：{}", JSON.toJSONString(childElement), JSON.toJSONString(queue));
        while (childPoint > 0) {
            // 获取父节点idx，相当于除以2
            int parent = (childPoint - 1) >>> 1;
            log.info("【入队】寻找当前节点的父节点位置。当前节点：{} 的父节点为：{}", childPoint, parent);
            Object parentElement = queue[parent];
            if (compareTo(childElement, (E) parentElement) >= 0) {
                log.info("【入队】不需要替换咯，跳出循环");
                break;
            }
            // 相反父节点的位置大于当前位置元素，则进行替换
            log.info("【入队】将父节点下移，父节点值：{}，目标位置：{}", parentElement, childPoint);
            queue[childPoint] = parentElement;
            childPoint = parent; // 比较后上移
        }
        queue[childPoint] = childElement;
    }

    @Override
    public E poll() {
        if (size == 0)
            return null;
        int lastPoint = --size;
        E result = (E) queue[0]; // 堆顶元素要出堆
        E lastElement = (E) queue[lastPoint];
        queue[lastPoint] = null;
        if (lastPoint != 0)
            siftDownComparable(0, lastElement);
        return result;
    }

    private void siftDownComparable(int point, E lastElement) {
        int half = size >>> 1;
        // TODO 为何需要小于中间呢？
        while (point < half) {
            // 找到其左右节点，并比较
            int child = (point << 1) + 1;
            Object childElement = queue[child];
            int right = child + 1;
            // 左右节点比较，找出最小节点
            if (right < size && compareTo((E) childElement, (E) queue[right]) > 0) {
                // 为何要小于size呢？因为如果大于size，那么就不存在右侧节点了啊
                log.info("【出队】对比发现，右侧才是需要比对的值，left：{}, right：{}", JSON.toJSONString(childElement), JSON.toJSONString(queue[right]));
                childElement = queue[child = right];
            }
            // 比较父节点和子节点的大小，如果
            if (compareTo((E) childElement, lastElement) > 0) {
                break;
            }
            queue[point] = childElement;
            point = child;
        }
        queue[point] = lastElement;
    }

    @Override
    public E peek() {
        // 这是一个堆，当然是拿queue0咯
        return size == 0 ? null : (E) queue[0];
    }

    public int compareTo(E firstElement, E secondElement) {
        throw new RuntimeException("未实现compareTo方法");
    }

}
