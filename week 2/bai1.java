// package union_find;
import java.util.Scanner;

public class bai1 {
    public static int[] root = new int[1000];

    public static int find_root(int v) {
            return root[v];
    }
    
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n0 = n ;
        int m = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            
            int root_x = find_root(x);
            int root_y = find_root(y);
           
            
            if (root_x != root_y) {
                for ( int k = 0 ; k < n ; k++)
                {
                    if ( root[k] == root_y)
                    root[k] = root_x;
                   
                }
                n0--;
            }
        }
        System.out.println(n0);
        sc.close();
    }
}