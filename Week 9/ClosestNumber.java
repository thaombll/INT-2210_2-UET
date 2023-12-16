import java.util.Scanner;
import java.util.Arrays;
public class ClosestNumber {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for ( int i = 0 ; i < n ; i ++) a[i] = sc.nextInt();
        Arrays.sort(a);
        int max = 100000001;
        for ( int i = 0 ; i < n - 1 ; i ++){
            int curr = a[i+1] - a[i];
            if ( curr < max) max = curr;
        }
        for ( int i = 0 ; i < n - 1 ; i ++){
            if ( a[i+1] - a[i] == max) System.out.print ( a[i] + " " + a[i+1] + " ");
        }
        sc.close();
    }
}