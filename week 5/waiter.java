import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
public class waiter {
   public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        Stack <Integer> stack1 = new Stack<>();
        Queue <Integer> queue2 = new ArrayDeque<>();
        Stack <Integer> stack3 = new Stack<>();
        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            stack1.push(x);
        }
        int[] prime = new int[q];
        ArrayList <Integer> answer = new ArrayList<>();
        int cnt = 0 ;
        for (int i = 2; i <= 100000 ; i ++){
            boolean check = true;
            for ( int j = 2 ; j <= Math.sqrt(i) ; j ++){
                if ( i % j == 0 ) {
                    check = false;
                    break;
                }
            }
            if ( check) {
                prime[cnt] = i;
                cnt ++;
            }
            if ( cnt == q) break;
        }
        for ( int i = 0 ; i < q ; i ++){
            while (!stack1.isEmpty()){
                int x = stack1.pop();
                if ( x % prime[i] == 0) stack3.push(x);
                else queue2.add(x);
            }
            while (!stack3.isEmpty()) {
                int x= stack3.pop();
                answer.add(x);
            }
            while (!queue2.isEmpty()) {
                int x = queue2.poll();
                stack1.push(x);
            }
        }
        for ( int x : answer) {
            System.out.println (x);
        }
        while ( !stack1.isEmpty()) {
            System.out.println (stack1.pop());
        }
        sc.close();
   } 
}