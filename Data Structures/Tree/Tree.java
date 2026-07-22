
import java.util.LinkedList;
import java.util.Queue;


class TreeNode<T>{
   public T data;
   public TreeNode<T> left;
   public TreeNode<T> right;  

    public TreeNode(T data) {
        this.data = data;
    }

}

public class Tree<T>{
    private TreeNode<T> root;

    public Tree() {
        root = null;
    }
    
    public void addNode(T value){
        TreeNode<T> newNode = new TreeNode<>(value);
        if(root == null) {
            this.root = newNode;
            return;
        }
        Queue<TreeNode<T>> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode<T> currNode = que.poll();
            if(currNode.left == null){
                currNode.left = newNode;
                return;
            }
            else{
                que.add(currNode.left);
            }
            if(currNode.right == null){
                currNode.right = newNode;
                return;
            }
            else{
                que.add(currNode.right);
                //que.add(currNode.left);
            }
        }
    }
    public void delete( T value){
        if ( root==null) return;
        if(root.left == null && root.right ==null){
            root = null;
            return;
        }
        Queue<TreeNode<T>> que = new LinkedList<>();
        que.add(root);
        TreeNode<T> lastElement = null;
        TreeNode<T> nodeToBeRemoved = null;
        while(!que.isEmpty()){
             lastElement = que.poll();
             if(lastElement.data.equals(value)){
                nodeToBeRemoved = lastElement;
             } 
             if (lastElement.left != null) que.add(lastElement.left);
             if (lastElement.right != null) que.add(lastElement.right);
        }
        if(nodeToBeRemoved != null){
            T val =  lastElement.data;
            nodeToBeRemoved.data = val; 
            deleteLastNode(lastElement);
        }
    }
    private void deleteLastNode(TreeNode<T> lastElement){
        Queue<TreeNode<T>> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            TreeNode<T> temp = que.poll();
            if(temp.left != null){
                if(temp.left == lastElement){
                    temp.left = null;
                    return ;
                }
                else{
                    que.add(temp.left);
                }
            }
            if (temp.right != null){
                if(temp.right == lastElement){
                    temp.right = null;
                }
                else{
                    que.add(temp.right);
                }
            }
        }
    }
    private void inorderHelper(TreeNode<T> node){
        if (node == null) return;
        inorderHelper(node.left);
        System.out.print(node.data+ " -> ");
        inorderHelper(node.right);
    }
    public void inorder(){
       inorderHelper(root); 
        System.out.println(); 
    }
    private void preorderHelper(TreeNode<T> node){
        if (node == null) return;
        preorderHelper(node.left);
        System.out.print(node.data+ " -> ");
        preorderHelper(node.right);
    }
    public void preorder(){
       preorderHelper(root); 
       System.out.println();
    }
    private void postorderHelper(TreeNode<T> node){
        if (node == null) return;
        postorderHelper(node.left);
        System.out.print(node.data+ " -> ");
        postorderHelper(node.right);
    }
    public void postorder(){
       postorderHelper(root); 
       System.out.println();
    }
    //public TreeNode<T> removeNodeHelper(TreeNode<T> node, T value){
    //    if (node == null){
    //        return null;
    //    }
    //    if(node.data == value){
    //        T val = findLastElement(root);
    //        node.data = val;
    //        return node;
    //    }
    //    if(node.left != null){
    //        node.left = removeNodeHelper(node.left, value);
    //    }
    //    if(node.right != null){
    //        node.right = removeNodeHelper(node.right, value);
    //    }
    //    return node;
    //}

    //private T findLastElement(TreeNode<T> node) {
    //    
    //}

public static void main(String[] args) {
    Tree<Integer> tree = new Tree<>();
    tree.addNode(234);
    tree.addNode(53);
    tree.addNode(21223);
    tree.inorder();
    tree.delete(234);
    tree.inorder();
   } 
}
