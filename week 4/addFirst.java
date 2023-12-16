package link_list;

import java.util.Scanner;
public class addFirst {
    public static class Node {
        Integer data;
        Node next;
        public Node(Integer data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public static class LinkList {
        private Node list;
        public LinkList(){
            this.list = null;
        }
        public void add ( Integer data){
            list = addnonRC(data, list);
        }
        private Node addnonRC (Integer data, Node list){
            if ( list == null) return new Node (data, null);
            Node newNode = new Node (data, null);
            Node oldlist = list;
            newNode.next = oldlist;
            list = newNode;
            return list;
        }
        public void println (){
            while ( list.next != null) {
                System.out.println ( list.data);
                list = list.next;
            }
            System.out.println ( list.data);
        }
    }
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        LinkList list = new LinkList();
        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            list.add(x);
        }
        list.println();
        sc.close();
    }
}
