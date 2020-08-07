/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Map<Integer, int[]> hmap = new HashMap<>();
        hmap.put(root.val, new int[] {0, 0});
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            int[] coordinate = hmap.get(temp.val);
            
            if(temp.left != null)
            {
                int[] leftCoordinate = new int[2];
                leftCoordinate[0] = coordinate[0] - 1;
                leftCoordinate[1] = coordinate[1] + 1;
                queue.add(temp.left);
                hmap.put(temp.left.val, leftCoordinate);
            }
            if(temp.right != null)
            {
                int[] rightCoordinate = new int[2];
                rightCoordinate[0] = coordinate[0] + 1;
                rightCoordinate[1] = coordinate[1] + 1;
                queue.add(temp.right);
                hmap.put(temp.right.val, rightCoordinate);
            }
            // System.out.println("A");
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int maxRight = 0;
        int maxLeft = 0;
        
        for(Integer temp: hmap.keySet())
        {
            if(hmap.get(temp)[0] > maxRight){
                maxRight = hmap.get(temp)[0];
            }
            if(hmap.get(temp)[0] < maxLeft){
                maxLeft = hmap.get(temp)[0];
            }
        }
        
        
        for(int i = maxLeft; i <= maxRight; i++)
        {
            ans.add(new ArrayList<Integer>());
        }
        
        
        for(Integer temp: hmap.keySet())
        {
            ans.get(hmap.get(temp)[0] - maxLeft).add(temp);
            
            // System.out.println(temp + " " + hmap.get(temp)[0]);
        }
        
        for(List<Integer> subList: ans)
        {
            Collections.sort(subList, 
                             (a, b) -> hmap.get(a)[1] - hmap.get(b)[1]
                            );
        }
        
        return ans;
    }
}


