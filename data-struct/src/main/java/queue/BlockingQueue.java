package queue;

/**
 * 阻塞队列
 * 
 * @param <E>
 */
public interface BlockingQueue<E> extends Queue<E> {

    @Override
    boolean add(E e);

    @Override
    boolean offer(E e);
    
}
