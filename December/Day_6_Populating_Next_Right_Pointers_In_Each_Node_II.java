/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Node> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                Node temp = queue.poll();
                list.add(temp);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            
            for(int i = 0; i < list.size() - 1; i++) {
                // System.out.println(list.get(i).val + " " + list.get(i + 1).val);
                list.get(i).next = list.get(i + 1);
            }
            
            
        }
        
        
        return root;
        
    }
}