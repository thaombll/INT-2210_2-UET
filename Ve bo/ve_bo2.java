import java.util.Scanner;
import java.util.PriorityQueue;

public class ve_bo2 {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in); 
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n+1];
        for ( int i = 1 ; i <= n ; i ++){
            a[i] = sc.nextInt();
        }
        long sum = 0 ;
        PriorityQueue <Integer> queue = new PriorityQueue<>();
        for ( int i = 1 ; i <= k ; i ++){
            sum += a[i];
            queue.add(a[i]);
            System.out.print (sum + " ");
        }
        for ( int i = k + 1 ; i <= n ; i ++){
            queue.add(a[i]);
            sum = sum + a[i] - queue.poll();
            System.out.print(sum + " ");
        }
        sc.close();
    }
}