package Sort;
import java.util.Scanner;
public class countingSort {
    public static int[] a = new int[101];
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        for ( int i = 0 ; i <= 100 ; i ++){
            a[i] = 0;
        }
        int n = sc.nextInt();
        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            a[x] ++ ;
        }
        for ( int i = 0 ; i < 100; i ++){
            System.out.print (a[i] + " ");
        }
        sc.close();
    }

}
