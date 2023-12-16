// package link_list;
import java.util.Scanner;
public class merge {
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
            int n = sc.nextInt();
            LinkList list1 = new LinkList();
            LinkList list2 = new LinkList();
            for ( int j = 0 ; j < n ; j ++){
                int x = sc.nextInt();
                list1.append(x);
            }
            int m = sc.nextInt();
            for ( int j = 0 ; j < m ; j ++){
                int x = sc.nextInt();
                list2.append(x);
            }
            Node a = list1.list;
            Node b = list2.list;
            while ( a != null || b != null) {
                if ( a == null || ( b != null && b.data <= a.data)){
                    System.out.print ( b.data + " ");
                    b = b.next;
                }
                else {
                    System.out.print (a.data + " ");
                    a= a.next;
                }
            }
            System.out.println ();
        }
        sc.close();
    }
}
