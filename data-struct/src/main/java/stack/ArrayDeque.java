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
        log.info("头：{}， 尾巴：{}", head, tail);
    }

    @Override
    public void push(E e) {
        if (e == null)
            throw new NullPointerException();
        log.info("head - 1 = {} 二进制: {} , 数组长度二进制 = {}", head - 1, Integer.toBinaryString(head - 1), Integer.toBinaryString(elements.length - 1));
        /*
         * 这里的 & 是按位与计算，有0则为0，需要将两个数全部转换成二进制
         * 规律，符号相同按位与取最小的，符号不同按位与取正书，
         */
        elements[head = (head - 1) & (elements.length - 1)] = e;
        log.info("放入数据坐标：{}", head);
        log.info("头：{}， 尾巴：{}", head, tail);
        if (head == tail)
            doubleCapacity();
    }

    /**
     * 扩容，将容量扩充为原容量的2倍。仅在满时调整，即当头部和尾部缠绕成相等时。
     */
    private void doubleCapacity() {
        assert head == tail; // ? 当头尾相等时才能进行扩容
        int point = head; // 指针位置，按照逻辑是在中间
        int oldArrLength = elements.length; // 数组长度
        int oldArrCenter = oldArrLength - point; // 数组一半的长度
        /*
         * 右移1位，相当于乘以2，但是当达到极限大小时011111111111111111111111111111 = 2^31，
         * 右移动就变成负数111111111111111111111111111111 = -1 （反补码）咯
         */
        int newCapacity = oldArrLength << 1;
        if (newCapacity < 0)
            throw new IllegalStateException("Sorry, deque too big");
        Object[] tempArr = new Object[newCapacity];
        /*
         * Params:
         * src – the source array. 源数据Array
         * srcPos – starting position in the source array. 源数组中起始位置
         * dest – the destination array. 目标Array
         * destPos – starting position in the destination data. 布标数组中起始位置
         * length – the number of array elements to be copied. 要复制的数组元素个数
         */
        // 第一次拷贝元素
        System.arraycopy(elements, point, tempArr, 0, oldArrCenter);
        // 第二次拷贝元素
        System.arraycopy(elements, 0, tempArr, oldArrCenter, point);
        elements = tempArr;
        head = 0; // 扩容后的头都是0
        tail = oldArrLength; // 扩容后的尾都是扩容后的第一位
        log.info("扩容后，头：{}， 尾巴：{}", head, tail);
    }

    @Override
    public E pop() {
        int h = head;
        @SuppressWarnings("unchecked")
        E result = (E) elements[h];
        if (result == null)
            return null;
        elements[h] = null;
        /*
         * head如果超过元素数量的话
         * 与计算head就会变成0
         */
        head = (h + 1) & (elements.length - 1);
        log.info("pop.idx {} = {} & {}", head, Integer.toBinaryString(h + 1), Integer.toBinaryString(elements.length - 1));
        return result;
    }

}
