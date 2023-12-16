import java.util.Scanner;

public class gk1 {
    public static int[] parent = new int[1000001];
    public static int[] size = new int[1000001];
    public static int[] d = new int[1000001];
    public static int max = Integer.MIN_VALUE;
    public void init(int u) {
        parent[u] = u;
        size[u] = 1;
    }

    public int find_root(int u) {
        if (parent[u] == u) return u;
        return parent[u] = find_root(parent[u]);
    }

    public boolean set_union(int u, int v) {
        u = find_root(u);
        v = find_root(v);
        if (u == v) return false;
        if (u != v) {
            if (size[u] < size[v]) {
                int temp = size[u];
                size[u] = size[v];
                size[v] = temp;
            }
            size[u] += size[v];
            parent[v] = u;
        }
        return true;
    }

    public int getSize(int u) {
        return size[find_root(u)];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gk1 test = new gk1();
        int n = sc.nextInt();
        int q = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            test.init(i);
        }

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            if (x == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                test.set_union(a, b);
            } else if (x == 3) {
                int u = sc.nextInt();
                System.out.println(test.getSize(u));
            } else if (x == 2) {
                int cnt = 0;
                for (int j = 1; j <= n; j++) {
                    if (d[test.find_root(j)] == 0) {
                        d[test.find_root(j)] = 1;
                        cnt++;
                    }
                }
                System.out.println(cnt);
                // Reset the d array after processing the query
                for (int j = 1; j <= n; j++) {
                    d[j] = 0;
                }
            } else if (x == 4) {
                for (int j = 1; j <= n; j++) {
                    if (test.getSize(j) > max) max = test.getSize(j);
                }
                System.out.println(max);
            }
        }

        sc.close();
    }
}
    // https://www.hackerrank.com/contests/gknhom1/challenges