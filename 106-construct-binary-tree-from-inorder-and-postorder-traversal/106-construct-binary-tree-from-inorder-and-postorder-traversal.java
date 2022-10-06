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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder==null || inorder==null ||postorder.length==0|| inorder.length==0) return null;
        
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
         
         int mid= IntStream.range(0, inorder.length)
            .filter(i -> postorder[postorder.length-1] == inorder[i])
            .findFirst()
             .orElse(-1);
        
       // System.out.println(Arrays.toString(inorder)+" "+Arrays.toString(postorder)+" "+mid);


        root.left=buildTree(Arrays.copyOfRange(inorder, 0, mid), Arrays.copyOfRange(postorder, 0, mid));
        root.right=buildTree(Arrays.copyOfRange(inorder, mid+1, inorder.length), Arrays.copyOfRange(postorder, mid, inorder.length-1));
        
        return root;
    }
}