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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) 
            return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty() && q.peek()!=null)
        {
            TreeNode n= q.remove();
            
            q.add(n.left);
            q.add(n.right);
        
        }
        
        while(!q.isEmpty() && q.peek()==null) q.remove();
        return q.isEmpty();
    }
}