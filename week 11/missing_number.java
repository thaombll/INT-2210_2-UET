// package week 10;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map; 
import java.util.HashMap;
public class missing_number {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> mp1 = new HashMap<>();
        Map<Integer, Integer> mp2 = new HashMap<>();
        ArrayList <Integer> s = new ArrayList<>();
        int n = sc.nextInt();
        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            int value = mp1.getOrDefault(x,0);
            mp1.put(x, value+1);
        }
        int m = sc.nextInt();
        for ( int i = 0 ; i < m ; i ++){
            int x = sc.nextInt();
            int value = mp2.getOrDefault(x,0);
            mp2.put(x, value+1);
        }
        for ( int x : mp2.keySet()) {
            if ( ! mp1.containsKey(x)) s.add(x);
            else {
                if ( mp1.get(x) < mp2.get(x)) s.add(x);
            }
        }
        Collections.sort(s);
        for ( int x : s) System.out.print(x + " ");
        sc.close();
    }
}
