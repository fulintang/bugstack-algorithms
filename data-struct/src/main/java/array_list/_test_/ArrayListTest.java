package array_list._test_;

import array_list.ArrayList;
import array_list.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 测试类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/10/13 14:33
 */
public class ArrayListTest {
    
    private final Logger log = LoggerFactory.getLogger(ArrayListTest.class);
    
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("01");
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");
        list.add("06");
        list.add("07");
        list.add("08");
        list.add("09");
        list.add("10");
        list.add("11");
        list.add("12");
        log.info("{}", list);
        list.remove(9);
        log.info("{}", list);
    }
    
}
