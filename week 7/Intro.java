import java.util.Scanner;
public class Intro {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        int [] a = new int[n];
        int cnt = 0 ;
        for ( int i = 0 ; i < n ; i ++){
            a[i] = sc.nextInt();
            if ( a[i] == v) cnt = i;
        }
        System.out.println (cnt);
    }
}