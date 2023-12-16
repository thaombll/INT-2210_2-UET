// n <= 20

import java.util.Scanner;

public class nSum {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner ( System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for ( int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();
        int count = 0 ;
        for ( int state = 1 ; state < (1<<n) ; state ++ )
        {
            int target_sum  = 0 ;
            for ( int i = 0 ; i < n ; i ++){
                if ( (state & (1<<i)) != 0) target_sum += arr[i];
            }
            if ( target_sum == 0 ) count ++;
        }
        System.out.println ( count);
        sc.close();
    }
}