// package link_list;
// public class SingleLinkedList {
//     Node head = null;
//     public class Node { // innner class
//         String data;
//         Node next;
    
//         public Node( String data, Node next){
//             this.data = data;
//             this.next = next;
//         }
//     }   
//     private Node append ( String data, Node node){
//         if ( node == null) return new Node ( data,null);
//         node.next = append ( data, node.next);
//         return node;
//     }
//     // khong dung de quy
//     private void removeFirst_NonRecursive (String data){
//         Node node = head;
//         if ( head == null) return ;
//         if ( head.data.equals(data)) head = head.next;
//         else
//         {
//             while (node.next!= null && !node.next.data.equals(data))
//             if ( node.next!=null)
//                 node = node.next;

//                 node.next = node.next.next; 
//         }
//     }
//     // dung de quy
//     public void removeFirst ( String data){
//         head = removeFirst(data, head);
//     }

//     private Node removeFirst ( String data, Node node){
//         if ( node == null) return null;
//         else {
//             if ( node.data.equals(data)) return node.next;
//             node.next = removeFirst ( data, node.next);
//             return node;
//         }
//     }
    
//     public String toString (){
//         return "[" + toString(head) +"]";
//     }

//     private String toString (Node node){
//         if (node == null) return "";
//         return node.data + " " + toString (node.next);
//     }
//     public static void main ( String[] args){

//     }
// }