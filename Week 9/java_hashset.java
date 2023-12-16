import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class java_hashset {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map <String, Integer> map = new HashMap<>();
        for ( int i = 0 ; i < n ; i ++){
            String a = sc.nextLine();
            if ( map.containsKey(a)) map.put(a,map.get(a ) + 1);
            else map.put(a,1);
            System.out.println ( map.size());
        }
        sc.close();
    }
}
