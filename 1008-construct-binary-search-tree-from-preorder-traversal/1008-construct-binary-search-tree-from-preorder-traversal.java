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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        if(preorder==null || preorder.length==0)
            return null;
        
        return constructTree(preorder,0,preorder.length-1);
        
    }
    
    TreeNode constructTree(int[] preOrder,int start,int end)
    {
            if(start>end )
        {
            return null;
        }
        
        
        TreeNode root= new TreeNode(preOrder[start]);
        int i;
        for( i=start;i<=end;i++)
        {
            if(preOrder[i]>preOrder[start])
            {
                //mid=i;
                break;
            }
 
        }
        root.left=constructTree(preOrder,start+1,i-1);
        root.right=constructTree(preOrder,i,end);
        return root;
    }
}