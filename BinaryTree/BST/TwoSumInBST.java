/**

653. Two Sum IV - Input is a BST

Given the root of a binary search tree and an integer k,
return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

 

Example 1:

Input: root = [5,3,6,2,4,null,7], k = 9
Output: true

Example 2:

Input: root = [5,3,6,2,4,null,7], k = 28
Output: false

 

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -104 <= Node.val <= 104
    root is guaranteed to be a valid binary search tree.
    -105 <= k <= 105

 

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
    private void buildInOrder(TreeNode root,ArrayList<Integer> res){
        if(root == null) return;
        buildInOrder(root.left,res);
        res.add(root.val);
        buildInOrder(root.right,res);
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        buildInOrder(root,inorder);
        int l = 0;
        int r = inorder.size() - 1;
        while(l < r){
            int res = inorder.get(l) + inorder.get(r);
            if(k == res) return true;
            else if(k < res) r--;
            else l++;
        }
        return false;
    }       
}
