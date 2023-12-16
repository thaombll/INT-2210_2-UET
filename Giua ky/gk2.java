import java.util.Scanner;
public class gk2 {
    public static class Queue {
        int [] queue = new int [1000000];
        int top = 1;
        int bottom = -1;
        void add (int x){
            queue[++bottom] = x;
        }
        boolean isEmpty(){
            return bottom < top;
        }
        int peek (){
            return queue[top];
        }
        int poll(){
            int y = queue[top];
            queue[top++] = 0;
            return y;
        }
        int size(){
            return bottom +1;
        }
    }
    public static class Stack{
        int[] stack = new int[1000001];
        int top = -1;
        int pop(){
            return stack[top--];
        }
        void push(int x) {
            stack[++top] = x;
        }
        boolean isEmpty(){
            return top ==-1;
        }
        int top(){
            return stack[top];
        }
        int size(){
            return top +1;
        }
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        Stack stack = new Stack();
        Queue queue = new Queue();
        int cnt = 1 ;
        for ( int i = 0 ; i < q ; i ++){
            int x = sc.nextInt();
            if ( x == 1){
                int a = sc.nextInt();
                if ( a == 1) {
                    queue.add(cnt);
                    cnt ++;
                }
                else if ( a == 2){
                    stack.push(cnt);
                    cnt ++;
                }
            }
            else if ( x == 2){
                int a = sc.nextInt();
                if ( a == 1){
                    if (!queue.isEmpty()) queue.poll();
                }
                else if ( a == 2){
                    if ( !stack.isEmpty()) stack.pop();
                }
            }
            else if ( x == 3){
                int a = sc.nextInt();
                if ( a == 1){
                    System.out.println(queue.size());
                }
                else if ( a == 2){
                    System.out.println(stack.size());
                }
            }
            else if ( x == 4){
                int a = queue.size() + stack.size();
                System.out.println (n - a);
            }
            else if ( x == 5){
                int a = sc.nextInt();
                if ( a == 1){
                    int v = sc.nextInt();
                    System.out.println (queue.queue[v]);
                }
                else if ( a == 2){
                    int v = sc.nextInt();
                    System.out.println (stack.stack[n-v]);
                }
            }
        }

    }
}
