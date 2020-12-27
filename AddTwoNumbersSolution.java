package cn.ouc.jeff.leetcode;

import org.junit.Test;

import java.util.List;

public class AddTwoNumbersSolution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode result = new ListNode();
        int _val = 0, _jinwei = 0;

        //head = null;
        while(l1 != null || l2 != null){
            if(l1 == null) l1 = new ListNode(0);
            if(l2 == null) l2 = new ListNode(0);


            int value = l1.val+l2.val + _jinwei;

            _val = value % 10;
            result.next = new ListNode(_val);
            _jinwei = value / 10;

            if(head == null) {
                result = result.next;
                head = result;
            } else {
                result = result.next;
            }


            l1 = l1.next;
            l2 = l2.next;

            // 遍历完还有一个进位的话，需要继续新增最后一个节点
            if(l1 == null && l2==null){
                if(_jinwei > 0){
                    ListNode end = new ListNode();
                    end.val = _jinwei;
                    result.next = end;
                }
            }

        }

        return head;
    }

    public int listNodeLength(ListNode l){
        int length = 0;
        while(l != null){
            length++;
            l = l.next;
        }
        return length;
    }

    public ListNode addNode(ListNode l, int n){
        ListNode listNode = l;
        while(listNode.next !=null){
            listNode = listNode.next;
        }
        int k = 0;
        while(k<n){
            ListNode _node = new ListNode();
            _node.val = 0;
            listNode.next = _node;
            listNode = listNode.next;
            k++;
        }
        return l;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode l3 = new ListNode();
        ListNode l4 = new ListNode();
        ListNode l5 = new ListNode();
        ListNode l6 = new ListNode();
        ListNode l7 = new ListNode();

        l1.val = 9; l2.val = 9; l3.val = 9; l4.val = 9; l5.val = 9; l6.val = 9; l7.val = 9;
        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6; l6.next = l7;

        ListNode n1 = new ListNode();
        ListNode n2 = new ListNode();
        ListNode n3 = new ListNode();
        ListNode n4 = new ListNode();
        n1.val = 9; n2.val = 9; n3.val = 9; n4.val = 9;
        n1.next = n2; n2.next = n3; n3.next = n4;

        ListNode result = addTwoNumbers(l1, n1);

    }

}
