import java.util.Scanner;

class PostFix {
    public static int evalPostFix(String exp) {
        Scanner sc = new Scanner(exp);
        ListStack s = new ListStack();
        int op1,op2;
        int i=0;
        char ch;
        while(sc.hasNext()) {
            if(i==exp.length())
                break;
            ch=exp.charAt(i);
            switch (ch){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    s.push((int)(ch-'0'));
                    break;
                case '+':
                    op2=(int)s.pop();
                    op1=(int)s.pop();
                    s.push(op1+op2);
                    break;
                case '-':
                    op2=(int)s.pop();
                    op1=(int)s.pop();
                    s.push(op1-op2);
                    break;
                case '*':
                    op2=(int)s.pop();
                    op1=(int)s.pop();
                    s.push(op1*op2);
                    break;
                case '/':
                    op2=(int)s.pop();
                    op1=(int)s.pop();
                    s.push(op1/op2);
                    break;
            }
            i++;
        }
        return (int)s.pop();
    }
}

public class PostFixTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String exp = input.nextLine();
        System.out.println(PostFix.evalPostFix(exp));
    }
}
