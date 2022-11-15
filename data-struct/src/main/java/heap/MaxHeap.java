package heap;

/**
 * 最大堆
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/11/15 8:39
 */
public class MaxHeap extends Heap<Integer> {

    @Override
    public int compareTo(Integer firstElement, Integer secondElement) {
        return secondElement.compareTo(firstElement);
    }

}
