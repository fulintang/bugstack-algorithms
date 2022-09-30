package array_list;

/**
 * 实现数组列表
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/9/30 17:28
 */
public class ArrayList<E> implements List<E>{

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

    /**
     * List集合元素数量
     */
    private int size;
    
    @Override
    public boolean add(E e) {
        
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }
    
}
