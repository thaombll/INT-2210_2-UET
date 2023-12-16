package Sort;
import java.util.Scanner;
public class correct {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            a[i] = x;
        }
        for ( int i = 1 ; i < n  ; i ++){
            int index = i - 1;
            int x = a[i];
            while ( index >= 0 && x < a[index]) {
                a[index+1] = a[index];
                index --;
            }
            a[index+1] = x;
        }
        for ( int i = 0 ; i < n ; i ++) {
            System.out.print (a[i] + " ");
        }
        sc.close();
    }
}


