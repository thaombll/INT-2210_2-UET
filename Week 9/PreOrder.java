public static void PreOrder(Node root) {
    if (root != null) {
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
    }
}
