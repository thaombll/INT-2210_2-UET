package link_list;
import java.util.Scanner;

public class compareTwoLL {
    public static class Node{
        Integer data;
        Node next;
        public Node(Integer data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public static class LinkList{
        private Node list;
        public LinkList(){
            this.list = null;
        }
        public void append(Integer data){
            list = appendRC(data,list);
        }
        private Node appendRC(Integer data, Node list){
            if ( list == null) return new Node(data,null);
            list.next = appendRC(data, list.next);
            return list;
        }
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int q = sc.nextInt();
        for ( int i = 0 ; i < q ; i ++){
            LinkList a = new LinkList();
            LinkList b = new LinkList();
            int n = sc.nextInt();
            for ( int j = 0 ; j < n ; j ++){
                int x = sc.nextInt();
                a.append(x);
            }
            int m = sc.nextInt();
            for ( int j = 0 ; j < m ; j ++){
                int x = sc.nextInt();
                b.append(x);
            }
            if ( m != n) System.out.println (0);
            else {
                Node a1 = a.list;
                Node b1 = b.list;
                boolean check = true;
                while ( a1 != null){
                    if ( a1.data != b1.data) {
                        check = false;
                        break;
                    }
                    a1 = a1.next;
                    b1 = b1.next;
                }
                if ( check ) System.out.println (1);
                else System.out.println (0);
            }
        }
        sc.close();
    }
}
