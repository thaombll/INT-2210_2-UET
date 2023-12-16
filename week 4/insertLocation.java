// package link_list;

import java.util.Scanner;
public class insertLocation {
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
        public void insert(Integer data, Integer k){
            list = inserInIndexK(data, list,k);
        }
        private Node inserInIndexK(Integer data, Node list, Integer k){
            if ( list == null) return new Node(data, null);
            Node newNode = new Node(data,null);
            int cnt = 0 ;
            Node curr = list;
            while ( cnt < k-1){
                curr = curr.next;
                cnt ++;
            }
            Node cat = curr.next;
            curr.next = newNode;
            newNode.next = cat;
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
        int x = sc.nextInt();
        int k = sc.nextInt();
        list.insert(x,k);
        list.println();
        sc.close();
    }
    
}
