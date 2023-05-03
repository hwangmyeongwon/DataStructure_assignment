class ListNode{
    Object data;
    ListNode link;

    ListNode(){
        data=null;
        link=null;
    }
    ListNode(Object data){
        this.data=data;
        link=null;
    }
}
class ListStack{
    private ListNode top;
    public boolean isEmpty(){
        return (top==null);
    }
    public void push(Object x){
        ListNode newNode=new ListNode();
        newNode.data=x;
        newNode.link=top;
        top=newNode;
    }
    public Object pop(){
        if(isEmpty())return null;
        else{
            Object item=top.data;
            top=top.link;
            return item;
        }
    }
    public void remove(){
        if(isEmpty())return;
        else top=top.link;
    }
    public Object peek(){
        if(isEmpty())return null;
        else return top.data;
    }
}

public class ListStackTest {
}
