// n > 20
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class n_Sum {
    public static void main ( String[] args)
    {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for ( int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
        Map <Integer, Integer> mp1 = new HashMap<>();
        Map <Integer, Integer> mp2 = new HashMap<>();
        mp1.put (0,1);
        mp2.put ( 0,1);
        int x = n/2;
        for ( int state = 1 ; state < (1 << x) ; state ++){
            int sum1 = 0;
            for ( int i = 0 ; i < x ; i ++) {
                if ((state & (1 << i)) != 0 ) sum1 += arr[i];
            }
            int currentValue1 = mp1.getOrDefault (sum1, 0);
            mp1.put (sum1, currentValue1 +1 );
        }
        Set<Integer> key1 = mp1.keySet();
        // for ( Integer key : key1) System.out.println ( key + " " + mp1.get(key));
        for ( int state = 1 ; state < ( 1 << (n - x)) ; state ++){
            int sum2 = 0 ;
            for ( int i = 0 ; i < n - x ; i ++){
                if ( (state & (1 << i)) != 0 ) sum2 += arr[i + x];
            }
            int currentValue2 = mp2.getOrDefault (sum2, 0);
            mp2.put ( sum2, currentValue2 +1);
        }
        Set<Integer> key2 = mp2.keySet();
        // for ( Integer key : key2) System.out.println ( key + " " + mp2.get(key));
        int cnt = 0;
        for ( Integer k1 : key1) {
            for (Integer k2 : key2){
                if ( k1 + k2 == 0){
                    if ( k1 != 0 && k2 != 0) cnt += mp1.get(k1) * mp2.get (k2);
                    else {
                        if ( mp1.get(k1) > 1 && mp2.get(k2) == 1) cnt += mp1.get(k1) -1;
                        else if ( mp1.get(k1) == 1 && mp2.get(k2) > 1) cnt += mp2.get(k2) -1;
                        else if ( mp1.get(k1) > 1 && mp2.get(k2) > 1) cnt += mp1.get(k1) * mp2.get (k2)-1;
                    }
                }
            }
        }
        System.out.println (cnt);
        sc.close();
    }
}
