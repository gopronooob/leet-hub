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
    List<List<Integer>> ans=new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    
        if(root==null)
        {
            return ans;
        }
        
        getPath(root,targetSum,new ArrayList<Integer>());
        
        return ans;
    }
    
    void getPath(TreeNode root,int targetSum,ArrayList<Integer> ansSoFar)
    {
       // if(targetSum<0) return;
        if(root==null)
        { 
            return;
        }
        
        
          //  System.out.println(ansSoFar+" "+root.val+" "+targetSum);
            ansSoFar.add(root.val);
        if(root.left==null && root.right==null && root.val==targetSum) ans.add(new ArrayList(ansSoFar));
         else {
            getPath(root.left,targetSum-root.val,ansSoFar);
            getPath(root.right,targetSum-root.val,ansSoFar);}
            ansSoFar.remove(ansSoFar.size()-1);
        }
        
    
}