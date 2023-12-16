// package union_find;
import java.util.Scanner;

public class bai2 {
    public static int[] root = new int[1000];

    public static int find_root(int v, int[] root) {
            if ( root[v] == v ) return v ;
            return find_root(root[v] , root);
    }
    
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        
        for (int i = 0; i <= 5; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            
            int root_x = find_root(x,root);
            int root_y = find_root(y,root);
            if (root_x != root_y) {
                root[root_y] = root_x;
                n--;
            }
        }
        System.out.println(n);
        sc.close();
    }
}
