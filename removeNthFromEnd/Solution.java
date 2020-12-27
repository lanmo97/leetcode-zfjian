package cn.ouc.jeff.leetcode.removeNthFromEnd;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 存储链表长度
        int count =0;
        // 用于遍历链表，破坏了链结构
        ListNode node = head;
        // 链表新增头节点，易于处理删除第一个结点的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //计算总个数
        while(node != null){
            node = node.next;
            count++;
        }

        node = dummy;
        int index = 0;
        // 当前序号小于 被删结点的前一个结点时，循环继续找
        // index == count-n 表示找到了被删结点的前一个结点，循环停止
        while(count-n > index){
            node = node.next;
            index++;
        }
        node.next = node.next.next;
        return dummy.next;

    }

    public static void main(String[] args){

        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode result = removeNthFromEnd(node1, 1);
        System.out.println(result);
    }
}
