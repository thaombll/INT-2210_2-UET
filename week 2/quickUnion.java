// package union_find;
import java.util.Scanner;
public class quickUnion{
   public static int[] root = new int[1000] ;
    public static int find_root (int x)
    {
        return root[x];
    }
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int n0 = n ;
        for ( int i = 1 ; i <= n ; i++)
        {
            root[i] = i ;
        }
        for ( int i = 1 ; i <= m ; i ++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int dx = find_root(x);
            int dy = find_root(y);
            if ( dx != dy)
            {
                for ( int j = 1 ; j <= n ; j++)
                {
                    if ( root[j] == dy) {
                        root[j] = dx;
                    }
                }
                n0--;
            }
        }
        scanner.close();
    }
}