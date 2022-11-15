package heap;

public interface IHeap<E> {

    boolean add(E e);
    
    boolean offer(E e);
    
    E poll();
    
    E peek();
    
}
