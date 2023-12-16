import java.util.Scanner;
public class weighted {
    // package union_find;

    public static int[] root = new int[1000];

    public static int find_root(int v) {
        if ( root[v] < 0) return v ;
        return root[v];
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n0 = n ;
        int res = 0 ;
        for (int i = 0; i < n; i++) {
            root[i] = -1;
        }
        
        while ( sc.hasNextInt()) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            if ( n0 > 1 )
            {
                int root_x = find_root(x);
                int root_y = find_root(y);
            
                if (root_x != root_y) {
                    if ( root[root_x] < root[root_y]){
                        int temp = root_x;
                        root_x= root_y;
                        root_y = temp;
                    }
                    root[root_y] += root[root_x];
                    root[root_x] = root_y ;
                    for ( int j = 0 ; j < n ; j ++){
                        if ( root[j] == root_x) root[j] = root_y ;
                    }
                    n0--;
                }
                res++;
            }
        }
        if ( n0 == 1)
            System.out.println( res);
        else 
            System.out.println ("FAILED");
        sc.close();
    }
}
