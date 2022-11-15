package heap._test_;

import heap.IHeap;
import heap.MaxHeap;
import heap.MinHeap;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试最小堆
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/11/15 8:43
 */
public class HeapTest {

    private final Logger log = LoggerFactory.getLogger(HeapTest.class);

    @Test
    public void testMinHeap() {
        IHeap<Integer> heap = new MinHeap();

        // 存入元素
        heap.add(1);
        heap.add(3);
        heap.add(5);
        heap.add(11);
        heap.add(4);
        heap.add(6);
        heap.add(7);
        heap.add(12);
        heap.add(15);
        heap.add(10);
        heap.add(9);
        heap.add(8);
        
        while (heap.peek() != null) {
            log.info("出堆：{}", heap.poll());
        }

    }
    
    @Test
    public void testMaxHeap() {
        IHeap<Integer> heap = new MaxHeap();

        // 存入元素
        heap.add(1);
        heap.add(3);
        heap.add(5);
        heap.add(11);
        heap.add(4);
        heap.add(6);
        heap.add(7);
        heap.add(12);
        heap.add(15);
        heap.add(10);
        heap.add(9);
        heap.add(8);

        while (heap.peek() != null) {
            log.info("出堆：{}", heap.poll());
        }

    }

}
