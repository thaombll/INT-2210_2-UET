import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Map_java {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        Map <String,String> map = new HashMap<>();
        sc.nextLine();
        for ( int i = 0 ; i < n ; i ++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            map.put(a, b);
            // System.out.println ( a + " " + b);
        }
        while ( sc.hasNext()){
            String x = sc.nextLine();
            String y = map.get(x);
            if ( y != null) {
                System.out.println ( x + "=" + y);
            }
            else System.out.println ( "Not found");
        }
        sc.close();
    }
}
