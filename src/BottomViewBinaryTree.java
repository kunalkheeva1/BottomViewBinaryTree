import java.nio.channels.Pipe;
import java.util.*;

public class BottomViewBinaryTree {


// node
    class Node {
        int data;
        Node left;
        Node right;
        Node(Node left,Node right, int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    // pair to hold the node and the value assign by me
    class Pair{
        int val;
        Node node;
        Pair(Node node, int val){
            this.node = node;
            this.val = val;
        }
    }
    // method, store the values and their data in treemap to maintain the order
    public List<Integer> bottomViewBinaryTree(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        if(root == null) return ans;

        //start with root node
        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair(root, 0);
        q.add(pair);

        // remove the pair from the queue and then increment the right and decrement the left half
        while(!q.isEmpty()){
            Pair pp = q.remove();
            Node current = pp.node;
            int value = pp.val;

            // check for the right and left of the node
            if(current.left != null){
                Pair p1 = new Pair(current.left, value-1);
                q.add(p1);
            }
            if(current.right != null){
                Pair p2 = new Pair(current.right, value+1);
                q.add(p2);
            }
            // and put the data in the map, as map doesnot hold the duplicate keys, which is why
            // the data will get updated with the keys respectively in the map and all we will have is
            // the bottom view of the map
            map.put(value, current.data);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }return ans;

    }


    public static void main(String[] args) {

    }
}
