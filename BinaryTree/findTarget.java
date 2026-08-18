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
    private void buildArray(TreeNode root,ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        buildArray(root.left,inorder);
        inorder.add(root.val);
        buildArray(root.right,inorder);
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        buildArray(root,inorder);
        int l = 0;
        int r = inorder.size() - 1;
        while(l < r){
            int currSum = inorder.get(l) + inorder.get(r);
            if(currSum == k) return true;
            else if(currSum > k) r--;
            else l++;
        }
        return false;
    }
}
