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
    int index = 0;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        
        for(int i = 0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length, preorder);
    }
    
    public TreeNode helper(int left, int right, int[] preorder){
        if(left == right)
            return null;
        
        TreeNode node = new TreeNode(preorder[index]);
        
        int val = map.get(preorder[index]);
        index++;
        node.left = helper(left, val, preorder);
        node.right = helper(val+1, right, preorder);
        return node;
    }
}
