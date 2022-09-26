package linked_list._test_;

import linked_list.LinkedList;
import linked_list.List;
import org.junit.jupiter.api.Test;

/**
 * 测试双向链表
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/9/26 16:25
 */
public class LinkedListTest {

    @Test
    public void testLinkedList() {
        List<String> list = new LinkedList<>();
        list.add("a");
        list.addFirst("b");
        list.addLast("c");
        list.printLinkedList();
        list.addFirst("d");
        list.remove("b");
        list.printLinkedList();
    }


}
