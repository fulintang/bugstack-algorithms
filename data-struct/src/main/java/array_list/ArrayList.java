package array_list;

import java.util.Arrays;

/**
 * 实现数组列表
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/9/30 17:28
 */
public class ArrayList<E> implements List<E> {

    /**
     * 默认初始化空间
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空元素
     */
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    /**
     * ArrayList元素数组缓冲区
     */
    transient Object[] elementData;

    public ArrayList() {
        this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }

    /**
     * List集合元素数量
     */
    private int size;

    @Override
    public boolean add(E e) {
        // 确保内部容量
        int minCapacity = size + 1;
        if (this.elementData == DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        // 判断扩容操作
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1); // 扩容议案
            if (newCapacity - minCapacity < 0) { // 扩容后大小是否小于最小容量
                newCapacity = minCapacity; // 更改为最小容量
            }
            elementData = Arrays.copyOf(elementData, newCapacity); // 扩容
        }
        // 添加元素
        elementData[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null; // clear to let GC do its work
        return oldValue;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public String toString() {
        return "ArrayList{" + "elementData=" + Arrays.toString(elementData) + ", size=" + size +"}";
    }

}
