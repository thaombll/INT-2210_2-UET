import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class two_sum{
    public static void main(String[] args) {
        int[] arr = new int[1000];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0 ; i < n ; i ++) {
            arr[i] = sc.nextInt();
            int value = map.containsKey(arr[i]) ? map.get(arr[i]) : 0;
            map.put(arr[i], value + 1);
        }
        int cnt = 0 ;
        for (Integer key : map.keySet()){
            int key1 = - key;
            if ( map.get(key) != 0 ){
                if ( key == 0 ) {
                    if (map.get(key) > 1) {
                        cnt ++;
                        map.put(key,0);
                    }
                }
                else{
                 if ( map.containsKey(key1)) {
                    cnt ++;
                    map.put(key1,0);
                }
            }
        }
        }
        System.out.println (cnt);
        sc.close();
    }
}

