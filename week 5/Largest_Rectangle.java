import java.util.Scanner;
public class Largest_Rectangle {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        int input[] = new int[n];
        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            input[i] = x;
        }
        int max = Integer.MIN_VALUE;
        for ( int i = n ; i >= 1 ; i --){
            int j = 0;
            while ( i + j <= n){
                int min = Integer.MAX_VALUE;
                for ( int k = j ; k < i +j; k ++){
                    if ( input[k] < min) min = input[k];
                }
                int area = min *  i ;
                if ( max < area) max = area;
                j ++;
            }
        }
        System.out.println (max);
        sc.close();
    }
}
