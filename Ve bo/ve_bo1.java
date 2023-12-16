import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class ve_bo1 {
    public static void push(ArrayList <Integer> l , ArrayList <Integer> r , int x){
        if ( x <= l.get(l.size() - 1)) {
            l.add(x);
            Collections.sort(l);
            if (l.size() > r.size() + 1) {
                int a = l.remove(l.size() - 1) ;
                r.add(a);
                Collections.sort(r);
            }
        }
        else {
            r.add(x);
            Collections.sort(r);
            if (r.size() != l.size()) {
                int a = r.remove(0);
                l.add(a);
                Collections.sort(l);
            }
        }
    }
    public static void delete (ArrayList <Integer> l, ArrayList <Integer> r){
            if (!l.isEmpty())
            l.remove(l.size() - 1);
            if ( l.size() == r.size())
            return;
            if ( !r.isEmpty()){
            int a = r.remove(0);
            l.add(a);
            Collections.sort(l);
            }
    }
    public static void print (ArrayList<Integer> l){
        System.out.println (l.get(l.size() - 1));
    }
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a= new int[n];
        for ( int i = 0 ; i < n ; i ++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        ArrayList <Integer> right = new ArrayList<>();
        ArrayList <Integer> left = new ArrayList<>();
        for ( int i = 0 ; i < n ; i ++){
            if ( n % 2 == 0){
                if ( i < n/2) left.add(a[i]);
                else right.add(a[i]);
            }
            else {
                if ( i <= n /2) left.add(a[i]);
                else right.add(a[i]);
            }
        }
        for ( int i = 0 ; i < q ; i ++){
            int x = sc.nextInt();
            if ( x == 1) {
                int y = sc.nextInt();
                push(left, right, y);
            }
            else if ( x == 2){
                delete (left,right);
            }
            else if ( x == 3){
                print(left);
            }
        }
        sc.close();
    }
}
