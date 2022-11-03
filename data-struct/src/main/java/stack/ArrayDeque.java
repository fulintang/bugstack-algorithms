package stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数组堆栈
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/11/3 16:59
 */
public class ArrayDeque<E> implements Deque<E> {

    private final Logger log = LoggerFactory.getLogger(ArrayDeque.class);

    /**
     * 存储双端队列元素的数组。双端队列的容量就是这个数组的长度，它总是2的幂。
     * 数组永远不允许变满，除非在addX方法中短暂的在变满后立即调整大小（请参阅doubleCapacity）,
     * 从而避免头部和尾部环绕以彼此相等。我们还保证所有不包含双端队列元素的数组单元始终为空。
     */
    transient Object[] elements;

    /**
     * 双端队列头部元素的索引（将被remove() 或者 pop() 删除的元素）；如果双端队列为空，则等于tail的任意数字。
     */
    transient int head;

    /**
     * 将下一个元素添加到双端队列的索引（通过 addLast(E)、add(E) 或 push(E)）
     */
    transient int tail;

    /**
     * 构造一个空数组双端队列，jdk源码其初是容量是16
     */
    public ArrayDeque() {
        // 默认是16个长度，这里是小傅哥把长度缩短了的，便于测试，我这里也就保留了2的初始长度
        elements = new Object[2];
    }

    @Override
    public void push(E e) {
        if (e == null)
            throw new NullPointerException();
        log.info("head - 1 = {} Binary: {} , elements.length Binary = {}", head - 1, Integer.toBinaryString(head - 1), Integer.toBinaryString(elements.length - 1));
        // 这里的 & 是按位与计算，有0则为0，需要将两个数全部转换成二进制
        elements[head = (head - 1) & (elements.length - 1)] = e;
        log.info("push.idx head: {}", head);
        if (head == tail)
            doubleCapacity();
    }

    /**
     * 扩容，将容量扩充为原容量的2倍。仅在满时调整，即当头部和尾部缠绕成相等时。
     */
    private void doubleCapacity() {
        assert head == tail;
        int p = head; // 头
        int n = elements.length; // 数组长度
        int r = n - p; //需要迁移的长度
        int newCapacity = n << 1;
        if (newCapacity < 0)
            throw new IllegalStateException("Sorry, deque too big");
        Object[] tempArr = new Object[newCapacity];
        // 第一次拷贝元素
        System.arraycopy(elements, p, tempArr, 0, r);
        System.arraycopy(elements, 0, tempArr, r, p);
        elements = tempArr;
        head = 0;
        tail = n;
    }

    @Override
    public E pop() {
        int h = head;
        @SuppressWarnings("unchecked")
        E result = (E) elements[h];
        if (result == null)
            return null;
        elements[h] = null;
        head = (h + 1) & (elements.length - 1);
        log.info("pop.idx {} = {} & {}", head, Integer.toBinaryString(h + 1), Integer.toBinaryString(elements.length - 1));
        return result;
    }

}
