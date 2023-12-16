import java.util.Scanner;
import java.util.Stack;

public class Simple_text {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack <String> stack = new Stack<>();
        String text = "";
        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            if ( x == 1){
                String s = sc.next();
                stack.add(text);
                text += s;
            }
            else if ( x == 2){
                int k = sc.nextInt();
                stack.add(text);
                text = text.substring (0 , text.length() - k);
            }
            else if ( x == 3){
                int k = sc.nextInt();
                System.out.println (text.charAt(k-1));
            }
            else if ( x == 4){
                String s = stack.pop();
                text = s;
            }
        }
        sc.close();
    }    
}