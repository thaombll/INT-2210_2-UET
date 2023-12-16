import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;
public class two_stack {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue <Integer> queue = new ArrayDeque<>();
        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            if ( x == 1){
                int a = sc.nextInt();
                queue.add(a);
            }
            else if ( x == 2){
                queue.poll();
            }
            else if ( x == 3){
                System.out.println (queue.peek());
            }
        }
        sc.close();
    }
}

// peek() : lay phan tu dau 
// poll() : xoa phan tu dau
// add : them phan tu vao cuoi