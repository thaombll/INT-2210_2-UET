package link_list;

import java.util.Scanner;
public class getValue {
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
            for ( int j = 0 ; j < n ; j ++){
                int x = sc.nextInt();
                list1.append(x);
            }
            int k = sc.nextInt();
            int index = n - k;
            int cnt = 1;
            Node a = list1.list;
            while (a != null) {
                if ( cnt == index){
                System.out.println (a.data);
                break;
                }
                cnt ++;
                a =a .next;
            }
        }
        sc.close();
    }
}

