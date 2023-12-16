import java.util.Scanner;
public class link {
    // chu ky neu co 1 con tro head va chi dc dung 1 bien
    class Node {
        Integer data;
        Node next;

        public Node ( Integer data , Node next) {
            this.data = data;
            this.next = next;
        }
    }
        public boolean have ( Node head){
            Node slow = head;
            Node fast = head;
            while ( slow != null && fast.next != null && fast != null){
                slow = slow.next;
                fast = fast.next.next;
                if ( fast == slow)
                    return true ;
            }
            return false ;
        }
        public Node append ( Integer data, Node node){
            if ( node == null) return new Node ( data, null);
            node.next = append ( data, node.next);
            return node;

        }
        public static void main (String[] args){
            link Link = new link();
            Scanner sc = new Scanner (System.in);
            int n = sc.nextInt();
            Node list = null;
            for ( int i = 0 ; i < n ; i ++){
                int x= sc.nextInt();
                Link.append ( x , list);
            }
            System.out.println ( Link.have(list));
            sc.close();
        }
    }

