/**
106. Construct Binary Tree from Inorder and Postorder Traversal


Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree 
and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]

 

Constraints:

    1 <= inorder.length <= 3000
    postorder.length == inorder.length
    -3000 <= inorder[i], postorder[i] <= 3000
    inorder and postorder consist of unique values.
    Each value of postorder also appears in inorder.
    inorder is guaranteed to be the inorder traversal of the tree.
    postorder is guaranteed to be the postorder traversal of the tree.

 



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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length - 1,postorder,0,postorder.length - 1);
    }
    private TreeNode helper(int[] in,int inS,int inE,int[] post,int pS,int pE){
        if(inS > inE || pS > pE) return null;
        int rootVal = post[pE];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = 0;
        for(int i= inS ; i<=inE;i++){
            if(in[i] == rootVal){
                rootIdx = i;
                break;
            }
        }
        int lS= rootIdx - inS;
        int rS = inE - rootIdx;
        root.left = helper(in,inS,rootIdx - 1,post,pS,pS + lS - 1);
        root.right = helper(in,rootIdx +1,inE,post,pE - rS,pE - 1);
        return root;
    }
}
