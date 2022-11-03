package queue.__test__;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import queue.DelayQueue;
import queue.Queue;

/**
 * TODO: 该类作用
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/10/31 18:11
 */
public class QueueTest {

    private final Logger log = LoggerFactory.getLogger(QueueTest.class);

    @Test
    public void testQueue() throws InterruptedException {
        Queue<Job> queue = new DelayQueue<>();
        queue.add(new Job("1号", 1000L));
        queue.add(new Job("3号", 3000L));
        queue.add(new Job("5号", 5000L));
        queue.add(new Job("11号", 11000L));
        queue.add(new Job("4号", 4000L));
        queue.add(new Job("6号", 6000L));
        queue.add(new Job("7号", 7000L));
        queue.add(new Job("12号", 12000L));
        queue.add(new Job("15号", 15000L));
        queue.add(new Job("10号", 10000L));
        queue.add(new Job("9号", 9000L));
        queue.add(new Job("8号", 8000L));

        //queue.add(new Job("2号", 2000L));

        while (true) {
            Job poll = queue.poll();
            if (null == poll) {
                Thread.sleep(10);
                if (queue.peek() == null) {
                    break;
                }
                continue;
            }
            log.info("{}", poll);
        }

    }

}
