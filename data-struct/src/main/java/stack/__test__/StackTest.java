package stack.__test__;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stack.ArrayDeque;
import stack.Deque;

/**
 * 测试类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/11/3 18:02
 */
public class StackTest {
    
    private final Logger log = LoggerFactory.getLogger(StackTest.class);
    
    @Test
    public void testStack() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        deque.push(5);
        deque.push(6);
        deque.push(7);
        log.info("弹出元素：{}", deque.pop());
        log.info("弹出元素：{}", deque.pop());
        log.info("弹出元素：{}", deque.pop());
        log.info("弹出元素：{}", deque.pop());
        log.info("弹出元素：{}", deque.pop());
        log.info("弹出元素：{}", deque.pop());
        log.info("弹出元素：{}", deque.pop());
    }
    
}
