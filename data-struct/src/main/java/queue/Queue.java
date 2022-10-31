package queue;

/**
 * 单端队列
 * 
 * @param <E>
 */
public interface Queue<E> {

    boolean add(E e);

    boolean offer(E e);
    
    E poll();
    
    E peek();
    
}
