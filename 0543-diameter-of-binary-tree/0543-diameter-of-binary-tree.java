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
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root==null) return 0;
        
         getDiameter(root);
        return ans;
        
    }
    
    
    public int getDiameter(TreeNode root)
    {
        if(root==null) return 0;
        
        
        int leftDiam = getDiameter(root.left);
        int rightDiam = getDiameter(root.right);
        
        int curAns= leftDiam+rightDiam ;
        ans= Math.max(curAns,ans);
        return Math.max(leftDiam, rightDiam)+1;
        
    }
}
