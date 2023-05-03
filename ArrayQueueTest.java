class ArrayQueue {
    private int front;        // 큐의 삭제 장소
    private int rear;        // 큐의 삽입 장소
    private int count;    // 큐의 원소 수
    private int queueSize;    // 큐(배열)의 크기
    private int increment;    // 배열의 확장 단위
    private Object[] itemArray;     // Java 객체타입의 큐 원소를 위한 배열

    public ArrayQueue() {    // 무인자 큐 생성자
        front=rear=0;
        count = 0;
        queueSize = 50;        // 초기 큐 크기
        increment = 10;        // 배열의 확장 단위
        itemArray = new Object[queueSize];
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public void enqueue(Object x) {
        if (count == queueSize) queueFull();
        itemArray[rear] = x;     // 새로운 원소를 삽입
        rear = (rear + 1) % queueSize;
        count++;
    }     // end queue( )

    public void queueFull() {     // 배열이 만원이면 increment만큼 확장
        int oldsize = queueSize;       // 현재의 배열 크기를 기록
        queueSize += increment;     // 새로운 배열 크기
        Object[] tempArray = new Object[queueSize];     // 확장된 크기의 임시 배열
        for (int i = 0; i < count; i++) {     // 임시 배열로 원소들을 그대로 이동
            tempArray[i] = itemArray[front];
            front = (front + 1) % oldsize;
        }
        itemArray = tempArray;     // 배열 참조 변수를 변경
        front = 0;
        rear = count;
    }
    public Object dequeue( )  {     // 큐에서 원소를 삭제해서 반환
        if (isEmpty()) return null;     // 큐가 공백일 경우
        // 큐가 공백이 아닌 경우
        Object item = itemArray[front];
        front = (front + 1) % queueSize;
        count --;
        return item;
    }     // end dequeue()

    public Object peek( )  {     // 큐에서 원소값을 반환
        if (isEmpty()) return null;
        else return itemArray[front];
    }  //     end peek()


}
public class ArrayQueueTest {

}
