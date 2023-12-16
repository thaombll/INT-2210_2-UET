import java.util.Scanner;
public class settingUF {
    public static int[] parent = new int[1000];
    public static int[] size = new int[1000];
    public void init (int u){
        parent[u] = u;
        size[u] = 1;
    }
    public int find_root (int u){
        if ( parent[u] == u) return u;
        return parent[u] = find_root(parent[u]);
    }
    public boolean set_union (int u , int v){
        u = find_root(u);
        v = find_root(v);
        if ( u == v) return false;
        if ( u != v) {
            if ( size[u] < size[v]){
                int temp = size[u];
                size[u] = size[v];
                size[v] = temp;
            }
            size[u] += size[v];
            parent[v] = u;
        }
        return true;
    }
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        settingUF union = new settingUF();
        for ( int i = 0 ; i <= n ; i ++){
            union.init(i);
        }
        // int m = sc.nextInt();
        int n0 = n + 1;
        // for ( int i = 0 ; i < m ; i ++){
            while ( sc.hasNextInt()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (union.set_union(x,y))
            n0 --;
        }
        System.out.println (n0);
        sc.close();
    }
}
