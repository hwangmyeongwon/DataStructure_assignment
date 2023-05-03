class ListNode {
    Object data;
    ListNode link;

    public ListNode() {
        link=null;
    }
    public ListNode(Object n) {
        data=n;
        link=null;
    }
}


class GenList {
    private ListNode head; // 리스트의 첫 번째 ListNode에 대한 참조를 저장

    void insertData(Object x) {  // 리스트 head 다음에 새로운 ListNode를 삽입 addFirst부분
        ListNode newNode = new ListNode();
        newNode.data = x;
        newNode.link = head;
        head = newNode;
    }


    void printGL() { // 일반 리스트를 프린트
        System.out.print("(");
        ListNode p = head;
        while (p != null) {
            if ((p.data) instanceof GenList) {
                ((GenList) p.data).printGL();
            } else {
                System.out.print(p.data);
            }
            if ((p = p.link) != null) {
                System.out.print(",");
            }
        }
        System.out.print(")");
    } // printGL()

    public GenList copy() {  // 공용 서브리스트가 없는 경우.
        GenList gn = new GenList();
        gn.head = theCopy(head);
        return gn;
    }

    private ListNode theCopy(ListNode h) {
        ListNode p = null;
        Object q;
        ListNode r;
        if (h != null) {
            if (!(h.data instanceof GenList)) q = h.data;
            else q = ((GenList) h.data).copy();
            r = theCopy(h.link);
            p = new ListNode();
            p.data = q;
            p.link = r;
        }
        return p;
    }


    public boolean equal(GenList T) {
        return theEqual(this.head, T.head);
    }

    private boolean theEqual(ListNode s, ListNode t) {
        if (s == null && t == null) return true;
        if (s == null && t != null) return false;
        if (s != null && t == null) return false;

        if (s.data instanceof GenList && t.data instanceof GenList) {
            if (((GenList) s.data).equal((GenList) t.data)) return theEqual(s.link, t.link);
            else return false;
        } else if (!(s.data instanceof GenList) && !(t.data instanceof GenList)) {
            if (s.data.equals(t.data)) return theEqual(s.link, t.link);
            else return false;
        } else return false;
    }
    public int depth(){
        return theDepth(head);
    }
    private int theDepth(ListNode h){
        int max=0;
        int d;
        ListNode p;
        if(h==null)return 0;
        p=h;
        while(p!=null){
            if(p.data instanceof GenList){
                d=((GenList)p.data).depth();
            }
            else
                d=0;
            if(d>max)max=d;
            p=p.link;
        }
        return max+1;
    }
}
public class GenListTest {
    public static void main(String[] args) {
        GenList p=new GenList();
        p.insertData(new Integer(82));
        p.insertData("korea");
        GenList q=new GenList();
        q.insertData(p);
        q.insertData("seoul");
        GenList r=new GenList();
        r.insertData(q);
        r.insertData("busan");
        GenList L=new GenList();
        L.insertData(r);
        L.printGL();
        System.out.println();

        System.out.println("L의 객체 수 : "+L.depth());

        System.out.println("L과 r이 같은지 확인(true/false) : "+L.equal(r));

    }

}
