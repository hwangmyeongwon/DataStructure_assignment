class DoubleListNode {
    Object data;
    DoubleListNode rlink;
    DoubleListNode llink;
}

class Deque {   // 이중 연결 리스트로 구현
    private DoubleListNode head, tail;
    private int count = 0;

    public Deque() {
        head = new DoubleListNode();
        tail = new DoubleListNode();

        head.llink = null;
        head.data = null;
        head.rlink = tail;

        tail.rlink = null;
        tail.data = null;
        tail.llink = head;
    }

    public void insertFirst(Object value) {
        DoubleListNode newNode = new DoubleListNode();
        newNode.data = value;
        DoubleListNode second = head.rlink;
        second.llink = newNode;
        newNode.rlink = second;
        newNode.llink = head;
        head.rlink = newNode;
        count++;
    }

    public void insertLast(Object value) {
        DoubleListNode newNode = new DoubleListNode();
        newNode.data = value;
        DoubleListNode secondtolast = tail.llink;
        newNode.llink = secondtolast;
        secondtolast.rlink = newNode;
        newNode.rlink = tail;
        count++;
    }
}

public class DequeueTest {
}
