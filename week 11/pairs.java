// package week 10;
import java.util.Scanner; 
import java.util.Map;
import java.util.HashMap;
public class pairs {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Map <Integer, Integer> mp = new HashMap<>() ;
        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            int value = mp.getOrDefault(x,0);
            mp.put(x, value+1);
        }
        int cnt = 0;
        for ( int x : mp.keySet()){
            if ( mp.containsKey(x-k)) cnt += mp.get(x) * mp.get(x-k);
        }
        System.out.println (cnt);
        sc.close();
    }
}
