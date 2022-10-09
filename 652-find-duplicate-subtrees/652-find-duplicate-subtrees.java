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
    HashMap<String,Integer> counter = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root==null)
            return ans;
        inOrder(root);
            
            
    return ans;
    }
    
    String inOrder(TreeNode root)
    {
        if(root==null)
        {
          return "X";
        }
        
        String left= inOrder(root.left);
        String right= inOrder(root.right);
        
        String cur=left+","+right+","+root.val;
        counter.put(cur, counter.getOrDefault(cur, 0) + 1);
        //System.out.println(cur);
        if (counter.get(cur) == 2) {
            ans.add(root);
        }
        return cur;
            
    }
}