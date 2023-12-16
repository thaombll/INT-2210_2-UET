import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;
public class impove_vb1 {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        PriorityQueue <Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue <Integer> q2 = new PriorityQueue<>();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        for ( int i = 0 ; i < n ; i ++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int x = n/2;
        for ( int i = 0 ; i < x ; i ++){
            q1.add(a[i]);
        }
        for ( int i = x ; i < n ; i ++){
            q2.add(a[i]);
        }
        for (int i = 0 ; i < q ; i ++){
            int k = sc.nextInt();
            int len1 = q1.size();
            int len2 = q2.size();
            if ( k == 1){
                int y = sc.nextInt();
                if ( len1 == len2){
                    if ( y >= q1.peek()) q2.add(y);
                    else {
                        int temp = q1.poll();
                        q2.add(temp);
                        q1.add(y);
                    }
                }
                else{
                    if ( y > q2.peek()) {
                        int temp = q2.poll();
                        q1.add(temp);
                        q2.add(y);
                    }
                    else q1.add(y);
                }
            }
            if ( k == 2 ){
                if ( len1 == len2 ) q1.poll();
                else 
                q2.poll();
            }
            if ( k == 3){
                if (len1 == len2) {
                    if (!q1.isEmpty())
                        System.out.println(q1.peek());
                    else 
                        System.out.println (0);
                }
                else if ( len1 != len2)
                System.out.println(q2.peek());
            }
        }
        sc.close();
    }
}