// 7 7 20
// 4 4 4 4 4 5 5
// 8 1 1 1 1 8 5
/*
B1: chi su dung ngan xep 1 : 
4 4 4 4 4 => step = count1 + count2 = 5 + 0 = 5
B2: lay phan tu dau tien cua stack2
sum = 20 + 8 = 28 
4 4 4 4 4 8
=> count1 = 5 ; count2 = 1;
=> Bo phan tu cuoi cung cua stack1 cho den khi vua voi phan tu dau tien cua stack2 hoac stack1 trong
sum = 28 - 4 = 24
=> count1 = 4 , count2 = 1
sum = 24 -4 = 20
count1 = 3 , count2 = 1
4 4 4 8
=> step = 4 < 5 => step = 5
B3: lay tiep phan tu tiep theo cua stack2
sum = 20+ 1 = 21
=> count1 = 3 , count2 = 2
sum = 21 - 4 = 17
count1 = 2, count2 = 2
sum = 16 + 1 = 18
count1 = 2 , count2 = 3
=> step = 5
sum = 17 + 1 = 19
count1 = 2 , count2 = 4
=> step = 6
sum = 19 + 1 = 20
count1 = 2 , count2 = 5
=> step = 7
sum = 20 + 8 = 28
=> step = 7
B4: bo tiep stack1
sum = 20 + 8 =28
count1 = 2 , count2 = 6
sum = sum - 4 = 24
count1 = 1 , count2 = 6
sum = sum -4 = 20
count1 = 0 , count2 = 6 => step = 6 
=> step = 7
 */

 import java.util.Scanner;
 import java.util.Queue;
 import java.util.ArrayDeque;
 import java.util.Stack;

 public class GameOfTwoStack {
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        int g = sc.nextInt();
        for ( int i = 0 ; i < g ; i ++) {
            Queue <Integer> queue1 = new ArrayDeque<>();
            Queue <Integer> queue2 = new ArrayDeque<>();
            Stack <Integer> stack = new Stack<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int maxSum = sc.nextInt();
            int sum = 0 ;
            int step1 = 0 ;
            int step2 = 0 ;
            for ( int j = 0 ; j < n ; j ++) {
                int x = sc.nextInt();
                queue1.add(x);
            }
            while ( !queue1.isEmpty() && sum + queue1.peek() <= maxSum){
                step1 ++;
                sum += queue1.peek();
                stack.push(queue1.poll());
            }
            for ( int j = 0 ; j < m ; j ++) {
                queue2.add(sc.nextInt());
            }
            while (!queue2.isEmpty() && sum + queue2.peek() <= maxSum){
                sum += queue2.poll();
                step2++;
            }
            int count = step1 + step2;
            while ( !stack.isEmpty()){
                if ( queue2.isEmpty()) break;
                step1 --;
                sum -= stack.pop();
                while (!queue2.isEmpty() && sum + queue2.peek() <= maxSum) {
                    sum+= queue2.poll();
                    step2++;
                }
                if ( step1 + step2 > count) count = step1 + step2;
            }
            System.out.println (count);
        }
        sc.close();
    }
 }