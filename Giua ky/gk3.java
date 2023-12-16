import java.util.Scanner;

public class gk3 {
    public static int queue[] = new int[1000005];
    public static int top;
    public static int bottom;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        top = 0;
        bottom = 0;
        int cnt = 1;
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            if(a == 1){
                queue[bottom] = cnt;
                cnt++;
                bottom++;
            }
            else if(a == 2) {
                if (bottom > top) {
                    System.out.println(queue[top]);
                    top++;
                }
                else {
                    System.out.println(0);
                }
            } 
            else if(a == 3) {
                if (bottom > top) {
                    System.out.println(queue[bottom - 1]);
                    bottom--;
                } 
                else {
                    System.out.println(0);
                }
            }
            else if(a == 4) {
                System.out.println(bottom - top);
            }
            else if(a == 5) {
                int u = sc.nextInt();
                if(u <= bottom - top && u > 0) {
                    System.out.println(queue[top + u - 1]);
                } 
                else {
                    System.out.println(0);
                }
            }
        }
    }
}