import java.nio.channels.Pipe;
import java.util.*;

public class BottomViewBinaryTree {



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
    class Pair{
        int val;
        Node node;
        Pair(Node node, int val){
            this.node = node;
            this.val = val;
        }
    }

    public List<Integer> bottomViewBinaryTree(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        if(root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair(root, 0);
        q.add(pair);

        while(!q.isEmpty()){
            Pair pp = q.remove();
            Node current = pp.node;
            int value = pp.val;
            if(current.left != null){
                Pair p1 = new Pair(current.left, value-1);
                q.add(p1);
            }
            if(current.right != null){
                Pair p2 = new Pair(current.right, value+1);
                q.add(p2);
            }
            map.put(value, current.data);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }return ans;

    }


    public static void main(String[] args) {

    }
}
