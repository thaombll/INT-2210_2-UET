
import java.util.Scanner;
public class JavaStringReverse {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = new StringBuffer(a).reverse().toString();
        if ( a.equals(b)) System.out.println("Yes");
        else System.out.println("No");
        sc.close();
    }
}
