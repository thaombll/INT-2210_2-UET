
import java.util.Scanner;
public class InsertionSort {
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];


        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            a[i] = x;
        }


        for ( int i = n - 1 ; i >= 1; i --){
            if ( check(a) == false){
                int x = a[i];
                
                for ( int j = i - 1 ; j >= 0 ; j --){
                    
                    if ( a[j] >= x){
                        a[j+1] = a[j]; 
                        for ( int k = 0 ; k < n ; k ++) System.out.print (a[k] + " " );
                        System.out.println ();
                    }
                    
                    else if ( a[j] < x) {
                        a[j+1] = x;
                        for ( int k = 0 ; k < n ; k ++) System.out.print (a[k] + " "  );
                        System.out.println ();
                        break;
                    }
                    
                }
                
                if ( a[0] == a[1]){ 
                    a[0] = x;
                for ( int k = 0 ; k < n ; k ++) System.out.print (a[k] + " ");
                    System.out.println ();
                }
                
            }
        }


        sc.close();
    }
    public static boolean check(int[] a) {
        for ( int i = 0 ; i < a.length -1; i ++) {
            if ( a[i] > a[ i+ 1]) return false;
        }
        return true;
    }
}







