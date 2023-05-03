//class Queue{
//    private Object[] elems;
//    private int front;
//    private int rear;
//
//    public Queue(){
//        elems=new Object[10];
//        front=rear=-1;
//    }
//    public boolean isEmpty(){
//        if(front==rear)
//            return true;
//        else
//            return false;
//    }
//    public void enqueue(Object x){
//        if(rear!=9) return;
//        else{
//            rear++;
//            elems[rear]=x;
//        }
//    }
//    public Object dequeue(Object x){
//        if(isEmpty())
//            return null;
//        else{
//            front++;
//            return elems[front];
//        }
//    }
//    public Object remove(Object x){
//
//    }
//}
//
//public class QueueTest {
//}
