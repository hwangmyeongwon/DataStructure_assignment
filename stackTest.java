class Stack{
    Object[] elems;
    int top;
    public Stack(){
        elems=new Object[10];
        top=-1;
    }
    public boolean isEmpty(){
        if(top==-1)return true;
        else return false;
    }
    public void push(Object x){
        if(top==9){

        }
        else{
            top++;
            elems[top]=x;
        }
    }
    public Object pop(){
        if(isEmpty())return null;
        Object temp=elems[top];
        top--;
        return temp;
    }
    
}

public class stackTest {
}
