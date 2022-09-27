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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
        
        buildRightView(ans,0,root);
        
        return ans;
    }
    
    void buildRightView(List<Integer> ans,int index,TreeNode root) {
        if(root==null) return;
        //System.out.println("working on ["+index+"]"+root.val);
        if (index == ans.size()) {
            ans.add(root.val);
            
        }
            
        buildRightView(ans,index+1,root.right);
        buildRightView(ans,index+1,root.left);
    }
}