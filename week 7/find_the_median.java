import java.util.Scanner;
import java.util.Arrays;
public class find_the_median {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        for ( int i = 0 ; i < n ; i ++) a[i] = sc.nextInt();
        Arrays.sort(a);
        int x = n/2;
        if ( n % 2 == 1) System.out.println (a[x]);
        else System.out.println (a[x-1]);
    }
}