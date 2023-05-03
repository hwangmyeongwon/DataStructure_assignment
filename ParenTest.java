import java.io.*;
import java.util.*;

public class Paren {
    public static boolean check(String exp) {
        {
            int len = exp.length();
            int index = 0;
            char       ch;
            char     left;
            while(index < len)
            {
                ch = exp.charAt(index);

                switch(ch)
                {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(Character.toString(ch));
                        break;

                    case ')':
                    {
                        if(stack.IsEmpty())
                            return false;
                        left = ((String)stack.pop()).charAt(0);
                        if(left != '(')
                            return false;
                    }
                    break;
                    case ']':
                    {
                        if(stack.IsEmpty())
                            return false;
                        left = ((String)stack.pop()).charAt(0);
                        if(left != '[')
                            return false;
                    }
                    break;

                    case '}':
                    {
                        if(stack.IsEmpty())
                            return false;


                        left = ((String)stack.pop()).charAt(0);
                        if(left != '{')
                            return false;
                    }
                    break;
                }

                index++;
            }

            if(stack.IsEmpty())
            {
                //System.out.println("Empty");
                return true;
            }
            else
            {
                //System.out.println("NotEmpty");
                return false;
            }
}

public class ParenTest {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String exp = input.nextLine();
        System.out.println(Paren.check(exp));
    }
}
