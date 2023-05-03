//class ListQueue{
//    public void enqueue(String x){
//        ListNode newNode=new ListNode();
//        newNode.data=x;
//        newNode.link=null;
//        if(rear==null)
//            rear=front=newNode;
//        else{
//            rear.link=newNode;
//            rear=newNode;
//        }
//    }
//    public String dequeue(){
//        if(front==null)
//            return null;
//        String temp=front.data;
//        front=front.link;
//        if(front==null)
//            rear==null;
//        return temp;
//    }
//}
//public class ListQueueTest {
//}
