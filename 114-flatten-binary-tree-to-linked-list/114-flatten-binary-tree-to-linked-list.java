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
TreeNode prev = null;
public void flatten(TreeNode root) {

        if(root == null) return;
    

    flattenTreeDFS(root);  
	}
    
    public TreeNode flattenTreeDFS(TreeNode root)
    {
        if(root==null) return null;
        
        TreeNode leftTail=flattenTreeDFS(root.left);
        TreeNode rightTail=flattenTreeDFS(root.right);
        
        if(leftTail!=null)
        {
            TreeNode temp=root.right;
            root.right=root.left;
            leftTail.right=temp;
            root.left=null;
        }
        
        if(rightTail !=null) return rightTail;
        if(leftTail !=null) return leftTail;
        
        return root;
        
        
    }
}