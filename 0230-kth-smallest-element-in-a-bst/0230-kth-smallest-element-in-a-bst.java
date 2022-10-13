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
    ArrayList<Integer> arr=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        
         inOrder(root,arr);
        return arr.get(k-1);
    }
    
    void inOrder(TreeNode root,ArrayList<Integer> arr)
    {
        if(root==null)return;
        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
            
    }
}