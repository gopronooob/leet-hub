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
        
        if(root==null)return 0;
        
       solve(root);        
        return ans;
    }
    
    int solve (TreeNode root) {
         if(root==null)
             return 0;
        
        int leftVal=solve(root.left); 
        int rightVal=solve(root.right);
        
        ans=Math.max(ans,leftVal+rightVal);
        
        return(Math.max(leftVal,rightVal)+1);
    }
    
    
}