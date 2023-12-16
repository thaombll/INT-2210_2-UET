// package hackerrank;
import java.util.Scanner;

public class balance {
    public static class Stack {
        char [] stack = new char[1001];
        int top = -1;
        boolean isEmpty(){
            return top == -1;
        }
        char top(){
            return stack[top];
        }
        void push (char x){
            stack[++top] = x;
        }
        char pop (){
            return stack[top--];
        }

    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for ( int i = 0 ; i < n ; i ++){
            String s = sc.next();
            Stack stack = new Stack();
            boolean check = true;
            for (int j = 0 ; j < s.length() ; j ++){
                char c = s.charAt(j);
                if (c == '(' || c =='[' || c == '{'){
                    stack.push(c);
                }
                else {
                    if ( stack.isEmpty()){
                        check = false;
                        break;
                    }
                    if ( c == ')' && stack.top() == '(') stack.pop();
                    else if ( c == '}' && stack.top() == '{') stack.pop();
                    else if ( c == ']' && stack.top() == '[') stack.pop();
                    else {
                        check = false;
                        break;
                    }
                }
            }
            if ( check && stack.isEmpty()) System.out.println ("YES");
            else System.out.println ("NO");
        }
        sc.close();
    }
}