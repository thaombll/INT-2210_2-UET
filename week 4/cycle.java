package link_list;
import java.util.Scanner;
public class cycle {
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
        int n = sc.nextInt();
        LinkList list1 = new LinkList();
        for ( int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            list1.append(x);
        }
        boolean check = false;
        Node fast = list1.list, slow = list1.list;
        while ( fast != null){
            if ( fast == slow) {
                check = true;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if ( check ) System.out.println (1);
        else System.out.println (0);
        sc.close();
    }
}
