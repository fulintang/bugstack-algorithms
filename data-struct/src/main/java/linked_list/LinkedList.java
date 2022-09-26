package linked_list;

import java.util.StringJoiner;

/**
 * 链表
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/9/26 14:45
 */
public class LinkedList<E> implements List<E> {

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) first = newNode;
        else l.next = newNode;
        size++;
    }

    void unlink(Node<E> x) {
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;
        if (prev != null) {
            prev.next = next;
            x.prev = null;
        } else {
            first = next;
        }
        if (next != null) {
            next.prev = prev;
            x.next = null;
        } else {
            last = prev;
        }
        x.item = null;
        size--;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item.equals(o)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public void printLinkedList() {
        if (this.size == 0) {
            System.err.println("链表为空！");
        } else {
            Node<E> temp = first;
            System.out.print("目前的列表，头节点：" + first.item + " 尾节点：" + last.item + " 整体：");
            StringJoiner stringJoiner = new StringJoiner(", ");
            while (temp != null) {
                stringJoiner.add(temp.item.toString());
                temp = temp.next;
            }
            System.out.print(stringJoiner);
            System.out.println();
        }
    }

    Node<E> node(int index) {
        // size >> 1 右移1位，相当于除以2, 将链表二分，防止查询过久
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

}
