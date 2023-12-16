import java.util.Arrays;
import java.util.Scanner;
public class threeSumBS {
    public static int[] arr = new int[1000];
    int BS ( int a[], int x){
        int l = 0 , r = a.length - 1 ;
        while ( l <= r ){
            int m = l + ( r - l ) /2;
            if (a[m] > x) 
                r = m - 1;
            else if ( a[m] < x) 
                l = m + 1;
            else 
                return m ;
        }
        return -1;
    }
    public static void main ( String args[]){
        threeSumBS ob = new threeSumBS();
        Scanner sc = new Scanner ( System.in);
        int n = sc.nextInt();
        for ( int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int ans = 0;
        for ( int i = 0 ; i < n ; i++){
            int x = arr[i];
            for ( int j = i +1 ; j < n ; j ++){
                if ( ob.BS(arr, x + arr[j]) != -1) ans ++;
            }
        }
        System.out.println ( ans );
        sc.close();
    }
}
