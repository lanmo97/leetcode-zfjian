package cn.ouc.jeff.leetcode.middleNode;
/**
 * leetcode：https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val =x;
    }
}

public class middleNodeSolution {
    public static ListNode middleNode(ListNode head) {
        ListNode listNode = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode middleNode = null;
        int length = 0;
        // 计算总长度
        while(listNode != null){
            listNode = listNode.next;
            length++;
        }

        if(length % 2 == 0){
            // 偶数
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            slow = dummy;
            fast = dummy;
            while(fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            slow = slow.next;
            middleNode = slow;

        }else {
            while(fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            middleNode = slow;
        }
        return middleNode;

    }

    public static void main(String[] args){

        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int i = 0;
        int n = 0;
        while(i<10){
            i++;
            ++n;
        }
        ListNode result = middleNode(node1);
        System.out.println(result.val);
    }
}
