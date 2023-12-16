
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class find_the_running_median {
    public static void push(PriorityQueue<Integer> q1, PriorityQueue<Integer> q2, int y) {
        int len1 = q1.size();
        int len2 = q2.size();
        if (len1 == len2) {
            if ( q2.isEmpty()) q2.add(y);
            else {
                if (y >= q1.peek()) {
                    q2.add(y);
                } 
                else {
                    int temp = q1.poll();
                    q2.add(temp);
                    q1.add(y);
                }
            }
        } 
        else {
            if (y > q2.peek()) {
                int temp = q2.poll();
                q1.add(temp);
                q2.add(y);
            } 
            else {
                q1.add(y);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            push(q1, q2, x);
            if (q1.size() + 1 == q2.size()) {
                System.out.println(Math.round(q2.peek() * 10.0) / 10.0);
            } else if (q1.size() == q2.size()) {
                System.out.println(Math.round((q2.peek() + q1.peek()) * 10.0) / 20.0);
            }
        }
        sc.close();
    }
}
