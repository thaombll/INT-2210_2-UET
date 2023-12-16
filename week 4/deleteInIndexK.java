package link_list;

import java.util.Scanner;
public class deleteInIndexK {
    public static class Node {
        Integer data;
        Node next;
        public Node(Integer data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public static class LinkList {
        private Node list ;
        public LinkList(){
            this.list = null;
        }
        private Node appendRC (Integer data, Node list){
            if ( list == null) return new Node (data, null);
            list.next = appendRC(data, list.next);
            return list;
        }
        public void append (Integer data){
            list = appendRC(data, list);
        }
        public void println (){
            while ( list.next != null){
                System.out.println (list.data);
                list = list.next;
            }
            System.out.println (list.data);
        }
        public void delete( Integer k){
            list = deleteInIndexK( list,k);
        }
        private Node deleteInIndexK( Node list, Integer k){
            if ( k == 0) return list.next;
            int cnt = 0 ;
            Node curr = list;
            while ( cnt < k-1){
                curr = curr.next;
                cnt ++;
            }
            Node cat = curr.next.next;
            curr.next = cat;
            return list;
        }
    }
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        LinkList list = new LinkList();
        for ( int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            list.append(x);
        }
        int k = sc.nextInt();
        list.delete(k);
        list.println();
        sc.close();
    }
}
