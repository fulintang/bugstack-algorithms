package heap;

/**
 * 最小堆
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/11/15 8:41
 */
public class MinHeap extends Heap<Integer> {

    @Override
    public int compareTo(Integer firstElement, Integer secondElement) {
        return firstElement.compareTo(secondElement);
    }

}
