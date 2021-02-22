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
        ans = Integer.MIN_VALUE;
        int val = helper(root);
        return ans;
    }
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        
        int left_val = helper(root.left) + root.val;
        int right_val = helper(root.right) + root.val;
        
        
        ans = Math.max(ans, Math.max(root.val, Math.max(left_val, Math.max(right_val, left_val+right_val-root.val))));
        //System.out.println(ans);
        return Math.max(root.val, Math.max(left_val, right_val));
        
    }
}
