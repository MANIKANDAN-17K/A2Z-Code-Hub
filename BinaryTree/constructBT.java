/*
Given two arrays representing the inorder and preorder traversals of a binary tree, construct the binary tree and return its root.

Note: The inorder and preorder traversals contain unique values, and every value present in the preorder traversal is also found in the inorder traversal.  

Examples:

Input: inorder[] = [3, 1, 4, 0, 5, 2], preorder[] = [0, 1, 3, 4, 2, 5]
Output: [0, 1, 2, 3, 4, 5]
*/


/* Structure of a Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    private static int search(int[] in,int v,int l,int r){
        for(int i = l;i<=r;i++){
            if(v == in[i]) return i;
        }
        return -1;
    }
    private static Node bTR(int[] in,int[] pre,int[] pidx,int l,int r){
        if(l > r) return null;
        int rootVal = pre[pidx[0]];
        pidx[0]++;
        Node root = new Node(rootVal);
        int idx = search(in,rootVal,l,r);
        root.left = bTR(in,pre,pidx,l,idx-1);
        root.right = bTR(in,pre,pidx,idx+1,r);
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[]) {
        int[] preIdx = {0};
        return bTR(inorder,preorder,preIdx,0,preorder.length - 1);
        
    }
}
