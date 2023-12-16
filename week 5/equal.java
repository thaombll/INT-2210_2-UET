// package hackerrank;
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class equal {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int sum1 = 0 , sum2 = 0 , sum3 = 0 ;
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        Queue <Integer> queue1 = new ArrayDeque<>();
        Queue <Integer> queue2 = new ArrayDeque<>();
        Queue <Integer> queue3 = new ArrayDeque<>();
        for ( int i = 0 ; i < n1 ; i ++) {
            int x = sc.nextInt();
            sum1 += x;
            queue1.add(x);
        }
        for ( int i = 0 ; i < n2 ; i ++) {
            int x = sc.nextInt();
            sum2 += x;
            queue2.add(x);
        }
        for ( int i = 0 ; i < n3 ; i ++) {
            int x = sc.nextInt();
            sum3 += x;
            queue3.add(x);
        }
        while ( !queue1.isEmpty() && !queue2.isEmpty() && !queue3.isEmpty()){
            if ( sum1 == sum2 && sum2 == sum3) {
                System.out.println (sum1);
                return;
            }
            else {
                // peek() : lay phan tu dau
                //  POLL() : LAY PHAN TU cuoi                                                                                                                          
                int max = Math.max (Math.max(sum1, sum2), sum3);
                if ( max == sum1) {
                    int a = queue1.peek();
                    sum1 -= a;
                    queue1.remove(a);
                }
                else if ( max == sum2) {
                    int a = queue2.peek();
                    sum2 -= a;
                    queue2.remove(a);
                }
                else if ( max == sum3) {
                    int a = queue3.peek();
                    sum3 -= a;
                    queue3.remove(a);
                }
            }
        }
        System.out.println (0);
        sc.close();
    }
}
