// You have an empty sequence, and you will be given  queries. Each query is one of these three types:

// 1 x  -Push the element x into the stack.
// 2    -Delete the element present at the top of the stack.
// 3    -Print the maximum element in the stack.
// Function Description

// Complete the getMax function in the editor below.

// getMax has the following parameters:
// - string operations[n]: operations as strings

// Returns
// - int[]: the answers to each type 3 query

// Input Format

// The first line of input contains an integer, . The next  lines each contain an above mentioned query.

// Constraints

// Constraints



// All queries are valid.

// Sample Input

// STDIN   Function
// -----   --------
// 10      operations[] size n = 10
// 1 97    operations = ['1 97', '2', '1 20', ....]
// 2
// 1 20
// 2
// 1 26
// 1 20
// 2
// 3
// 1 91
// 3
// Sample Output

// 26
// 91

// Solution
// package hackerrank;
import java.util.Scanner;
public class Maximum_Element{
    public static class Stack {
        int[] stack = new int[100001];
        int top = -1;

        boolean isEmpty() {
            return top == -1;
        }

        void push ( int x){
            stack[++top] = x;
        }

        int top(){
            return stack[top];
        }

        int pop(){
            return stack[top--];
        }
        int length(){
            return top +1;
        }
    }
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        Stack stack = new Stack();
        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            if ( x == 1) {
                int a = sc.nextInt();
                stack.push(a);
            }
            else if ( x == 2){
                stack.pop();
            }
            else if ( x == 3){
                int max = 0 ;
                for ( int j = 0 ; j < stack.length() ; j ++){
                    if ( stack.stack[j] > max) max = stack.stack[j];
                }
                System.out.println (max);
            }
        }
        sc.close();
    }
}