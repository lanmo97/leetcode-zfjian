package cn.ouc.jeff.leetcode.hasCycle;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}
public class HasCycle {
    public static boolean hasCycle(ListNode head){

        ListNode slowHead = head;
        ListNode fastHead = head.next;

        //快慢指针没有相遇
        while(slowHead != fastHead){
            // 快指针遇到 null，说明无循环
            if(fastHead.next == null || fastHead == null){
                return false;
            }
            slowHead = slowHead.next;
            fastHead = fastHead.next.next;

        }
        return true;
        /**
        while(head != null){
            if(head == head.next){
                return true;
            }
            if(head.next != null){
                head.next = head.next.next;
            }
            head = head.next;
        }
        return false;*/
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode2;

        Boolean ln = hasCycle(listNode1);
        System.out.println(ln);
    }

}
