////class ListNode{
////    String data;
////    ListNode link;
////
////    public ListNode() {
////        link=null;
////    }
////
////    public ListNode(String n) {
////        data=n;
////        link=null;
////    }
////
////    public ListNode(String n, ListNode l){
////        data=n;
////        link=l;
////    }
////    public void putData(String n) {
////        data=n;
////    }
////
////    public String getData() {
////        return data;
////    }
////
////    public void putLink(ListNode next) {
////        link=next;
////    }
////
////    public ListNode getLink() {
////        return link;
////    }
////
////}
////class FreeSpaceList{
////    ListNode free;
////    public ListNode getNode(){
////        if(free==null) return null;
////        else{
////            ListNode temp=free;
////            free=free.link;
////            return temp;
////        }
////    }
////    public void returnList(ListNode h){
////        ListNode t=h;
////        while(t.link!=null)
////            t=t.link;
////        t.link=free;
////        free=h;
////    }
////    public void returnCList(ListNode head){
////        if(head !=null){
////            ListNode p=head.link;
////            head.link=free;
////            free=p;
////        }
////    }
////
////}
////
//class List{
//    private ListNode head;//firstNode
//    private int size;
//
//    public List(){
//        head=null;
//        size=0;
//    }
//    public int size(){
//        return size;
//    }
//    public void addFirst(String x){
//        ListNode newNode=new ListNode();
//        newNode.data=x;
//        newNode.link=head; //세줄 합하면 ListNode newNode=new ListNode(x,head);
//        head=newNode;
//        size++;
//    }
//    public void insert(ListNode p,String x){
//        ListNode newNode=new ListNode();
//        newNode.data=x;
//        if(head==null){
//            head=newNode;
//            head.link=null;
//        }
//        else if(p==null){
//            //첫번째 Node(원소2)
//            newNode.link=head;
//            head=newNode;
//        }
//        else{
//            newNode.link=p.link;
//            p.link=newNode;
//        }
//        size++;
//    }
//    public void addLast(String x){
//        ListNode newNode=new ListNode();
//        newNode.data=x;
//        newNode.link=null;
//        if(head==null)
//            head=newNode;
//        else {
//            ListNode p = head;
//            while(p.link!=null)
//                p=p.link;
//            p.link=newNode;
//        }
//        size++;
//    }
//    public void delete(ListNode p){
//        if(head==null)return;
//        else if(p==null){
//            head=head.link;
//        }
//        else{
//            if(p.link!=null) {
//                p.link=p.link.link;
//            }
//        }
//        size--;
//    }
//    public void reverse() {
//        ListNode p=head;
//        ListNode g=null;
//        while(p!=null){
//            ListNode r=g;
//            g=p;
//            p=p.link;
//            g.link=r;
//        }
//        head=g; //first=g;
//    }
//    public void addList(List l2) {
//        this.size=this.size+l2.size;
//        if(this.head==null)
//            this.head=l2.head;
//        else if(l2.head==null){
//        }
//        else{
//            ListNode p=head;
//            while(p.link!=null)
//                p=p.link;
//            p.link=l2.head;
//        }
//    }
//    public List ConcatList(List l1, List l2) {
//        List newList=new List();
//        newList.size=l1.size+l2.size;
//        if(l1.head==null){
//            newList.head=l2.head;
//        }
//        else if(l2.head==null){
//            newList.head=l1.head;
//        }
//        else{
//            ListNode p=l1.head;
//            while(p.link!=null)
//                p=p.link;
//            p.link=l2.head;
//        }
//        return newList;
//    }
//
//    public ListNode listSearch(String x) {
//        ListNode p=head;
//        while(p!=null){
//            if((p.getData()).equals(x))
//                return p;
//            p=p.link;
//        }
//        return p;//못찾아서 null 반환
//    }
//    public void deleteLastNode() {
//        ListNode p,c;
//        if(head==null)
//            return;
//        if(head.link==null)
//            head=null;
//        else{
//            p=head;
//            c=head.link;
//            while(c.link!=null){
//                p=c;
//                c=c.link;
//            }
//            p.link=null;
//        }
//    }
//    public void print() {
//        ListNode p;
//        System.out.print("(");
//        p=head;
//        while(p!=null){
//            System.out.print(p.data);
//            p=p.link;
//            if(p!=null){
//                System.out.print(",");
//            }
//        }
//        System.out.print(")");
//        System.out.println();
//    }
//}
//
//class CircularList{ //원형 연결 리스트
//    private ListNode tail;
//    private int length;
//
//    public CircularList(){
//        this.tail=null;
//    }
//    public int lengthC(){
//        return length;
//
//    }
//    public void addFirst(String x){
//        ListNode newNode=new ListNode();
//        newNode.data=x;
//        newNode.link=tail;
//        if(tail==null){
//            tail=newNode;
//        }
//        else{
//            ListNode current = tail;
//            while(current.link!=tail){
//                current = current.link;
//            }
//            newNode.link = current.link;
//            current.link = newNode;
//            tail = newNode;
//        }
//        length++;
//    }
//    public void insertMiddle(ListNode p, String x) {
//        ListNode newNode = new ListNode(x);
//        if( tail == null){
//            tail = newNode;
//        }else{
//            ListNode current = tail;
//            while(current.link!=p){
//                current = current.link;
//            }
//            current = current.link;
//            newNode.link = current.link;
//            current.link = newNode;
//        }
//        length++;
//
//    }
//
//
//    public void addLast(String x) {
//        ListNode node = new ListNode(x);
//        if (tail == null) {
//            tail = node;
//            node.link = node;
//        } else {
//            ListNode current = tail;
//            while (current.link != tail) {
//                current = current.link;
//            }
//            node.link = current.link;
//            current.link = node;
//
//        }
//        length++;
//    }
//    public void deleteFirstNode(){
//        if(tail==null){
//            System.out.println("지울 노드가 존재하지 않습니다.");
//        }else{
//            ListNode current = tail;
//            while(current.link!=tail){
//                current = current.link;
//            }
//            ListNode old = current.link;
//            tail = old.link;
//            current.link = tail;
//            length++;
//        }
//
//    }
//
//
//
//    public void deleteMiddleNode(ListNode p){
//            if(tail==null){
//                System.out.println("지울 노드가 존재하지 않습니다.");
//            }else{
//                ListNode prev = tail;
//                ListNode current = tail.link;
//                while(current.data!=p.data){
//                    prev = current;
//                    current = current.link;
//                }
//                prev.link = current.link;
//                length--;
//            }
//
//    }
//
//    void deleteLastNode(){
//        if(tail==null){
//            System.out.println("지울 노드가 존재하지 않습니다.");
//        }else{
//            ListNode prev = tail;
//            ListNode current = tail.link;
//            while(current.link!=tail){
//                prev = current;
//                current = current.link;
//            }
//            prev.link = current.link;
//            length--;
//        }
//    }
//
//
//
//    public void print(){
//            if(tail==null){
//                System.out.println("출력할 리스트가 존재하지 않습니다.");
//            }else{
//                ListNode current = tail;
//                System.out.print("(");
//                while(current.link!=tail){
//                    System.out.print(current.data + " ");
//                    current = current.link;
//                }
//                System.out.print(current.data);
//                System.out.print(")");
//                System.out.println();
//            }
//
//    }
//
//
//}
////class DNode{ //이중연결 리스트
////    String data;
////    DNode llink;
////    DNode rlink;
////
////    public DNode(){
////        llink=null;
////        rlink=null;
////    }
////    public DNode(String x){
////        data=x;
////        llink=null;
////        rlink=null;
////    }
////    public DNode(String x,DNode l){
////        data=x;
////
////    }
////}
//// class DLinkedList{ //이중연결 리스트
////    DNode head;
////    int length;
////
////    public DLinkedList(){
////        head=new DNode();
////        head.rlink=head;
////        head.llink=head;
////        length=0;
////    }
////
////    public void delete(DNode p){
////        p.llink.rlink=p.rlink;
////        p.rlink.llink=p.llink;
////    }
////
////
////    DNode newNode=new DNode();
////    newNode.data=x;
////    newNode.llink=p;
////    newNode.rlink=p.rlink;
////    p.rlink
////    public void add
////
////
////}
////
////
//public class ListTest {
//    public static void main(String[] args) {
//        List l1=new List();
//        List l2=new List();
//        List l3=new List();
//
//        ListNode ln=new ListNode();
//        ListNode ln2=new ListNode();
//        ListNode ln3=new ListNode("치킨");
//
//        l1.insert(ln,"지코바");
//        l1.addFirst("네네");
//        l1.addLast("교촌");
//        l1.delete(ln3);
//        l1.deleteLastNode();
//        l1.print();
//        l1.reverse();
//        l1.print();
//
//        l2.insert(ln2,"닭발");
//        l2.addFirst("피자");
//        l2.addLast("떡볶이");
//
//        l2.print();
//
//        l1.addList(l2);
//
//        System.out.println(l1.size());
//
//        l1.print();
//
//    }
//}
