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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> al=new ArrayList<>();
        inOrder(root,al);
        return balancedTree(al,0,al.size()-1);
    }
    
    void inOrder(TreeNode root,ArrayList<TreeNode> al)
    {
        if(root==null)
            return;
        
        inOrder(root.left,al);
        al.add(root);
        inOrder(root.right,al);
    }
    
    TreeNode balancedTree(ArrayList<TreeNode> al,int min,int max)
    { 
        if(min>max)
            return null;
        
        int mid=(max+min)/2;
        
        TreeNode root=al.get(mid);
        root.left=balancedTree(al,min,mid-1);
        root.right=balancedTree(al,mid+1,max);
        return root;
    }
}