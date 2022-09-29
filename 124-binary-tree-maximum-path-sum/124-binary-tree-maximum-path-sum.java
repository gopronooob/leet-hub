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
    int ans;
    
    public int maxPathSum(TreeNode root) {
        ans=Integer.MIN_VALUE;
        pathSum(root);
        return ans;
        
    }
    
   int pathSum(TreeNode root )
    {
        if(root==null) return 0;
         
       
       
       
       int left = Math.max(pathSum(root.left), 0);
        int right = Math.max(pathSum(root.right), 0);
       
       int temp=Math.max(Math.max(left,right)+root.val,root.val);
       ans=Math.max(ans,left+right+root.val);
       
       return temp;
       
    }
}