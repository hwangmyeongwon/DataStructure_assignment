class Point{//시험
    int x;
    int y;
    Point(){
        x=0;
        y=0;
    }
    Point(int x1,int y1){
        x=x1;
        y=y1;
    }
}

public class practice {
    public static void main(String[] args) {
        Point p1=new Point();
        Point p2=new Point(0,8);
        p1=p2;
        p1.x=10;
        p2.y=20;

        System.out.println(p1.x);
        System.out.println(p1.y);
        System.out.println(p2.x);
        System.out.println(p2.y);
    }
}
