package cn.ouc.jeff.leetcode.reverselist;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        //if(head==null || head.next==null) {
         //   return head;
        //}
        //这里的cur就是最后一个节点
        //ListNode cur = reverseList(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        //head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        //head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        //return cur;

        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev;
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
        listNode5.next = null;

        ListNode ln = reverseList(listNode1);
        System.out.println(ln);
    }

}
