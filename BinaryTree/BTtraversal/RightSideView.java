/**

199. Binary Tree Right Side View


Given the root of a binary tree,
imagine yourself standing on the 
right side of it, return the values of the nodes
you can see ordered from top to bottom.

 

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:

Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:

Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []


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
        ArrayList<Integer> res = new ArrayList<>();
        rightView(root,res,0);
        return res;
    }
    private void rightView(TreeNode root,List<Integer> res,int currDep){
        if(root == null) return;
        if(currDep == res.size()) res.add(root.val);
        rightView(root.right,res,currDep + 1);
        rightView(root.left,res,currDep + 1);
    }
}
