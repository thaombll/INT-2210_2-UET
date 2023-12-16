package Sort;
import java.util.Scanner;
public class insertion2 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for ( int i = 0 ; i < n ; i ++){
            a[i] = sc.nextInt();
        }
        for ( int i = 1 ; i < n ; i ++){
            int x = a[i];
            int index = i - 1;
            while ( index >= 0 && a[index] > x){
                a[index+1] = a[index];
                index --;
            }
            a[index+1] = x;
            for (int j = 0 ; j < n ; j ++)
                System.out.print (a[j] + " ");
            System.out.println();
        }
        sc.close();
    }
}
