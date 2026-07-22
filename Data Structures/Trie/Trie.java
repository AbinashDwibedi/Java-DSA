
import java.util.HashMap;

class Node{
    boolean isEnd;
    HashMap<Character, Node> childrens = new HashMap<>();

    public Node() {
        this.isEnd = false;
    }
    
}
public class Trie{
    private Node root = new Node();
    private boolean deleteHelper(Node node, String word, int depth){
        if(node == null) return false;
        if(depth == word.length()){
            if(!node.isEnd) return false;
            node.isEnd = false;
            return node.childrens.isEmpty();
        }
        char ch = word.charAt(depth);
        boolean isDeletable = deleteHelper(node.childrens.getOrDefault(ch,null), word, depth+1);
        if(isDeletable){
            node.childrens.remove(ch);
            return !node.isEnd && node.childrens.isEmpty();
        }
        return false;
    }
    public void insert(String word){
        Node rootNode = this.root;
        for(char ch: word.toCharArray()){
            if(!rootNode.childrens.containsKey(ch)){
                rootNode.childrens.put(ch, new Node());
            }
            rootNode = rootNode.childrens.get(ch);
        }
        rootNode.isEnd = true;
    }
    public void delete(String word){
       deleteHelper(this.root, word, 0); 
    }
    public boolean search(String word){
        Node rootNode = this.root;
        for(char ch: word.toCharArray()){
            if(!rootNode.childrens.containsKey(ch)){
                return false;
            }
            rootNode = rootNode.childrens.get(ch);
        }
        return rootNode.isEnd;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Abinash");
        trie.insert("WOOOOW");
        System.out.printf("name: Abinash %s\n", trie.search("Abinash")? "exists" : "not exists");
        System.out.printf("name: WOOOOW %s\n", trie.search("Abinas")? "exists" : "not exists");
        trie.delete("Abinash");
        System.out.printf("name: Abinash %s\n", trie.search("Abinash")? "exists" : "not exists");

    }
}