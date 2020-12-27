package cn.ouc.jeff.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName ZigzagLevelOrderSolution
 * @Description 二叉树的锯齿形层序遍历
 * @Author Jeff_ZHU
 * @Date 2020/12/27 4:31 下午
 * @Version 1.0
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 输入是树，不是数组。所以没办法根据下标进行解决。
 *
 * 队列（Queue）：先进先出
 * 队列（Deque）：可以从两端插入
 *
 * 通过left、right 把左右孩子放进队列nodeQueue(Queue类型)。所以兄弟节点都在同一个队列。
 *
 * 对该队列进行循环，取节点，放在 deque(Deque类型)队列：放时判断是放队尾还是队首。
 *      nodeQueue 在使用 poll 、offer,因此循环前获得此次循环的次数。
 *
 * 同时，把节点的左右孩子节点再放进 nodeQueue.
 *
 * 兄弟节点的排序在 deque 队列完成，放入 ret 结果集。
 *
 * nodeQueue 不为空继续循环。
 */
public class ZigzagLevelOrderSolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        boolean isEven = true; // 偶数层，从左往右放，deque 队尾插入； 奇数层，从右往左放，deque 队首插入。
        nodeQueue.offer(root);

        while(!nodeQueue.isEmpty()){
            Deque<Integer> deque = new LinkedList<>();
            int size = nodeQueue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = nodeQueue.poll();
                if (isEven)
                    deque.offerLast(node.val);
                else
                    deque.offerFirst(node.val);

                if (node.left != null) {
                    nodeQueue.add(node.left);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                }
            }
            ret.add(new ArrayList<>(deque));
            isEven = !isEven;
        }
        return ret;
    }

    @Test
    public void test(){
        TreeNode treeNode0 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        zigzagLevelOrder(treeNode0);
    }
}
