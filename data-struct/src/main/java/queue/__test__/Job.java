package queue.__test__;

import queue.Delayed;

import java.util.concurrent.TimeUnit;

/**
 * 测试用数据
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/10/31 18:11
 */
public class Job implements Delayed {

    private final String name;
    private final Long begin;
    private final Long delayTime;

    public Job(String name, Long dealyTime) {
        this.name = name;
        this.begin = System.currentTimeMillis();
        this.delayTime = dealyTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(begin + delayTime - System.currentTimeMillis(), TimeUnit.MICROSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Job job = (Job) o;
        return (int) (this.getDelay(TimeUnit.MICROSECONDS) - job.getDelay(TimeUnit.MICROSECONDS));
    }

    public String getName() {
        return name;
    }
    
    
}
