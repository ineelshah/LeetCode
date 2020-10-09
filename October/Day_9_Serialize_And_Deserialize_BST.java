/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        serializePreorder(root, sb);
        // System.out.println(sb.toString());
        return sb.toString();
                
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.length() == 0)
            return null;
        
        String[] nodes = data.split(" ");
        
        int[] nums = new int[nodes.length];
        
        int i = 0;
        
        for(String node: nodes) {
            nums[i++] = Integer.valueOf(node);
        }
        
        int[] init_cursor = new int[1];
        init_cursor[0] = 0;
        
        return create(nums, init_cursor, Integer.MAX_VALUE);
    }
    
    private void serializePreorder(TreeNode root, StringBuilder sb) {
        
        if(root == null) return;
        sb.append(root.val + " ");
        serializePreorder(root.left, sb);
        serializePreorder(root.right, sb);
        
    }
    
   
    public TreeNode create(int[] preorder, int[] cursor, int constraint) {
        // create New Node
        // [8]
        TreeNode node = new TreeNode(preorder[cursor[0]]);
        
        // Increment counter to visit the next index in the array
        cursor[0]++;
        
        // left node? Check for 2 things, 1. If the current index is valid, i.e. less than the input array length
        // and 2. if current element under consideration, i.e. child of the node created above, is less than the         // parent node value (represented by node.val)
        if (cursor[0] < preorder.length && preorder[cursor[0]] < node.val)
        {
            node.left = create(preorder, cursor, node.val); // constraint is the parent node value
        }
        
        // right node? Check for 2 things, 1. If the current index is valid, i.e. less than the input array length
        // and  2. if current element under consideration, i.e. child of the node created above, is less than the
        // constraint, which is the value of the parent node, basically the root node.
        if (cursor[0] < preorder.length && preorder[cursor[0]] < constraint)
        {
            node.right = create(preorder, cursor, constraint);
        }
        
        return node;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;