import java.util.Scanner;
public class quickSort1 {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for ( int i = 0 ; i < n ; i ++) a[i] =sc.nextInt();
        int x = a[0] ;
        for ( int i = 0 ; i < n ; i ++)  
            if ( a[i] < x) System.out.print (a[i]+ " ");
        for ( int i = 0 ; i < n ; i ++)  
            if ( a[i] == x) System.out.print (a[i] + " ");
        for ( int i = 0 ; i < n ; i ++)  
            if ( a[i] > x) System.out.print (a[i] + " ");
    }
}
