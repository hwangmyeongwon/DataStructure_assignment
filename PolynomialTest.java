class PolyNode{
    int coef;
    int exp;
    PolyNode link; //private 추가

    public PolyNode(int c,int e){
        coef=c;
        exp=e;
        link=null;
    }
    public PolyNode(int coef, int exp, PolyNode link){
        this.coef = coef;
        this.exp = exp;
        this.link = link;
    }
    public int getCoef() {
        return this.coef;
    }
    public int getExp() {
        return this.exp;
    }
}
class Polynomial{
    private PolyNode first;
    private PolyNode last;

    public Polynomial(){
        first = null;
        last = null;
    }
    public boolean isPzero(){
        if(first==null)
            return false;
        else
            return true;

    }
    public int coef(int exp){
        PolyNode p=first;
        while(p.exp!=exp){
            p=p.link;
        }
        return p.coef;
    }
    public int maxExp(){
        return first.exp;
    }
    public void addTerm(int c,int e){
        PolyNode newNode=new PolyNode(c,e);
        if(first==null){
            first=newNode;
            last=newNode;
            return;
        }
        else if(e>first.exp){
            newNode.link=first;
            first=newNode;
            return;
        }
        else{
            PolyNode p=first;
            while(p.link!=null){
                if(e>p.link.exp){
                    newNode.link=p.link;
                    p.link=newNode;
                    return;
                }
                p=p.link;
            }
            p.link=newNode;
            last=newNode;
        }
    }
    public void appendTerm(int c,int e){
        PolyNode node=new PolyNode(c,e);
        if(first==null){
            first=node;
            last=node;
        }
        else{
            last.link=node;
            last=node;
        }
    }
    public void delTerm(int e) {
        if(first.exp==e){
            first=first.link;
        }
        else if(last.exp==e){
            PolyNode p = first;
            while (p.link.link!= null) {
                p = p.link;
            }
            last=p;
            p.link=null;
        }
        else {
            PolyNode p = first;
            while (p.link != null) {
                if (p.link.exp == e) {
                    p.link = p.link.link;
                    break;
                }
                p = p.link;
            }
        }

    }
    public Polynomial polyMult(Polynomial p) {
        Polynomial r=new Polynomial();
        Polynomial t=new Polynomial();
        PolyNode q=first;
        while(q!=null){
            r=p.sMult(q.coef,q.exp);
            t=t.polyAdd(r);
            q=q.link;
        }
        return t;
    }

    public Polynomial sMult(int c,int e){
        PolyNode p=first;
        Polynomial r=new Polynomial();
        while(p!=null){
            r.appendTerm(c*p.coef,e+p.exp);
            p=p.link;
        }
        return r;
    }

    public Polynomial polyAdd(Polynomial poly){
        Polynomial res = new Polynomial();
        PolyNode p=this.first;
        PolyNode g= poly.first;

        while(p!=null && g!=null){
            if(p.exp==g.exp){
                res.appendTerm(p.coef+g.coef,p.exp);
                p=p.link;
                g=g.link;
            }
            else if(p.exp>g.exp){
                res.appendTerm(p.coef,p.exp);
                p=p.link;
            }
            else{
                res.appendTerm(g.coef,g.exp);
                g=g.link;
            }
        }
        while(p!=null){
            res.appendTerm(p.coef,p.exp);
            p=p.link;
        }
        while(g!=null){
            res.appendTerm(g.coef,g.exp);
            g=g.link;
        }
        return res;
    }
    void print(){
        PolyNode p=first;
        System.out.print("다항식 : ");
        while(p!=null){
            System.out.print(p.coef);
            System.out.print("x^");
            System.out.print(p.exp);
            if(p!=last){
                if(p.link.coef>0)
                    System.out.print("+");
            }
            p=p.link;
        }
        System.out.println();
    }
}

public class PolynomialTest {
    public static void main(String[] args) {
        Polynomial p=new Polynomial();
        Polynomial q=new Polynomial();
        Polynomial r=new Polynomial();

        p.addTerm(3,4);p.addTerm(7,6);p.addTerm(-2,2);
        q.addTerm(4,5);q.addTerm(9,4);q.addTerm(3,2);
        System.out.print("p ");
        p.print();
        System.out.print("q ");
        q.print();

        System.out.println();
        System.out.println("다항식 p 에서 지수가 4인 항의 계수 : "+p.coef(4));
        System.out.println("다항식 p 에서 최고 차항 : "+p.maxExp());
        if(p.isPzero())
            System.out.println("현재 다항식 p는 존재합니다.");
        else
            System.out.println("현재 다항식 p는 존재하지않습니다.");
        System.out.println();

        p.appendTerm(2,1);
        p.print();
        System.out.println();

        System.out.println("--다항식 p 에서 계수가 1인 항을 제거--");
        p.delTerm(1);
        p.print();
        System.out.println();

        System.out.println("--다항식 p에서 한개의 항과 곱셈 --");
        p=p.sMult(3,4);
        p.print();
        System.out.println();

        System.out.println("--다항식 p와 q의 덧셈--");
        r=p.polyAdd(q);
        r.print();

        System.out.println("--다항식 p와 q의 곱셈--");
        r=p.polyMult(q);
        r.print();

    }
}
