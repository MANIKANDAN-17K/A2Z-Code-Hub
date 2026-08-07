/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    private Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    private Node helper(Node head){
        int carry = 1;
        Node curr = head;
        Node res  = head;
        Node last = null;
        int sum;
        while(curr != null){
            sum = carry + curr.data;
            carry = sum/10;
            sum %= 10;
            curr.data = sum;
            last = curr;
            curr = curr.next;
            
        }
        if(carry > 0){
            last.next = new Node(carry);
        }
        return res;
    }
    public Node addOne(Node head) {
        head = reverse(head);
        head = helper(head);
        return reverse(head);
    }
}
