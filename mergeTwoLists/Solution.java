package cn.ouc.jeff.leetcode.mergeTwoLists;

import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(4);

        list1.next = list2;
        list2.next = list3;

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode result = mergeTwoLists(list1, node1);
        System.out.println(result.toString());
    }
}
