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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder==null || inorder==null ||preorder.length==0|| inorder.length==0) return null;
        
        TreeNode root=new TreeNode(preorder[0]);
         
         int mid= IntStream.range(0, inorder.length)
            .filter(i -> preorder[0] == inorder[i])
            .findFirst()
             .orElse(-1);
        
      //  System.out.println(Arrays.toString(preorder)+" "+Arrays.toString(inorder)+" "+mid);
            
        root.left=buildTree(Arrays.copyOfRange(preorder, 1, 1+mid),Arrays.copyOfRange(inorder, 0, mid));
        root.right=buildTree(Arrays.copyOfRange(preorder, mid+1, preorder.length),Arrays.copyOfRange(inorder,mid+1, inorder.length)) ;
        return root;
        
    }
}
