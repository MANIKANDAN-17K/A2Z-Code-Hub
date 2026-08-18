/* 
Given the root of a binary tree, find the size of the largest subtree that is also a Binary Search Tree (BST). A subtree is considered a BST if, for every node in the subtree:

    All nodes in its left subtree have values less than the node's value.
    All nodes in its right subtree have values greater than the node's value.
    The subtree contains no duplicate values.

Return the number of nodes in the largest BST subtree.

Note: The size of a subtree is the total number of nodes it contains.

Examples :

Input: root = [5, 2, 4, 1, 3]
Output: 3




Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;
    public Node(int d) {
     data = d;
     left = right = null;
   }
} */
class Info{
   boolean isBST;
   int size;
   int min;
   int max;
   Info(boolean isBST,int size,int min,int max){
       this.isBST = isBST;
       this.size = size;
       this.min = min;
       this.max = max;
   }
}
class Solution {
    private Info solve(Node root){
        if(root == null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info left = solve(root.left);
        Info right = solve(root.right);
        if(left.isBST && right.isBST && root.data > left.max && root.data < right.min){
            return new Info(true,left.size + right.size + 1,
            Math.min(root.data,left.min), Math.max(root.data,right.max));
        }
        return new Info(false,Math.max(left.size,right.size),Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
   
    public int largestBst(Node root) {
        return solve(root).size;
    }
}
