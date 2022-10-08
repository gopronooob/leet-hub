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
    List<TreeNode> ans = new ArrayList<>();
    Map<String, Integer> counter = new HashMap<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrderTraverse(root);
        return ans;
    }
    
    String postOrderTraverse(TreeNode root) {
        if (root == null) {
            return "x";
        }
        String left = postOrderTraverse(root.left);
        String right = postOrderTraverse(root.right);
        String key = left + "," + right + "," + root.val;
        counter.put(key, counter.getOrDefault(key, 0) + 1);
        if (counter.get(key) == 2) {
            ans.add(root);
        }
        return key;
    }
}
