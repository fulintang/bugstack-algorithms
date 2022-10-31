package queue;

/**
 * 双端队列
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/10/21 10:12
 */
public interface Deque<E> extends Queue<E> {
    
    void addFirst(E e);
    
    void addLast(E e);
    
}
